package inventario.modelo;

public class UsuarioModel {
	
	public int idUsuario;
	public String apellido;    
	public String usuario;     
	public String contrasena;  
	public String nombre;
	public boolean isAdmin;
	public boolean getIfIsAdmin() {
		return isAdmin;
	}
	public void setIdUsuario(boolean is_admin) {	isAdmin = is_admin; }

	public String role;
	public String getRole() {
		return role;
	}
	public void setRole(String r) {	role = r; }


	public UsuarioModel(int idUsuario, String apellido, String usuario, String contrasena, String nombre) {
		super();
		this.idUsuario = idUsuario;
		this.apellido = apellido;
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.nombre = nombre;
	}


	
	public int getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getContrasena() {
		return contrasena;
	}


	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@Override
	public String toString() {
		return "UsuarioModel [idUsuario=" + idUsuario + ", apellido=" + apellido + ", usuario=" + usuario
				+ ", contrasena=" + contrasena + ", nombre=" + nombre + "]";
	}
	
	


	
}
