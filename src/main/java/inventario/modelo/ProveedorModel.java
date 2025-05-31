package inventario.modelo;

public class ProveedorModel {

	int idProveedor;
	String nombre;
	String apellido;
	String celular;
	
	
	public ProveedorModel(int idProveedor, String nombre, String apellido, String celular) {
		super();
		this.idProveedor = idProveedor;
		this.nombre = nombre;
		this.apellido = apellido;
		this.celular = celular;
	}


	
	public int getIdProveedor() {
		return idProveedor;
	}


	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getCelular() {
		return celular;
	}


	public void setCelular(String celular) {
		this.celular = celular;
	}


	@Override
	public String toString() {
		return "ProveedorModel [idProveedor=" + idProveedor + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", celular=" + celular + "]";
	}
	
	
	
	
}
