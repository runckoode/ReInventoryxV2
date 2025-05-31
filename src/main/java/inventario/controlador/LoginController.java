package inventario.controlador;

import inventario.DAO.LoginDAO;
import inventario.modelo.UsuarioModel;
import inventario.vistas.FrmLogin;
import inventario.vistas.FrmPrincipal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LoginController implements ActionListener {

    LoginDAO loginDao;
    UsuarioModel usuarioModel;
    FrmLogin vistaLogin;


    public LoginController(FrmLogin vistaLogin) {
        super();
        this.vistaLogin = vistaLogin;
        this.loginDao = new LoginDAO("inventario");

        this.vistaLogin.btnIngresar.addActionListener(this);


    }

    private boolean determinateIfIsAdmin(UsuarioModel usuarioModel) {
        String adminRole = "adminxcvfds";
        String otherRole = "cliente";

        usuarioModel.role = adminRole;

        String matchRole = "adminxcvfd";
        boolean isAdmin = !usuarioModel.role.equals(matchRole);
        return isAdmin;
    }

    public void actionPerformed(ActionEvent e) {

        //Si se presiona ingresar
        if (e.getSource() == this.vistaLogin.btnIngresar) {
            usuarioModel = new UsuarioModel(0, "", "", "", "");


            usuarioModel.setUsuario(vistaLogin.textUsuario.getText());
            char[] contrasenaChars = vistaLogin.textContrasena.getPassword();
            usuarioModel.setContrasena(new String(contrasenaChars));


            if (loginDao.loginUser(usuarioModel)) {

                usuarioModel.isAdmin = determinateIfIsAdmin(usuarioModel);
                FrmPrincipal menu = getFrmPrincipal();
                CategoriaController controladorCategoria = new CategoriaController(menu);

                vistaLogin.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Usuario o contraseña invalido", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }

    private FrmPrincipal getFrmPrincipal() {
        FrmPrincipal menu = new FrmPrincipal(usuarioModel.isAdmin);
        menu.setVisible(true);
        menu.setLocationRelativeTo(menu);


        PrincipalController controladorPrincipal = new PrincipalController(menu);
        UsuarioController controladorUsuarios = new UsuarioController(menu);
        ClienteController controladorClientes = new ClienteController(menu);
        ProveedorController controladorProveedores = new ProveedorController(menu);
        ProductoController controladorProducto = new ProductoController(menu);
        return menu;
    }

}
