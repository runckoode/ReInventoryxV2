package inventario.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import inventario.modelo.CategoriaModel;

public class CategoriaDAO extends Conexion {

    PreparedStatement ps;
    ResultSet rs;

    public CategoriaDAO(String inventario) {
        super(inventario);
    }

    //METODOS

    //GUARDAR
    public void agregar(CategoriaModel categoria) {
        String sentencia = "INSERT INTO tabla_categorias (nombre,descrpcion) VALUES (?,?)";

        try {
            ps = (PreparedStatement) this.getConnection().prepareStatement(sentencia);
            ps.setString(1, categoria.getNombre());
            ps.setString(2, categoria.getDescripcion());

            ps.executeUpdate();


        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, "No se pudo insertar la categoria");
            e.printStackTrace();
        }
    }


    //OBTENER LISTA DE CATEGORIAS
    public List<CategoriaModel> obtener() {
        List<CategoriaModel> categorias = new ArrayList<CategoriaModel>();

        String sentencia = "SELECT * FROM tabla_categorias";
        try {
            ps = (PreparedStatement) this.getConnection().prepareStatement(sentencia);
            rs = ps.executeQuery();

            while (rs.next()) {
                CategoriaModel categoria = new CategoriaModel(0, "", "");

                categoria.setIdCategoria(rs.getInt("idCategoria"));
                categoria.setNombre(rs.getString("nombre"));
                categoria.setDescripcion(rs.getString("descripcion"));

                categorias.add(categoria);
            }


        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, "No se pudo obtener la lista");
            e.printStackTrace();
        }

        return categorias;
    }


    //Buscar
    public CategoriaModel buscar(CategoriaModel catego) {
        String sentencia = "SELECT * FROM tabla_categorias WHERE idCategoria= " + catego.getIdCategoria();

        try {
            ps = (PreparedStatement) this.getConnection().prepareStatement(sentencia);
            rs = ps.executeQuery();

            while (rs.next()) {
                catego.setIdCategoria((rs.getInt("idCategoria")));
                catego.setNombre(rs.getString("nombre"));
                catego.setDescripcion(rs.getString("Descripcion"));

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al agregar lista");

        }

        return catego;

    }


    //UPDATE
    public void editar(CategoriaModel categoria) {
        String sentencia = "UPDATE tabla_categorias SET  nombre=?, descripcion=? WHERE idCategoria=?";

        try {
            ps = (PreparedStatement) this.getConnection().prepareStatement(sentencia);
            ps.setString(1, categoria.getNombre());
            ps.setString(2, categoria.getDescripcion());
            ps.setInt(3, categoria.getIdCategoria());

            ps.execute();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se pudo editar la categoria");
        }


    }


    //ELIMINAR
    public void eliminar(CategoriaModel categoria) {
        String sentencia = "delete from tabla_categorias where idCategoria= ?";

        try {
            ps = (PreparedStatement) this.getConnection().prepareStatement(sentencia);
            ps.setInt(1, categoria.getIdCategoria());


            ps.execute();


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se pudo eliminar");
        }


    }

}
