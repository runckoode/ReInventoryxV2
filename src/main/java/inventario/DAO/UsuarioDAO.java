package inventario.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import inventario.modelo.UsuarioModel;

public class UsuarioDAO extends Conexion {

    PreparedStatement ps;
    ResultSet rs;


    public UsuarioDAO(String inventario) {

        super(inventario);
    }


    //INICIO DE LOS METODOS

    //AGREGAR
    public void agregar(UsuarioModel usuario) {

        String sentencia = "INSERT INTO tabla_usuarios(nombre,apellido,usuario,contrasena)VALUES(?,?,?,?)";

        try {
            ps = (PreparedStatement) this.getConnection().prepareStatement(sentencia);
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellido());
            ps.setString(3, usuario.getUsuario());
            ps.setString(4, usuario.getContrasena());

            ps.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, "No se pudo insertar el usuario");
            e.printStackTrace();
        }

    }


    //obtener lista usuarios
    public List<UsuarioModel> obtener() {
        List<UsuarioModel> usuarios = new ArrayList<UsuarioModel>();
        String sentencia = "SELECT * FROM tabla_usuarios";

        try {
            ps = (PreparedStatement) this.getConnection().prepareStatement(sentencia);
            rs = ps.executeQuery();

            while (rs.next()) {
                UsuarioModel usuario = new UsuarioModel(0, "", "", "", "");

                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellido(rs.getString("Apellido"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setContrasena(rs.getString("contrasena"));


                usuarios.add(usuario);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }


    //Buscar
    public UsuarioModel buscar(UsuarioModel usua) {
        String sentencia = "SELECT * FROM tabla_usuarios where idUsuario= ?";

        try {
            ps = (PreparedStatement) this.getConnection().prepareStatement(sentencia);
            ps.setInt(1, usua.getIdUsuario());
            rs = ps.executeQuery();

            while (rs.next()) {
                usua.setIdUsuario((rs.getInt("idUsuario")));
                usua.setNombre(rs.getString("nombre"));
                usua.setApellido(rs.getString("Apellido"));
                usua.setUsuario(rs.getString("usuario"));
                usua.setContrasena(rs.getString("contrasena"));


            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al agregar lista");

        }

        return usua;

    }


    //EDITAR
    public void editar(UsuarioModel usuario) {
        String sentencia = "UPDATE tabla_usuarios SET nombre=?, apellido=?, usuario=?, contrasena=? WHERE idUsuario=?";
        try {

            ps = (PreparedStatement) this.getConnection().prepareStatement(sentencia);
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellido());
            ps.setString(3, usuario.getUsuario());
            ps.setString(4, usuario.getContrasena());
            ps.setInt(5, usuario.getIdUsuario());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //ELIMINAR
    public void eliminar(UsuarioModel usuario) {
        String sentencia = "DELETE * FROM tabla_usuarios WHERE idUsuario=?";

        try {
            ps = (PreparedStatement) this.getConnection().prepareStatement(sentencia);
            ps.setInt(1, usuario.getIdUsuario());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
