package inventario.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import inventario.modelo.ProductoModel;

public class ProductoDAO extends Conexion {

    PreparedStatement ps;
    ResultSet rs;

    public ProductoDAO(String inventario) {
        super(inventario);
        // TODO Auto-generated constructor stub
    }


    //INSERTAR
    public void insertar(ProductoModel producto) {
        String sentencia = "INSER INTO tabla_productos (nombre,precioCompra,cantidad,fechaCompra,fechaVencimiento,tipoMedida) VALUES (?,?,?,?,?,?))";

        try {
            ps = (PreparedStatement) this.getConnection().prepareStatement(sentencia);
            ps.setString(1, producto.getNombre());
            ps.setDouble(2, producto.getPrecioCompra());
            ps.setInt(3, producto.getCantidad());
            ps.setString(4, producto.getFechaCompra());
            ps.setString(5, producto.getFechaVencimiento());
            ps.setString(6, producto.getTipoMedida());

            ps.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo insertar la categoria");
            e.printStackTrace();
        }
    }


    //METODO OBTENER LISTA
    public List<ProductoModel> obtener() {
        List<ProductoModel> productos = new ArrayList<ProductoModel>();
        String sentencia = "SELECT * FROM tabla_productos";

        try {
            ps = (PreparedStatement) this.getConnection().prepareStatement(sentencia);
            rs = ps.executeQuery();

            while (rs.next()) {
                ProductoModel producto = new ProductoModel(
                        rs.getInt("idProducto"),
                        rs.getString("nombre"),
                        rs.getDouble("precioCompra"),
                        rs.getInt("cantidad"),
                        rs.getInt("idCategoria"),
                        rs.getInt("idProveedor"),
                        rs.getInt("cantidadStop"),
                        rs.getString("fechaCompra"),
                        rs.getString("fechaVencimiento"),
                        rs.getString("tipoMedida")
                );

                productos.add(producto);
            }

        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, "Error al establecer lista");
            e.printStackTrace();
        }

        return productos;
    }


    //METODO BUSCAR
    public ProductoModel buscar(ProductoModel producto) {
        String sentencia = "SELECT * FROM tabla_productos WHERE idProducto=?";

        try {
            ps = (PreparedStatement) this.getConnection().prepareStatement(sentencia);
            ps.setInt(1, producto.getIdProducto());
            rs = ps.executeQuery();

            while (rs.next()) {
                producto.setIdProducto(rs.getInt("idProducto"));
                producto.setNombre(rs.getString("nombre"));
                producto.setPrecioCompra(rs.getDouble("precioCompra"));
                producto.setCantidad(rs.getInt("cantidad"));
                producto.setIdCategoria(rs.getInt("idCategoria"));
                producto.setIdProveedor(rs.getInt("idProveedor"));
                producto.setCantidadStop(rs.getInt("cantidadStop"));
                producto.setFechaCompra(rs.getString("fechaCompra"));
                producto.setFechaVencimiento(rs.getString("fechaVencimiento"));
                producto.setTipoMedida(rs.getString("tipoMedida"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showConfirmDialog(null, "Error al buscar el producto");
        }
        return producto;
    }


    //METODO EDITAR
    public void editar(ProductoModel producto) {
        String sentencia = "UPDATE tabla_productos SET nombre=?, precioCompra=?, =?,fechaCompra=?, fechaVencimiento=?, tipoMedida=? WHERE idProducto=?";

        try {
            ps = (PreparedStatement) this.getConnection().prepareStatement(sentencia);
            ps.setString(1, producto.getNombre());
            ps.setDouble(2, producto.getPrecioCompra());
            ps.setString(3, producto.getFechaCompra());
            ps.setString(4, producto.getFechaVencimiento());
            ps.setString(5, producto.getTipoMedida());
            ps.setInt(6, producto.getIdProducto());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showConfirmDialog(null, "Error al editar el producto");
        }
    }


    //ELIMINAR
    public void eliminar(ProductoModel producto) {
        String sentencia = "DELETE FROM tabla_productos WHERE idproducto=?";

        try {
            ps = (PreparedStatement) this.getConnection().prepareStatement(sentencia);
            ps.setInt(1, producto.getIdProducto());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showConfirmDialog(null, "No se pudo eliminar el producto");
        }
    }


}
