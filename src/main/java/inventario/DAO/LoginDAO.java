package inventario.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.PreparedStatement;

import inventario.modelo.UsuarioModel;

public class LoginDAO extends Conexion {

	PreparedStatement ps;
	ResultSet rs;

	public LoginDAO(String inventario) {super(inventario);}

    public boolean loginUser(UsuarioModel usuario) {
        String query = "SELECT * FROM tabla_usuarios WHERE usuario = ? AND contrasena = ?";
        boolean existeUsuario = false; 

        try {
            ps =  getConnection().prepareStatement(query);
            ps.setString(1, usuario.getUsuario()); 
            ps.setString(2, usuario.getContrasena()); 

            rs = ps.executeQuery();

            if (rs.next()) {
                existeUsuario = true;
            }

            if (rs != null) rs.close(); 
            if (ps != null) ps.close(); 
            
        } catch (SQLException e) {
            e.printStackTrace(); 
        }

        return existeUsuario; 
    }
}	
	
	
	

