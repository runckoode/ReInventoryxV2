CREATE DATABASE IF NOT EXISTS inventario CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE inventario;

CREATE TABLE IF NOT EXISTS inventario.tabla_usuarios (
    idUsuario INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(40),
    apellido VARCHAR(40),
    usuario VARCHAR(50),
    contrasena VARCHAR(250) UNIQUE
);

CREATE TABLE IF NOT EXISTS inventario.tabla_categorias (
    idCategoria INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(180) NOT NULL
);

CREATE TABLE IF NOT EXISTS inventario.tabla_proveedores (
    idProveedor INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(40) NOT NULL,
    apellido VARCHAR(40) NOT NULL,
    celular VARCHAR(15) NOT NULL
);

CREATE TABLE IF NOT EXISTS inventario.tabla_clientes (
    idCliente INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    telefono VARCHAR(15),
    email VARCHAR(100) UNIQUE
);

CREATE TABLE IF NOT EXISTS inventario.tabla_productos (
    idProducto INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    precioCompra DECIMAL(10,2) NOT NULL,
    cantidad INT NOT NULL,
    idCategoria INT NOT NULL,
    idProveedor INT NOT NULL,
    cantidadStop INT NOT NULL,
    fechaCompra DATE,
    fechaVencimiento DATE,
    tipoMedida VARCHAR(30),
    FOREIGN KEY (idCategoria) REFERENCES inventario.tabla_categorias(idCategoria) ON UPDATE CASCADE ON DELETE RESTRICT,
    FOREIGN KEY (idProveedor) REFERENCES inventario.tabla_proveedores(idProveedor) ON UPDATE CASCADE ON DELETE RESTRICT
);

CREATE TABLE IF NOT EXISTS inventario.tabla_ventas (
    idVenta INT PRIMARY KEY AUTO_INCREMENT,
    idCliente INT NOT NULL,
    fechaVenta DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    total DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (idCliente) REFERENCES inventario.tabla_clientes(idCliente) ON UPDATE CASCADE ON DELETE RESTRICT
);

CREATE TABLE IF NOT EXISTS inventario.tabla_detalle_ventas (
    idDetalle INT PRIMARY KEY AUTO_INCREMENT,
    idVenta INT NOT NULL,
    idProducto INT NOT NULL,
    cantidad INT NOT NULL,
    precioUnitario DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (idVenta) REFERENCES inventario.tabla_ventas(idVenta) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (idProducto) REFERENCES inventario.tabla_productos(idProducto) ON UPDATE CASCADE ON DELETE RESTRICT
);


USE inventario;

CREATE TABLE IF NOT EXISTS inventario.tabla_tiempo (
    idTiempo INT PRIMARY KEY AUTO_INCREMENT,
    fecha DATE NOT NULL UNIQUE,
    dia INT NOT NULL,
    mes INT NOT NULL,
    anio INT NOT NULL,
    trimestre INT NOT NULL,
    nombreDia VARCHAR(20) NOT NULL,
    nombreMes VARCHAR(20) NOT NULL,
    diaDeSemana INT NOT NULL,
    semanaDelAnio INT NOT NULL,
    esFinDeSemana BOOLEAN NOT NULL
);

CREATE TABLE IF NOT EXISTS inventario.tabla_compras (
    idCompra INT PRIMARY KEY AUTO_INCREMENT,
    idProveedor INT NOT NULL,
    fechaCompra DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    numeroFacturaProveedor VARCHAR(50),
    totalCompra DECIMAL(10,2) NOT NULL,
    observaciones TEXT,
    FOREIGN KEY (idProveedor) REFERENCES inventario.tabla_proveedores(idProveedor) ON UPDATE CASCADE ON DELETE RESTRICT
);

CREATE TABLE IF NOT EXISTS inventario.tabla_detalle_compras (
    idDetalleCompra INT PRIMARY KEY AUTO_INCREMENT,
    idCompra INT NOT NULL,
    idProducto INT NOT NULL,
    cantidad INT NOT NULL,
    precioUnitarioCompra DECIMAL(10,2) NOT NULL,
    subtotal DECIMAL(10,2) AS (cantidad * precioUnitarioCompra) STORED,
    FOREIGN KEY (idCompra) REFERENCES inventario.tabla_compras(idCompra) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (idProducto) REFERENCES inventario.tabla_productos(idProducto) ON UPDATE CASCADE ON DELETE RESTRICT
);

CREATE TABLE IF NOT EXISTS inventario.tabla_movimientos_stock (
    idMovimientoStock INT PRIMARY KEY AUTO_INCREMENT,
    idProducto INT NOT NULL,
    fechaMovimiento DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    tipoMovimiento ENUM('ENTRADA_COMPRA', 'SALIDA_VENTA', 'AJUSTE_POSITIVO', 'AJUSTE_NEGATIVO', 'DEVOLUCION_CLIENTE', 'DEVOLUCION_PROVEEDOR', 'INICIAL') NOT NULL,
    cantidad INT NOT NULL,
    idReferencia INT,
    observacion VARCHAR(255),
    stockAnterior INT,
    stockNuevo INT,
    FOREIGN KEY (idProducto) REFERENCES inventario.tabla_productos(idProducto) ON UPDATE CASCADE ON DELETE RESTRICT
);

-- El siguiente bloque para poblar tabla_tiempo se mantiene comentado
-- ya que es un ejemplo de DML (Data Manipulation Language) y no DDL (Data Definition Language)
-- y el usuario solicitó las tablas funcionales (definiciones).
-- Si deseas ejecutarlo, puedes descomentarlo.

-- INSERT INTO tabla_tiempo (fecha, dia, mes, anio, trimestre, nombreDia, nombreMes, diaDeSemana, semanaDelAnio, esFinDeSemana)
-- SELECT
--     d AS fecha,
--     DAY(d) AS dia,
--     MONTH(d) AS mes,
--     YEAR(d) AS anio,
--     QUARTER(d) AS trimestre,
--     DAYNAME(d) AS nombreDia,
--     MONTHNAME(d) AS nombreMes,
--     DAYOFWEEK(d) AS diaDeSemana,
--     WEEKOFYEAR(d) AS semanaDelAnio,
--     (DAYOFWEEK(d) IN (1,7)) AS esFinDeSemana
-- FROM (
--     SELECT DATE_ADD('2020-01-01', INTERVAL n.number DAY) AS d
--     FROM (
--         SELECT (a.N + b.N * 10 + c.N * 100 + e.N * 1000) AS number
--         FROM (SELECT 0 AS N UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL SELECT 5 UNION ALL SELECT 6 UNION ALL SELECT 7 UNION ALL SELECT 8 UNION ALL SELECT 9) AS a
--         CROSS JOIN (SELECT 0 AS N UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL SELECT 5 UNION ALL SELECT 6 UNION ALL SELECT 7 UNION ALL SELECT 8 UNION ALL SELECT 9) AS b
--         CROSS JOIN (SELECT 0 AS N UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL SELECT 5 UNION ALL SELECT 6 UNION ALL SELECT 7 UNION ALL SELECT 8 UNION ALL SELECT 9) AS c
--         CROSS JOIN (SELECT 0 AS N UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL SELECT 5 UNION ALL SELECT 6 UNION ALL SELECT 7 UNION ALL SELECT 8 UNION ALL SELECT 9) AS e
--     ) AS n
--     WHERE DATE_ADD('2020-01-01', INTERVAL n.number DAY) < '2031-01-01'
-- ) fechas_generadas;
