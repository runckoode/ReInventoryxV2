package inventario.controlador;


import inventario.DAO.UsuarioDAO;
import inventario.modelo.UsuarioModel;
import inventario.vistas.FrmPrincipal;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UsuarioController implements ActionListener {

    FrmPrincipal frame;
    UsuarioDAO usuarioDao;
    UsuarioModel usuarioModel;


    public UsuarioController(FrmPrincipal frame) {
        super();
        this.frame = frame;

        usuarioDao = new UsuarioDAO("inventario");


        this.frame.vistaUsuarios.btnAgregarUsuario.addActionListener(this);
        this.frame.vistaUsuarios.btnBuscarUsuario.addActionListener(this);
        this.frame.vistaUsuarios.btnEditarUsuario.addActionListener(this);
        this.frame.vistaUsuarios.btnEliminar.addActionListener(this);

        llenarTablaUsuarios(this.frame.vistaUsuarios.tablaUsuarios);


    }


    //ACCIONES
    public void actionPerformed(ActionEvent e) {


        //Agregar
        if (e.getSource() == this.frame.vistaUsuarios.btnAgregarUsuario) {


            usuarioModel = new UsuarioModel(0,
                    this.frame.vistaUsuarios.textNombre.getText(),
                    this.frame.vistaUsuarios.textApellido.getText(),
                    this.frame.vistaUsuarios.textUsuario.getText(),
                    new String(this.frame.vistaUsuarios.textPassword.getPassword())

            );

            if (
                    !this.frame.vistaUsuarios.textNombre.getText().equals("") &&
                            !this.frame.vistaUsuarios.textApellido.getText().equals("") &&
                            !this.frame.vistaUsuarios.textUsuario.getText().equals("") &&
                            this.frame.vistaUsuarios.textPassword.getPassword().length > 0) {

                usuarioDao.agregar(usuarioModel);


                llenarTablaUsuarios(this.frame.vistaUsuarios.tablaUsuarios);
                borrarCampos();


                JOptionPane.showMessageDialog(null, "!Usuario agregado con exito");

            } else {

                JOptionPane.showMessageDialog(null, "!Invalido!Debes llenar todos los campos");
            }
        }//fin de agregar usuario


        //Buscar
        if (e.getSource() == this.frame.vistaUsuarios.btnBuscarUsuario) {
            try {
                int fila = this.frame.vistaUsuarios.tablaUsuarios.getSelectedRow();

                int id = Integer.parseInt((String) this.frame.vistaUsuarios.tablaUsuarios.getValueAt(fila, 0));
                System.out.print(id);


                usuarioModel = new UsuarioModel(id, "", "", "", "");


                usuarioDao.buscar(usuarioModel);


                this.frame.vistaUsuarios.textId.setText(usuarioDao.buscar(usuarioModel).getIdUsuario() + "");
                this.frame.vistaUsuarios.textNombre.setText(usuarioDao.buscar(usuarioModel).getNombre());
                this.frame.vistaUsuarios.textApellido.setText(usuarioDao.buscar(usuarioModel).getApellido());
                this.frame.vistaUsuarios.textUsuario.setText(usuarioDao.buscar(usuarioModel).getUsuario());


            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "!Invalido!Debes seleccionar una fila");
            }
        }


        //Editar
        if (e.getSource() == this.frame.vistaUsuarios.btnEditarUsuario) {
            try {
                int idUsuario = Integer.parseInt(this.frame.vistaUsuarios.textId.getText());

                usuarioModel = new UsuarioModel(idUsuario, this.frame.vistaUsuarios.textId.getText(),
                        this.frame.vistaUsuarios.textNombre.getText(),
                        this.frame.vistaUsuarios.textApellido.getText(),
                        this.frame.vistaUsuarios.textUsuario.getText());
                this.frame.vistaUsuarios.textPassword.getPassword();

                boolean userIsNotEmpty = !this.frame.vistaUsuarios.textNombre.getText().equals("") &&
                        !this.frame.vistaUsuarios.textApellido.getText().equals("") &&
                        !this.frame.vistaUsuarios.textUsuario.getText().equals("") &&
                        !this.frame.vistaUsuarios.textPassword.getPassword().equals("");

                if (userIsNotEmpty) {
                    usuarioDao.editar(usuarioModel);

                    llenarTablaUsuarios(this.frame.vistaUsuarios.tablaUsuarios);
                    borrarCampos();

                    JOptionPane.showMessageDialog(null, "!usuario editado con exito");

                } else {

                    JOptionPane.showMessageDialog(null, "!El usuario no pudo ser editado");
                }
            } catch (Exception exe) {
                exe.printStackTrace();
                JOptionPane.showMessageDialog(null, "!Invalido!Debes seleccionar una fila");
            }
        }

        if (e.getSource() == this.frame.vistaUsuarios.btnEliminar) {

            int fila = this.frame.vistaUsuarios.tablaUsuarios.getSelectedRow();
            System.out.print(fila);


            int id = Integer.parseInt((String) this.frame.vistaUsuarios.tablaUsuarios.getValueAt(fila, 0));

            System.out.print(id);

            String empty = "";
            usuarioModel = new UsuarioModel(id, empty,empty,empty,empty);


            usuarioDao.buscar(usuarioModel);
            usuarioDao.eliminar(usuarioModel);
            this.frame.vistaUsuarios.textId.setText(usuarioDao.buscar(usuarioModel).getIdUsuario() + empty);
            this.frame.vistaUsuarios.textNombre.setText(usuarioDao.buscar(usuarioModel).getNombre());
            this.frame.vistaUsuarios.textApellido.setText(usuarioDao.buscar(usuarioModel).getApellido());
            this.frame.vistaUsuarios.textUsuario.setText(usuarioDao.buscar(usuarioModel).getUsuario());
            this.frame.vistaUsuarios.textPassword.setText(usuarioDao.buscar(usuarioModel).getContrasena());


            llenarTablaUsuarios(this.frame.vistaUsuarios.tablaUsuarios);
            borrarCampos();

            JOptionPane.showMessageDialog(null, "!usuario eliminado con exito");


        }


    }//fin de mis acciones


    //Metodo llenar tabla
    public void llenarTablaUsuarios(JTable tablaUsuarios) {
        DefaultTableModel modelo = (DefaultTableModel) tablaUsuarios.getModel();


        modelo.setRowCount(0);

        for (UsuarioModel usua : usuarioDao.obtener()) {


            String[] fila = {
                    String.valueOf(usua.getIdUsuario()),
                    usua.getNombre(),
                    usua.getApellido(),
                    usua.getUsuario(),
                    usua.getContrasena(),

            };

            modelo.addRow(fila);
        }
    }


    public void borrarCampos() {
        this.frame.vistaUsuarios.textNombre.setText("");
        this.frame.vistaUsuarios.textApellido.setText("");
        this.frame.vistaUsuarios.textUsuario.setText("");
        this.frame.vistaUsuarios.textPassword.setText("");

    }


}//Fin de mi clase
