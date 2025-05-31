function ConvertToDottedDecimalMask {
    param(
        [Parameter(Mandatory=$true)]
        [int]$PrefixLength
    )
    if ($PrefixLength -lt 0 -or $PrefixLength -gt 32) {
        return "N/A"
    }
    if ($PrefixLength -eq 0) {
        return "0.0.0.0"
    }

    $shiftAmount = 32 - $PrefixLength
    $maskIntValue = ([System.UInt32]::MaxValue) -shl $shiftAmount


    $o1 = ($maskIntValue -shr 24) -band 0xFF
    $o2 = ($maskIntValue -shr 16) -band 0xFF
    $o3 = ($maskIntValue -shr 8) -band 0xFF
    $o4 = $maskIntValue -band 0xFF
    
    return "$o1.$o2.$o3.$o4"
}

$aliasBuscado = "vEthernet (WSL (Hyper-V firewall))"
$ipv4 = $null
$DisplayEnv = $null 

Write-Host "Buscando interfaz con alias: $aliasBuscado"
$interfazEspecifica = Get-NetIPConfiguration -InterfaceAlias $aliasBuscado -ErrorAction SilentlyContinue

if ($interfazEspecifica) {
    $indiceInterfaz = $interfazEspecifica.InterfaceIndex
    
    Write-Host "`n--- Detalles para la interfaz con Alias '$aliasBuscado' (Índice: $indiceInterfaz) ---"
    Write-Host "InterfaceAlias         : $($interfazEspecifica.InterfaceAlias)"
    Write-Host "InterfaceIndex         : $($interfazEspecifica.InterfaceIndex)"
    Write-Host "InterfaceDescription   : $($interfazEspecifica.InterfaceDescription)"

    $ipv4Collection = $interfazEspecifica.IPv4Address
    $ipv4PrincipalObjeto = $null

    if ($ipv4Collection) {
        $ipv4PrincipalObjeto = $ipv4Collection | Where-Object {$_.AddressState -eq 'Preferred'} | Select-Object -First 1
        if (-not $ipv4PrincipalObjeto) {
            $ipv4PrincipalObjeto = $ipv4Collection | Select-Object -First 1
        }
    }

    if ($ipv4PrincipalObjeto -and $ipv4PrincipalObjeto.IPAddress) {
        $ipv4 = $ipv4PrincipalObjeto.IPAddress
        
        Write-Host "IPv4Address.IPAddress  : $($ipv4)"
        Write-Host "Máscara de Subred      : $(ConvertToDottedDecimalMask $ipv4PrincipalObjeto.PrefixLength)"

        if ($interfazEspecifica.IPv4DefaultGateway -and $interfazEspecifica.IPv4DefaultGateway.NextHop) {
            Write-Host "IPv4DefaultGateway     : $($interfazEspecifica.IPv4DefaultGateway.NextHop)"
        } else {
            Write-Host "IPv4DefaultGateway     : No configurada"
        }

        if ($interfazEspecifica.DNSServer -and $interfazEspecifica.DNSServer.ServerAddresses) {
            Write-Host "DNSServer              : $($interfazEspecifica.DNSServer.ServerAddresses -join ', ')"
        } else {
            Write-Host "DNSServer              : No configurados"
        }

        $netAdapterInfo = Get-NetAdapter -InterfaceIndex $indiceInterfaz -ErrorAction SilentlyContinue
        if ($netAdapterInfo) {
            Write-Host "Estado del Adaptador   : $($netAdapterInfo.Status)"
            $netConnectionProfile = $interfazEspecifica | Get-NetConnectionProfile -ErrorAction SilentlyContinue
            if ($netConnectionProfile) {
                Write-Host "Nombre del Perfil      : $($netConnectionProfile.Name)"
            } else {
                Write-Host "Nombre del Perfil      : No disponible"
            }
        }
    } else {
        Write-Host "IPv4Address.IPAddress  : No configurada para '$aliasBuscado'"
        Write-Host "Máscara de Subred      : N/A"
    }
} else {
    Write-Warning "No se encontró ninguna interfaz con el Alias '$aliasBuscado'."
}

if ($ipv4) {
    Write-Host "`nLa dirección IPv4 detectada para '$aliasBuscado' es: $ipv4"
    $DisplayEnv = "$($ipv4):0"
} else {
    Write-Warning "`nNo se pudo detectar una dirección IPv4 para '$aliasBuscado'."
}

$ContainerName = 'java-appx'
$JavaOptions = '-Dawt.useSystemAAFontSettings=lcd -Dswing.defaultlaf=com.sun.java.swing.plaf.gtk.GTKLookAndFeel'
$NetworkMode = 'host'
$AddHostEntry = 'host.docker.internal:host-gateway'

$dockerArgs = @(
    'run',
    '-it',
    '--rm'
)

$dockerArgs += '-e', "_JAVA_OPTIONS=$JavaOptions"
# Solo añade -e DISPLAY si $DisplayEnv tiene un valor (basado en $ipv4)
if ($DisplayEnv) { 
    $dockerArgs += '-e', "DISPLAY=$DisplayEnv"
    Write-Host "Se utilizará DISPLAY=$DisplayEnv para el contenedor."
} else {
    Write-Warning "La variable DISPLAY no se pasará al contenedor Docker, ya que no se obtuvo una IP para '$aliasBuscado' o DisplayEnv no se configuró."
}

$dockerArgs += '--network', $NetworkMode
$dockerArgs += '--add-host', $AddHostEntry
$dockerArgs += $ContainerName

Write-Host "Ejecutando comando: docker $($dockerArgs -join ' ')"

try {
    & docker $dockerArgs
}
catch {
    Write-Error "Ocurrió un error al intentar ejecutar el contenedor docker: $($_.Exception.Message)"
}

Write-Host "Script finalizado."