package inventario.modelo;

public class ClienteModel {

	
	//Atributos
private int idCliente;
private String nombre;
private String apellido;
private String telefono;
private String email;

//Constructor
public ClienteModel(int idCliente, String nombre, String apellido, String telefono, String email) {
	super();
	this.idCliente = idCliente;
	this.nombre = nombre;
	this.apellido = apellido;
	this.telefono = telefono;
	this.email = email;
}

public int getIdCliente() {
	return idCliente;
}

public void setIdCliente(int idCliente) {
	this.idCliente = idCliente;
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

public String getTelefono() {
	return telefono;
}

public void setTelefono(String telefono) {
	this.telefono = telefono;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}



@Override
public String toString() {
	return "ClienteModel [idCliente=" + idCliente + ", nombre=" + nombre + ", apellido=" + apellido + ", telefono="
			+ telefono + ", email=" + email + "]";
}


	
}
