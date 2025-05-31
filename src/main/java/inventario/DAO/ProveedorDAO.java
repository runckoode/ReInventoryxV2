package inventario.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException; 
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import inventario.modelo.ProveedorModel;

public class ProveedorDAO extends Conexion{
	PreparedStatement ps;
	ResultSet rs;
	
	public ProveedorDAO(String inventario)
	{
		super(inventario);
	}
	
	
	//METODO INSERTAR
	public void agregar(ProveedorModel proveedor) {
		String sentencia= "INSERT INTO tabla_proveedores (nombre,apellido,celular) VALUES (?,?,?)";
		
		try {
			ps=(PreparedStatement) this.getConnection().prepareStatement(sentencia);
			ps.setString(1, proveedor.getNombre());
			ps.setString(2, proveedor.getApellido());
			ps.setString(3, proveedor.getCelular());
			
			ps.executeUpdate();
			
		}catch(SQLException e)
		{
			JOptionPane.showMessageDialog(null, "No se pudo insertar la categoria");
			e.printStackTrace();
		}
	}
	
	
	//METODO OBTENER
	public List<ProveedorModel> obtener()
	{
		List<ProveedorModel> proveedores= new ArrayList<ProveedorModel>();
		String sentencia= "SELECT * FROM tabla_proveedores";
		
		try {
			ps=(PreparedStatement) this.getConnection().prepareStatement(sentencia);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				ProveedorModel proveedor= new ProveedorModel(0,"","","");
				
				proveedor.setIdProveedor(rs.getInt("idProveedor"));
				proveedor.setNombre(rs.getString("nombre"));
				proveedor.setApellido(rs.getString("apellido"));
				proveedor.setCelular(rs.getString("celular"));
				
				proveedores.add(proveedor);
			}
			
		}catch(SQLException e)
		{
			JOptionPane.showConfirmDialog(null, "Error al obtener la lista de productos");
			e.printStackTrace();
		}
		return proveedores;
	}
	
	//METODO BUSCAR
	public ProveedorModel buscar(ProveedorModel proveedor)
	{
		String sentencia= "SELECT * FROM tabla_proveedores where idProveedor= " +proveedor.getIdProveedor();	
		
		try
		{
			ps= (PreparedStatement) this.getConnection().prepareStatement(sentencia);
			rs= ps.executeQuery();
			
			while(rs.next())
			{	
				proveedor.setIdProveedor((rs.getInt("idProveedor")));
				proveedor.setNombre(rs.getString("nombre"));
				proveedor.setApellido(rs.getString("apellido"));
				proveedor.setCelular(rs.getString("celular"));
									
			}
			
		}catch(SQLException e)
		{
			JOptionPane.showMessageDialog(null,"Error al buscar proveedor");
			
		}
		
		return proveedor;
	
	}
	
	//METODO EDITAR
	public void editar(ProveedorModel proveedor)
	{
		String sentencia= "UPDATE tabla_proveedores SET nombre=?, apellido=?, celular=? WHERE idProveedor=?";
		
		try {
			ps=(PreparedStatement) this.getConnection().prepareStatement(sentencia);
			ps.setString(1, proveedor.getNombre());
			ps.setString(2, proveedor.getApellido());
			ps.setString(3, proveedor.getCelular());
			ps.setInt(4, proveedor.getIdProveedor());
			
			ps.executeUpdate();
			
			
		}catch(SQLException e)
		{
			JOptionPane.showMessageDialog(null,"No se pudo editar el proveedor");
			e.printStackTrace();
		}
	
	}
	
	
	//METODO ELIMINAR
	public void eliminar(ProveedorModel proveedor)
	{
		String sentencia= "DELETE FROM tabla_proveedores WHERE idProveedor=?";
		
		try {
			ps=(PreparedStatement) this.getConnection().prepareStatement(sentencia);
			ps.setInt(1, proveedor.getIdProveedor());
			
			ps.executeUpdate();
			
		}catch(SQLException e)
		{
			JOptionPane.showMessageDialog(null,"No se pudo eliminar el proveedor");
			e.printStackTrace();
		}
	}


}
