package inventario.vistas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import java.awt.Cursor;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.net.URL;

public class FrmLogin extends JFrame {

    public static final long serialVersionUID = 1L;
    public JPanel contentPane;
    public JTextField textUsuario;
    public JPasswordField textContrasena;
    public JButton btnIngresar;

    private JLabel lblErrorUsuario;
    private JLabel lblErrorContrasena;

    private final Color colorPrimario = new Color(0xA0C4FF); // Un azul pastel suave (ej. #A0C4FF)
    private final Color colorTextoPrimario = new Color(0x424242); // Gris oscuro para texto principal (ej. Material Grey 800 #424242)
    private final Color colorFondoPanelDerecho = new Color(0xF5F5F5); // Gris muy claro para fondos (Material Grey 100 #F5F5F5)
    private final Color colorTextoEtiqueta = new Color(0x616161); // Gris medio para etiquetas (Material Grey 700 #616161)
    private final Color colorBordeInputNormal = new Color(0xBDBDBD); // Gris claro para bordes (Material Grey 400 #BDBDBD)
    private final Color colorBordeInputFoco = new Color(0x64B5F6); // Un azul un poco más vibrante para foco (Material Blue 300 #64B5F6) o puedes usar colorPrimario
    private final Color colorError = new Color(0xFF8A80); // Rojo pastel para errores (Material Red A100 #FF8A80)



    public FrmLogin() {
        setTitle("Inicio de Sesión");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 420);
        setResizable(false);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panelFondo = new JPanel();
        panelFondo.setBounds(0, 0, 586, 380);
        contentPane.add(panelFondo);
        panelFondo.setLayout(null);

        // --- Panel Izquierdo (Branding) ---
        JPanel panelIzquierdo = new JPanel();
        panelIzquierdo.setBackground(Color.WHITE);
        panelIzquierdo.setBounds(0, 0, 292, 380);
        panelFondo.add(panelIzquierdo);
        panelIzquierdo.setLayout(null);

        JLabel lblImagenVentas = new JLabel("");
        try {
            // Ruta absoluta desde la raíz del classpath (asumiendo img en src/main/resources/img)
            URL imgUrlVentas = FrmLogin.class.getResource("/img/cajaInvent.jpg");
            if (imgUrlVentas != null) {
                lblImagenVentas.setIcon(new ImageIcon(imgUrlVentas));
            } else {
                System.err.println("Advertencia: Imagen /img/cajaInvent.jpg no encontrada en el classpath.");
                lblImagenVentas.setText("Img no encontrada");
            }
        } catch (Exception e) {
            System.err.println("Excepción al cargar imagen /img/cajaInvent.jpg: " + e.getMessage());
            e.printStackTrace();
        }
        lblImagenVentas.setBounds(55, 40, 182, 201);
        lblImagenVentas.setHorizontalAlignment(JLabel.CENTER);
        panelIzquierdo.add(lblImagenVentas);

        JLabel lblNombreNegocio = new JLabel("SUPERMARKET");
        lblNombreNegocio.setForeground(new Color(50, 50, 50));
        lblNombreNegocio.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNombreNegocio.setHorizontalAlignment(JLabel.CENTER);
        lblNombreNegocio.setBounds(10, 250, 272, 47);
        panelIzquierdo.add(lblNombreNegocio);

        JLabel lblNombreProgramador = new JLabel("Soft. Engine 2");
        lblNombreProgramador.setForeground(new Color(100, 100, 100));
        lblNombreProgramador.setFont(new Font("Tahoma", Font.PLAIN, 11));
        lblNombreProgramador.setHorizontalAlignment(JLabel.CENTER);
        lblNombreProgramador.setBounds(10, 340, 272, 20);
        panelIzquierdo.add(lblNombreProgramador);


        JPanel panelDerecho = new JPanel();
        panelDerecho.setBackground(colorFondoPanelDerecho);
        panelDerecho.setBounds(292, 0, 294, 380);
        panelFondo.add(panelDerecho);
        panelDerecho.setLayout(null);

        JLabel lblImagenInicio = new JLabel("");
        try {

            URL imgUrlUser = FrmLogin.class.getResource("/img/user1.png");
            if (imgUrlUser != null) {
                lblImagenInicio.setIcon(new ImageIcon(imgUrlUser));
            } else {
                System.err.println("Advertencia: Imagen /img/user1.png no encontrada en el classpath.");
                lblImagenInicio.setText("User Img X");
            }
        } catch (Exception e) {
            System.err.println("Excepción al cargar imagen /img/user1.png: " + e.getMessage());
            e.printStackTrace();
        }
        lblImagenInicio.setBounds(80, 20, 135, 137);
        lblImagenInicio.setHorizontalAlignment(JLabel.CENTER);
        panelDerecho.add(lblImagenInicio);

        JLabel lblUsuarioIcono = new JLabel("");
        try {
            // Ruta absoluta desde la raíz del classpath
            URL imgUrlUserIcon = FrmLogin.class.getResource("/img/user2.png");
            if (imgUrlUserIcon != null) {
                lblUsuarioIcono.setIcon(new ImageIcon(imgUrlUserIcon));
            } else {
                System.err.println("Advertencia: Imagen /img/user2.png no encontrada en el classpath.");
            }
        } catch (Exception e) {
            System.err.println("Excepción al cargar imagen /img/user2.png: " + e.getMessage());
        }
        lblUsuarioIcono.setBounds(25, 175, 32, 32);
        panelDerecho.add(lblUsuarioIcono);

        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblUsuario.setForeground(colorTextoEtiqueta);
        lblUsuario.setBounds(65, 176, 70, 30);
        panelDerecho.add(lblUsuario);

        textUsuario = new JTextField();
        textUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textUsuario.setForeground(new Color(30, 30, 30));
        textUsuario.setBackground(Color.WHITE);
        textUsuario.setBounds(65, 205, 200, 30);
        panelDerecho.add(textUsuario);
        textUsuario.setColumns(10);

        lblErrorUsuario = new JLabel("El usuario es requerido.");
        lblErrorUsuario.setForeground(colorError);
        lblErrorUsuario.setFont(new Font("Tahoma", Font.PLAIN, 11));
        lblErrorUsuario.setBounds(65, 237, 200, 15);
        lblErrorUsuario.setVisible(false);
        panelDerecho.add(lblErrorUsuario);

        JLabel lblPasswordIcono = new JLabel("");
        try {
            // Ruta absoluta desde la raíz del classpath
            URL imgUrlPassIcon = FrmLogin.class.getResource("/img/password.png");
            if (imgUrlPassIcon != null) {
                lblPasswordIcono.setIcon(new ImageIcon(imgUrlPassIcon));
            } else {
                System.err.println("Advertencia: Imagen /img/password.png no encontrada en el classpath.");
            }
        } catch (Exception e) {
            System.err.println("Excepción al cargar imagen /img/password.png: " + e.getMessage());
        }
        lblPasswordIcono.setBounds(25, 255, 32, 32);
        panelDerecho.add(lblPasswordIcono);

        JLabel lblPassword = new JLabel("Contraseña:");
        lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblPassword.setForeground(colorTextoEtiqueta);
        lblPassword.setBounds(65, 256, 100, 30);
        panelDerecho.add(lblPassword);

        textContrasena = new JPasswordField();
        textContrasena.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textContrasena.setForeground(new Color(30, 30, 30));
        textContrasena.setBackground(Color.WHITE);
        textContrasena.setBounds(65, 285, 200, 30);
        panelDerecho.add(textContrasena);

        lblErrorContrasena = new JLabel("La contraseña es requerida.");
        lblErrorContrasena.setForeground(colorError);
        lblErrorContrasena.setFont(new Font("Tahoma", Font.PLAIN, 11));
        lblErrorContrasena.setBounds(65, 317, 200, 15);
        lblErrorContrasena.setVisible(false);
        panelDerecho.add(lblErrorContrasena);

        btnIngresar = new JButton("INGRESAR");
        btnIngresar.setForeground(colorTextoPrimario);
        btnIngresar.setBackground(colorPrimario);
        btnIngresar.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnIngresar.setFocusPainted(false);
        btnIngresar.setBounds(65, 340, 200, 35);
        btnIngresar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnIngresar.setBorder(BorderFactory.createEmptyBorder(8,15,8,15));
        panelDerecho.add(btnIngresar);

        addFocusListenerToField(textUsuario, colorBordeInputNormal, colorBordeInputFoco);
        addFocusListenerToField(textContrasena, colorBordeInputNormal, colorBordeInputFoco);

        setLocationRelativeTo(null);
    }


    private void addFocusListenerToField(JTextField field, Color normalColor, Color focusColor) {
        field.setBorder(BorderFactory.createCompoundBorder(
                new MatteBorder(0, 0, 1, 0, normalColor),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)
        ));

        field.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                field.setBorder(BorderFactory.createCompoundBorder(
                        new MatteBorder(0, 0, 2, 0, focusColor),
                        BorderFactory.createEmptyBorder(5, 5, 5, 5)
                ));
            }

            @Override
            public void focusLost(FocusEvent e) {
                field.setBorder(BorderFactory.createCompoundBorder(
                        new MatteBorder(0, 0, 1, 0, normalColor),
                        BorderFactory.createEmptyBorder(5, 5, 5, 5)
                ));
            }
        });
    }


    public boolean performValidation() {
        boolean isValid = true;
        String username = textUsuario.getText().trim();
        String password = new String(textContrasena.getPassword()).trim();

        lblErrorUsuario.setVisible(false);
        lblErrorContrasena.setVisible(false);

        if (username.isEmpty()) {
            lblErrorUsuario.setText("El usuario es requerido.");
            lblErrorUsuario.setVisible(true);
            isValid = false;
        }

        if (password.isEmpty()) {
            lblErrorContrasena.setText("La contraseña es requerida.");
            lblErrorContrasena.setVisible(true);
            isValid = false;
        }
        return isValid;
    }

    public JTextField getTextUsuario() {
        return textUsuario;
    }

    public JPasswordField getTextContrasena() {
        return textContrasena;
    }

    public JButton getBtnIngresar() {
        return btnIngresar;
    }

    public JLabel getLblErrorUsuario() {
        return lblErrorUsuario;
    }

    public JLabel getLblErrorContrasena() {
        return lblErrorContrasena;
    }

}
