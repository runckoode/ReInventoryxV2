package inventario.vistas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import inventario.controlador.PrincipalController;
// import java.awt.Color; // No más colores personalizados aquí
import javax.swing.JButton;
import java.awt.Font; // Se podría quitar si no se usa ninguna fuente personalizada
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import javax.swing.Box;

import java.awt.event.ActionListener;

public class FrmPrincipal extends JFrame {

	public static final long serialVersionUID = 1L;

	public static final int ANCHO_MINIMO_PANEL_IZQUIERDO = 230;
	public static final int ALTO_PREFERIDO_BOTON_NAVEGACION = 50;
	public static final int ALTO_PREFERIDO_LOGO = 120;
	public static final int ALTO_PANEL_TEMA = 50;


	public JPanel contentPane;
	public JPanel panelIzquierdo;
	public JPanel panelVistasPaneles;

	public JButton btnProductos;
	public JButton btnReportes;
	public JButton btnCategorias;
	public JButton btnProveedores;
	public JButton btnClientes;
	public JButton btnUsuarios; // Se creará condicionalmente


	public PanelProductos vistaProductos;
	public PanelCategorias vistaCategorias;
	public PanelReportes vistaReportes;
	public PanelUsuarios vistaUsuarios;
	public PanelClientes vistaClientes;
	public PanelProveedores vistaProveedores;

	public static final String PANEL_PRODUCTOS_VIEW = "PRODUCTOS_VIEW";
	public static final String PANEL_CATEGORIAS_VIEW = "CATEGORIAS_VIEW";
	public static final String PANEL_REPORTES_VIEW = "REPORTES_VIEW";
	public static final String PANEL_USUARIOS_VIEW = "USUARIOS_VIEW";
	public static final String PANEL_CLIENTES_VIEW = "CLIENTES_VIEW";
	public static final String PANEL_PROVEEDORES_VIEW = "PROVEEDORES_VIEW";

	public CardLayout cardLayoutVistas;
	public PrincipalController principalController;
	public final String TITULO_BASE_APP = "Sistema de Gestión de Inventario - YHWH";

	private boolean isAdminUser; // Campo para almacenar el rol del usuario


	public FrmPrincipal(boolean isAdmin) { // Constructor modificado
		this.isAdminUser = isAdmin;
		setTitle(TITULO_BASE_APP);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(900, 650));
		setSize(1200, 800);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		initComponents();
		initVistaPanels();

		try {
			principalController = new PrincipalController(this);
		} catch (Throwable e) {
			System.err.println("Advertencia: PrincipalController no encontrado o no se pudo instanciar. Usando listeners de prueba.");
			principalController = null;
		}
		asignarActionListeners();

		mostrarPanel(PANEL_PRODUCTOS_VIEW);
	}

	public void initComponents() {
		JPanel panelTema = new JPanel();
		panelTema.setPreferredSize(new Dimension(0, ALTO_PANEL_TEMA));
		panelTema.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 8));
		contentPane.add(panelTema, BorderLayout.NORTH);

		JLabel lblTema = new JLabel("ÁREA DE GESTIÓN SUPERMARKET");
		try {
			java.net.URL imgUrlTema = FrmPrincipal.class.getResource("img/anadir.png"); // Considerar cambiar este icono si es genérico
			if (imgUrlTema != null) {
				lblTema.setIcon(new ImageIcon(imgUrlTema));
			} else {
				System.err.println("Error al cargar icono para el tema: /img/anadir.png no encontrado en classpath.");
			}
		} catch (Exception e) {
			System.err.println("Excepción al cargar icono para el tema: /img/anadir.png - " + e.getMessage());
		}
		panelTema.add(lblTema);

		panelIzquierdo = new JPanel(new GridBagLayout());
		panelIzquierdo.setPreferredSize(new Dimension(ANCHO_MINIMO_PANEL_IZQUIERDO + 20, 0));
		panelIzquierdo.setMinimumSize(new Dimension(ANCHO_MINIMO_PANEL_IZQUIERDO, 0));
		contentPane.add(panelIzquierdo, BorderLayout.WEST);

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(15, 10, 10, 10);
		gbc.anchor = GridBagConstraints.CENTER;

		JLabel lblLogo = new JLabel();
		try {
			java.net.URL imgUrlLogo = FrmPrincipal.class.getResource("/img/InventarioIza.png");
			if (imgUrlLogo != null) {
				ImageIcon originalIcon = new ImageIcon(imgUrlLogo);
				Image image = originalIcon.getImage();
				if (originalIcon.getIconHeight() > 0) {
					int newWidth = (int) (((double) ALTO_PREFERIDO_LOGO / originalIcon.getIconHeight()) * originalIcon.getIconWidth());
					if (newWidth > 0 ) {
						Image scaledImage = image.getScaledInstance(newWidth, ALTO_PREFERIDO_LOGO, Image.SCALE_SMOOTH);
						lblLogo.setIcon(new ImageIcon(scaledImage));
					} else {
						lblLogo.setIcon(originalIcon);
					}
				} else {
					lblLogo.setIcon(originalIcon);
				}
			} else {
				System.err.println("Error al cargar logo: /img/InventarioIza.png no encontrado en classpath.");
				lblLogo.setText("Logo");
			}
		} catch (Exception e) {
			System.err.println("Excepción al cargar logo: /img/InventarioIza.png - " + e.getMessage());
			lblLogo.setText("Error Logo");
		}
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		panelIzquierdo.add(lblLogo, gbc);

		gbc.gridy = GridBagConstraints.RELATIVE;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 1.0;
		gbc.insets = new Insets(8, 10, 8, 10);
		gbc.anchor = GridBagConstraints.LINE_START;

		btnProductos = crearBotonNavegacion("Productos", "/img/producto.png", PANEL_PRODUCTOS_VIEW);
		panelIzquierdo.add(btnProductos, gbc);

		btnCategorias = crearBotonNavegacion("Categorías", "/img/categorias.png", PANEL_CATEGORIAS_VIEW);
		panelIzquierdo.add(btnCategorias, gbc);

		btnClientes = crearBotonNavegacion("Clientes", "/img/cliente.png", PANEL_CLIENTES_VIEW);
		panelIzquierdo.add(btnClientes, gbc);

		btnProveedores = crearBotonNavegacion("Proveedores", "/img/nuevo-cliente.png", PANEL_PROVEEDORES_VIEW);
		panelIzquierdo.add(btnProveedores, gbc);

		if (this.isAdminUser) { // Condición para mostrar el botón Usuarios
			btnUsuarios = crearBotonNavegacion("Usuarios", "/img/usuario.png", PANEL_USUARIOS_VIEW);
			panelIzquierdo.add(btnUsuarios, gbc);
		} // Si no es admin, btnUsuarios permanecerá null y no se añadirá.

		btnReportes = crearBotonNavegacion("Reportes", "/img/reporte1.png", PANEL_REPORTES_VIEW);
		panelIzquierdo.add(btnReportes, gbc);

		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.VERTICAL;
		panelIzquierdo.add(Box.createVerticalGlue(), gbc);

		panelVistasPaneles = new JPanel();
		cardLayoutVistas = new CardLayout();
		panelVistasPaneles.setLayout(cardLayoutVistas);
		contentPane.add(panelVistasPaneles, BorderLayout.CENTER);
	}

	public JButton crearBotonNavegacion(String texto, String rutaIcono, String actionCommand) {
		JButton boton = new JButton(texto);
		try {
			if (rutaIcono != null && !rutaIcono.isEmpty()) {
				java.net.URL imgUrl = FrmPrincipal.class.getResource(rutaIcono);
				if (imgUrl != null) {
					ImageIcon originalIcon = new ImageIcon(imgUrl);
					Image image = originalIcon.getImage();
					int iconSize = 24;
					if (originalIcon.getIconWidth() > iconSize || originalIcon.getIconHeight() > iconSize) {
						Image scaledImage = image.getScaledInstance(iconSize, iconSize, Image.SCALE_SMOOTH);
						boton.setIcon(new ImageIcon(scaledImage));
					} else {
						boton.setIcon(originalIcon);
					}
				} else {
					System.err.println("Error al cargar icono para el botón '" + texto + "': " + rutaIcono + " no encontrado en classpath.");
				}
			}
		} catch (Exception e) {
			System.err.println("Excepción al cargar icono para el botón '" + texto + "': " + rutaIcono + " - " + e.getMessage());
		}

		boton.setFocusPainted(false);
		boton.setPreferredSize(new Dimension(ANCHO_MINIMO_PANEL_IZQUIERDO - 40, ALTO_PREFERIDO_BOTON_NAVEGACION));
		boton.setMinimumSize(new Dimension(150, ALTO_PREFERIDO_BOTON_NAVEGACION));
		boton.setHorizontalAlignment(SwingConstants.LEFT);
		boton.setIconTextGap(15);
		boton.setActionCommand(actionCommand);
		return boton;
	}

	public void initVistaPanels() {
		vistaProductos = new PanelProductos();
		panelVistasPaneles.add(vistaProductos, PANEL_PRODUCTOS_VIEW);

		vistaCategorias = new PanelCategorias();
		panelVistasPaneles.add(vistaCategorias, PANEL_CATEGORIAS_VIEW);

		vistaClientes = new PanelClientes();
		panelVistasPaneles.add(vistaClientes, PANEL_CLIENTES_VIEW);

		vistaProveedores = new PanelProveedores();
		panelVistasPaneles.add(vistaProveedores, PANEL_PROVEEDORES_VIEW);

		vistaUsuarios = new PanelUsuarios();
		panelVistasPaneles.add(vistaUsuarios, PANEL_USUARIOS_VIEW);

		vistaReportes = new PanelReportes();
		panelVistasPaneles.add(vistaReportes, PANEL_REPORTES_VIEW);
	}

	public void asignarActionListeners() {
		ActionListener defaultListener = e -> {
			boolean isNull = e.getActionCommand() == null;
			if (isNull) {
				return;
			}
			mostrarPanel(e.getActionCommand());
		};

		if (principalController != null) {
			validateProductsIsNotNull(principalController);
		} else {
			validateProductsIsNotNull(defaultListener);
		}
	}

	private void validateProductsIsNotNull(ActionListener listener) {
		if (btnProductos != null) btnProductos.addActionListener(listener);
		if (btnCategorias != null) btnCategorias.addActionListener(listener);
		if (btnClientes != null) btnClientes.addActionListener(listener);
		if (btnProveedores != null) btnProveedores.addActionListener(listener);
		if (btnUsuarios != null) btnUsuarios.addActionListener(listener);
		if (btnReportes != null) btnReportes.addActionListener(listener);
	}

	public void mostrarPanel(String nombrePanel) {
		if (panelVistasPaneles == null || cardLayoutVistas == null || nombrePanel == null) {
			System.err.println("Error al intentar mostrar panel: componentes no inicializados o nombre de panel nulo.");
			return;
		}
		cardLayoutVistas.show(panelVistasPaneles, nombrePanel);
		String tituloSeccion = nombrePanel.replace("_VIEW", "").replace("_", " ");

		String[] parts = tituloSeccion.split(" ");
		StringBuilder sb = new StringBuilder();
		for (String part : parts) {
			if (part.length() > 0) {
				sb.append(part.substring(0, 1).toUpperCase()).append(part.substring(1).toLowerCase()).append(" ");
			}
		}
		tituloSeccion = sb.toString().trim();
		setTitle(TITULO_BASE_APP + " - " + tituloSeccion);
	}

	@Override
	public JPanel getContentPane() { return contentPane; }
	public JPanel getPanelIzquierdo() { return panelIzquierdo; }
	public JPanel getPanelVistasPaneles() { return panelVistasPaneles; }
	public JButton getBtnProductos() { return btnProductos; }
	public JButton getBtnReportes() { return btnReportes; }
	public JButton getBtnCategorias() { return btnCategorias; }
	public JButton getBtnProveedores() { return btnProveedores; }
	public JButton getBtnClientes() { return btnClientes; }
	public JButton getBtnUsuarios() { return btnUsuarios; }
	public PanelProductos getVistaProductos() { return vistaProductos; }
	public PanelCategorias getVistaCategorias() { return vistaCategorias; }
	public PanelClientes getVistaClientes() { return vistaClientes; }
	public PanelProveedores getVistaProveedores() { return vistaProveedores; }
	public PanelUsuarios getVistaUsuarios() { return vistaUsuarios; }
	public PanelReportes getVistaReportes() { return vistaReportes; }
	public CardLayout getCardLayoutVistas() { return cardLayoutVistas; }
	public PrincipalController getPrincipalController() { return principalController; }
	public String getTITULO_BASE_APP() { return TITULO_BASE_APP; }

}
