package inventario.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import inventario.modelo.ClienteModel;


public class ClienteDAO extends Conexion {

    PreparedStatement ps;
    ResultSet rs;


    public ClienteDAO(String inventario) {
        super(inventario);

    }


    //metodos


    //Agregar un cliente
    public void agregar(ClienteModel cliente) {
        String sentencia = "insert into tabla_clientes (nombre,apellido,telefono,email) values(?,?,?,?)";

        try {
            ps = (PreparedStatement) this.getConnection().prepareStatement(sentencia);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setString(3, cliente.getTelefono());
            ps.setString(4, cliente.getEmail());

            ps.executeUpdate();


        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo insertar el cliente");

            e.printStackTrace();
        }

    }


    //obtener lista clientes
    public List<ClienteModel> obtener() {
        List<ClienteModel> clientes = new ArrayList<ClienteModel>();

        String sentencia = "SELECT * FROM tabla_clientes";

        try {
            ps = (PreparedStatement) this.getConnection().prepareStatement(sentencia);
            rs = ps.executeQuery();

            while (rs.next()) {
                ClienteModel cliente = new ClienteModel(0, "", "", "", "");

                cliente.setIdCliente((rs.getInt("idCliente")));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("Apellido"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setEmail(rs.getString("email"));


                clientes.add(cliente);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clientes;

    }


    //Buscar
    public ClienteModel buscar(ClienteModel cli) {
        String sentencia = "SELECT * FROM tabla_clientes where idCliente= " + cli.getIdCliente();

        try {
            ps = (PreparedStatement) this.getConnection().prepareStatement(sentencia);
            rs = ps.executeQuery();

            while (rs.next()) {
                cli.setIdCliente((rs.getInt("idCliente")));
                cli.setNombre(rs.getString("nombre"));
                cli.setApellido(rs.getString("Apellido"));
                cli.setTelefono(rs.getString("telefono"));
                cli.setEmail(rs.getString("email"));


            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al agregar lista");

        }

        return cli;

    }


    //UPDATE
    public void editar(ClienteModel cliente) {
        String sentencia = "update tabla_clientes set  nombre=?, apellido=?,telefono=?,email=?  where idCliente=?";

        try {
            ps = (PreparedStatement) this.getConnection().prepareStatement(sentencia);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setString(3, cliente.getTelefono());
            ps.setString(4, cliente.getEmail());
            ps.setInt(5, cliente.getIdCliente());

            ps.execute();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }


    //delete
    public void eliminar(ClienteModel cliente) {
        String sentencia = "delete from tabla_clientes where idCliente= ?";

        try {
            ps = (PreparedStatement) this.getConnection().prepareStatement(sentencia);
            ps.setInt(1, cliente.getIdCliente());


            ps.execute();


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se pudo eliminar");
        }


    }


}
