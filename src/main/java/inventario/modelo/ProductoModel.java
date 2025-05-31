package inventario.modelo;

public class ProductoModel {

	private int idProducto;
	private String nombre;
	private double precioCompra;
	private int cantidad;
	private int idCategoria;
	private int idProveedor;
	private int cantidadStop;
	private String fechaCompra;
	private String fechaVencimiento;
	private String tipoMedida;
	
	
	public ProductoModel(int idProducto, String nombre, double precioCompra, int cantidad, int idCategoria,
			int idProveedor, int cantidadStop, String fechaCompra, String fechaVencimiento, String tipoMedida) {
		super();
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.precioCompra = precioCompra;
		this.cantidad = cantidad;
		this.idCategoria = idCategoria;
		this.idProveedor = idProveedor;
		this.cantidadStop = cantidadStop;
		this.fechaCompra = fechaCompra;
		this.fechaVencimiento = fechaVencimiento;
		this.tipoMedida = tipoMedida;
	}


	
	public int getIdProducto() {
		return idProducto;
	}


	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public double getPrecioCompra() {
		return precioCompra;
	}


	public void setPrecioCompra(double precioCompra) {
		this.precioCompra = precioCompra;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public int getIdCategoria() {
		return idCategoria;
	}


	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}


	public int getIdProveedor() {
		return idProveedor;
	}


	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}


	public int getCantidadStop() {
		return cantidadStop;
	}


	public void setCantidadStop(int cantidadStop) {
		this.cantidadStop = cantidadStop;
	}


	public String getFechaCompra() {
		return fechaCompra;
	}


	public void setFechaCompra(String fechaCompra) {
		this.fechaCompra = fechaCompra;
	}


	public String getFechaVencimiento() {
		return fechaVencimiento;
	}


	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}


	public String getTipoMedida() {
		return tipoMedida;
	}


	public void setTipoMedida(String tipoMedida) {
		this.tipoMedida = tipoMedida;
	}



	@Override
	public String toString() {
		return "ProductoModel [idProducto=" + idProducto + ", nombre=" + nombre + ", precioCompra=" + precioCompra
				+ ", cantidad=" + cantidad + ", idCategoria=" + idCategoria + ", idProveedor=" + idProveedor
				+ ", cantidadStop=" + cantidadStop + ", fechaCompra=" + fechaCompra + ", fechaVencimiento="
				+ fechaVencimiento + ", tipoMedida=" + tipoMedida + "]";
	}
	
	
	
	
	
	
	
}