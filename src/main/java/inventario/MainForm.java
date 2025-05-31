package inventario;

import inventario.controlador.LoginController;
import inventario.vistas.FrmLogin;
import mdlaf.MaterialLookAndFeel;
import mdlaf.themes.MaterialOceanicTheme;
import javax.swing.*;
import java.awt.*;

public class MainForm {
    public static void main(String[] args)  {

        EventQueue.invokeLater(() -> {
            try {


                UIManager.setLookAndFeel(new MaterialLookAndFeel());
                FrmLogin loginFrame = new FrmLogin();

                loginFrame.setResizable(true);
                loginFrame.setVisible(true);

                loginFrame.setLocationRelativeTo(null);

                LoginController usuarioController = new LoginController(loginFrame);

                boolean loginFrameHasErrors = usuarioController.equals(null);
                if(loginFrameHasErrors){
                    JOptionPane.showMessageDialog(null,
                                        usuarioController.getClass().toString(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                }

            } catch (Exception e) {
                e.fillInStackTrace();
            }
        });
    }
}