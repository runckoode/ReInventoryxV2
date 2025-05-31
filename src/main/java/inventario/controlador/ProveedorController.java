package inventario.controlador;

import inventario.DAO.ProveedorDAO;
import inventario.modelo.ProveedorModel;
import inventario.vistas.FrmPrincipal;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProveedorController implements ActionListener {

    FrmPrincipal frame;
    ProveedorDAO proveedorDao;
    ProveedorModel proveedorModel;

    public ProveedorController(FrmPrincipal frame) {
        super();
        this.frame = frame;

        proveedorDao = new ProveedorDAO("inventario");

        this.frame.vistaProveedores.btnAgregar.addActionListener(this);
        this.frame.vistaProveedores.btnBuscar.addActionListener(this);
        this.frame.vistaProveedores.btnEditar.addActionListener(this);
        this.frame.vistaProveedores.btnEliminar.addActionListener(this);

        llenarTablaProveedores(this.frame.vistaProveedores.tablaProveedores);
    }

    // ACCIONES
    public void actionPerformed(ActionEvent e) {

        // Agregar Proveedor
        if (e.getSource() == this.frame.vistaProveedores.btnAgregar) {
            String nombre = this.frame.vistaProveedores.textNombre.getText();
            String apellido = this.frame.vistaProveedores.textApellido.getText();
            String celular = this.frame.vistaProveedores.textCelular.getText();

            if (!nombre.isEmpty() && !apellido.isEmpty() && !celular.isEmpty()) {
                proveedorModel = new ProveedorModel(0, nombre, apellido, celular);

                proveedorDao.agregar(proveedorModel);

                llenarTablaProveedores(this.frame.vistaProveedores.tablaProveedores);
                borrarCampos();

                JOptionPane.showMessageDialog(null, "¡Proveedor: " + proveedorModel.getNombre() + " agregado con éxito!");
            } else {
                JOptionPane.showMessageDialog(null, "¡Inválido! Debes llenar todos los campos.");
            }
        }

        // Buscar Proveedor
        if (e.getSource() == this.frame.vistaProveedores.btnBuscar) {
            try {
                int fila = this.frame.vistaProveedores.tablaProveedores.getSelectedRow();
                int id = Integer.parseInt((String) this.frame.vistaProveedores.tablaProveedores.getValueAt(fila, 0));

                proveedorModel = new ProveedorModel(id, "", "", "");
                proveedorDao.buscar(proveedorModel);

                this.frame.vistaProveedores.textId.setText(proveedorDao.buscar(proveedorModel).getIdProveedor() + "");
                this.frame.vistaProveedores.textNombre.setText(proveedorDao.buscar(proveedorModel).getNombre());
                this.frame.vistaProveedores.textApellido.setText(proveedorDao.buscar(proveedorModel).getApellido());
                this.frame.vistaProveedores.textCelular.setText(proveedorDao.buscar(proveedorModel).getCelular());

            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "¡Inválido! Debes seleccionar una fila.");
            }
        }

        // Editar Proveedor
        if (e.getSource() == this.frame.vistaProveedores.btnEditar) {
            try {
                String nombre = this.frame.vistaProveedores.textNombre.getText().trim();
                String apellido = this.frame.vistaProveedores.textApellido.getText().trim();
                String celular = this.frame.vistaProveedores.textCelular.getText().trim();

                if (!nombre.isEmpty() && !apellido.isEmpty() && !celular.isEmpty()) {
                    try {
                        int idProveedor = Integer.parseInt(this.frame.vistaProveedores.textId.getText().trim());

                        proveedorModel = new ProveedorModel(idProveedor, nombre, apellido, celular);
                        proveedorDao.editar(proveedorModel);

                        llenarTablaProveedores(this.frame.vistaProveedores.tablaProveedores);
                        borrarCampos();

                        JOptionPane.showMessageDialog(null, "¡Proveedor: " + proveedorModel.getNombre() + " editado con éxito!");
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "¡Error! Verifica que los datos sean numéricos donde corresponda.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "¡Inválido! Debes llenar todos los campos.");
                }
            } catch (Exception exe) {
                exe.printStackTrace();
                JOptionPane.showMessageDialog(null, "¡Inválido! Debes seleccionar un proveedor.");
            }
        }

        // Eliminar Proveedor
        if (e.getSource() == this.frame.vistaProveedores.btnEliminar) {
            try {
                int fila = this.frame.vistaProveedores.tablaProveedores.getSelectedRow();
                int id = Integer.parseInt((String) this.frame.vistaProveedores.tablaProveedores.getValueAt(fila, 0));

                proveedorModel = new ProveedorModel(id, "", "", "");
                proveedorDao.eliminar(proveedorModel);

                llenarTablaProveedores(this.frame.vistaProveedores.tablaProveedores);
                borrarCampos();

                JOptionPane.showMessageDialog(null, "¡Proveedor eliminado con éxito!");
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "¡Inválido! Debes seleccionar una fila.");
            }
        }
    }

    // Método para llenar la tabla de proveedores
    public void llenarTablaProveedores(JTable tablaProveedores) {
        DefaultTableModel modelo = (DefaultTableModel) tablaProveedores.getModel();

        // Limpiamos las filas previas
        modelo.setRowCount(0);

        // Recorremos la lista de proveedores y agregamos las filas correspondientes
        for (ProveedorModel proveedor : proveedorDao.obtener()) {
            String[] fila = {
                String.valueOf(proveedor.getIdProveedor()),
                proveedor.getNombre(),
                proveedor.getApellido(),
                proveedor.getCelular()
            };

            // Agregar la fila al src.modelo de la tabla
            modelo.addRow(fila);
        }
    }

    // Método para borrar los campos de texto
    public void borrarCampos() {
        this.frame.vistaProveedores.textId.setText("");
        this.frame.vistaProveedores.textNombre.setText("");
        this.frame.vistaProveedores.textApellido.setText("");
        this.frame.vistaProveedores.textCelular.setText("");
    }
}