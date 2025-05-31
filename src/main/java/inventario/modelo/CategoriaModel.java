package inventario.modelo;

public class CategoriaModel {

	private int idCategoria;
	private String nombre;
	private String descripcion;
	
	
	
	public CategoriaModel(int idCategoria, String nombre, String descripcion) {
		super();
		this.idCategoria = idCategoria;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}



	public int getIdCategoria() {
		return idCategoria;
	}



	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	@Override
	public String toString() {
		return "CategoriaModel [idCategoria=" + idCategoria + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ "]";
	}
	
	
	
	
	
	
}
