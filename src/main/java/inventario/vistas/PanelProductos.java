package inventario.vistas;

import com.github.pervoj.jiconfont.FontAwesomeSolid;
import jiconfont.swing.IconFontSwing;

import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
// import java.awt.Graphics2D; // No se usa directamente para rendering personalizado aquí
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
// import java.awt.RenderingHints; // No se usa directamente para rendering personalizado aquí
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
// import java.awt.event.MouseAdapter; // No más hover effects
// import java.awt.event.MouseEvent;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder; // Se usa para el borde del scrollPane
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.text.JTextComponent;
import java.awt.BorderLayout;



public class PanelProductos extends JPanel {

	private static final long serialVersionUID = 1L;

	// --- Colores (Simplificados, la mayoría serán manejados por el L&F) ---
	// private static final Color COLOR_PRIMARY = new Color(0x3F51B5);
	// private static final Color COLOR_PRIMARY_HOVER = new Color(0x3949AB);
	// private static final Color COLOR_PRIMARY_LIGHT = new Color(0xC5CAE9);
	// private static final Color COLOR_ACCENT = new Color(0xFFC107);
	// private static final Color COLOR_ACCENT_HOVER = new Color(0xFFB300);
	// private static final Color COLOR_BUTTON_DEFAULT_BG = new Color(0xDFDFDF);
	// private static final Color COLOR_BUTTON_DEFAULT_HOVER = new Color(0xD0D0D0);
	// private static final Color COLOR_BACKGROUND_PANEL = new Color(0xFFFAFAFA);
	// private static final Color COLOR_SURFACE_CARD = Color.WHITE;

	private static final Color COLOR_TEXT_NEGRO = Color.BLACK; // Color de texto principal
	private static final Color COLOR_PLACEHOLDER = new Color(0x9E9E9E); // Color para placeholder
	private static final Color COLOR_DIVIDER_POR_DEFECTO = new Color(0xE0E0E0); // Un color de divisor si el L&F no lo define claramente
	// private static final Color COLOR_INPUT_BORDER_FOCUSED = COLOR_PRIMARY; // El L&F debería manejar el foco
	// private static final Color COLOR_ERROR = new Color(0xD32F2F);


	// --- Fuentes (Se pueden mantener o dejar que el L&F las maneje) ---
	// Es buena práctica definir fuentes base si se quiere consistencia,
	// pero el L&F de Material podría sobreescribirlas.
	private static final Font FONT_LABEL = new Font("SansSerif", Font.PLAIN, 13);
	private static final Font FONT_INPUT = new Font("SansSerif", Font.PLAIN, 14);
	private static final Font FONT_BUTTON = new Font("SansSerif", Font.BOLD, 13);
	private static final Font FONT_PANEL_TITLE = new Font("SansSerif", Font.BOLD, 18);
	private static final Font FONT_TABLE_HEADER = new Font("SansSerif", Font.BOLD, 12);
	private static final Font FONT_TABLE_CELL = new Font("SansSerif", Font.PLAIN, 12);

	public JTextField textNombre;
	public JTextField textCantidadStop;
	public JTextField textPrecioCompra;
	public JTextField textCantidadIngresada;
	public JTextField textIdCategoria;
	public JTextField textId;

	public JButton btnAgregar;
	public JButton btnEditar;
	public JButton btnBuscar;
	public JButton btnEliminar;
	public JTable tablaProductos;
	private JScrollPane scrollPaneTabla;
	public JTextField textFechaCompra;
	public JTextField textIdProveedor;
	public JTextField textFechaVencimiento;

	@SuppressWarnings("rawtypes")
	public JComboBox comboCategoria;
	@SuppressWarnings("rawtypes")
	public JComboBox comboTipoMedida;

	public PanelProductos() {
		// setBackground(COLOR_BACKGROUND_PANEL); // Dejar al L&F
		setLayout(new BorderLayout(5,5));
		setBorder(new EmptyBorder(5, 5, 5, 5)); // Padding general es útil

		JPanel panelContenido = new JPanel();
		// panelContenido.setBackground(COLOR_SURFACE_CARD); // Dejar al L&F
		// El borde puede ser útil para la estructura visual si el L&F no crea una "tarjeta" clara
		panelContenido.setBorder(new CompoundBorder(
				new LineBorder(COLOR_DIVIDER_POR_DEFECTO, 1), // Borde sutil
				new EmptyBorder(15, 15, 15, 15)
		));
		panelContenido.setLayout(new GridBagLayout());
		add(panelContenido, BorderLayout.CENTER);

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.anchor = GridBagConstraints.WEST;

		JLabel lblSuperiorProductos = new JLabel("CONTROL DE PRODUCTOS");
		lblSuperiorProductos.setFont(FONT_PANEL_TITLE);
		lblSuperiorProductos.setForeground(COLOR_TEXT_NEGRO); // Texto negro
		lblSuperiorProductos.setHorizontalAlignment(SwingConstants.CENTER);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 4;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 1.0;
		gbc.insets = new Insets(5, 5, 20, 5);
		panelContenido.add(lblSuperiorProductos, gbc);
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = 0;
		gbc.insets = new Insets(5,5,5,5);

		gbc.gridy = 1;
		gbc.gridx = 0;
		JLabel lblId = new JLabel("IdProducto:");
		styleLabel(lblId);
		panelContenido.add(lblId, gbc);

		gbc.gridx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 0.5;
		textId = new JTextField(15);
		styleTextField(textId, false, null);
		panelContenido.add(textId, gbc);
		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = 0;

		gbc.gridx = 2;
		gbc.insets = new Insets(5, 20, 5, 5);
		JLabel lblFechaVencimiento = new JLabel("F-Vencimiento:");
		styleLabel(lblFechaVencimiento);
		panelContenido.add(lblFechaVencimiento, gbc);
		gbc.insets = new Insets(5,5,5,5);

		gbc.gridx = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 0.5;
		textFechaVencimiento = new JTextField(15);
		styleTextField(textFechaVencimiento, true, "YYYY-MM-DD");
		panelContenido.add(textFechaVencimiento, gbc);
		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = 0;

		gbc.gridy = 2;
		gbc.gridx = 0;
		JLabel lblNombreProducto = new JLabel("Nombre:");
		styleLabel(lblNombreProducto);
		panelContenido.add(lblNombreProducto, gbc);

		gbc.gridx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		textNombre = new JTextField(15);
		styleTextField(textNombre, true, "Nombre del producto");
		panelContenido.add(textNombre, gbc);
		gbc.fill = GridBagConstraints.NONE;

		gbc.gridx = 2;
		gbc.insets = new Insets(5, 20, 5, 5);
		JLabel lblPrecioCompra = new JLabel("Precio Compra:");
		styleLabel(lblPrecioCompra);
		panelContenido.add(lblPrecioCompra, gbc);
		gbc.insets = new Insets(5,5,5,5);

		gbc.gridx = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		textPrecioCompra = new JTextField(15);
		styleTextField(textPrecioCompra, true, "0.00");
		panelContenido.add(textPrecioCompra, gbc);
		gbc.fill = GridBagConstraints.NONE;

		gbc.gridy = 3;
		gbc.gridx = 0;
		JLabel lblCantidadStop = new JLabel("Cantidad Stock:");
		styleLabel(lblCantidadStop);
		panelContenido.add(lblCantidadStop, gbc);

		gbc.gridx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		textCantidadStop = new JTextField(15);
		styleTextField(textCantidadStop, false, null);
		panelContenido.add(textCantidadStop, gbc);
		gbc.fill = GridBagConstraints.NONE;

		gbc.gridx = 2;
		gbc.insets = new Insets(5, 20, 5, 5);
		JLabel lblTipoMedida = new JLabel("Tipo de Medida:");
		styleLabel(lblTipoMedida);
		panelContenido.add(lblTipoMedida, gbc);
		gbc.insets = new Insets(5,5,5,5);

		gbc.gridx = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		comboTipoMedida = new JComboBox();
		comboTipoMedida.setModel(new DefaultComboBoxModel(new String[] {"Tipo Medida", "Unidad", "Caja", "Paquete",
				"docena", "libra", "kilo", "bote"}));
		styleComboBox(comboTipoMedida);
		panelContenido.add(comboTipoMedida, gbc);
		gbc.fill = GridBagConstraints.NONE;

		gbc.gridy = 4;
		gbc.gridx = 0;
		JLabel lblCantidad = new JLabel("Cantidad Ingresar:");
		styleLabel(lblCantidad);
		panelContenido.add(lblCantidad, gbc);

		gbc.gridx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		textCantidadIngresada = new JTextField(15);
		styleTextField(textCantidadIngresada, true, "0");
		panelContenido.add(textCantidadIngresada, gbc);
		gbc.fill = GridBagConstraints.NONE;

		gbc.gridy = 5;
		gbc.gridx = 0;
		JLabel lblIdCategoiria = new JLabel("IdCategoria:");
		styleLabel(lblIdCategoiria);
		panelContenido.add(lblIdCategoiria, gbc);

		gbc.gridx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		textIdCategoria = new JTextField(15);
		styleTextField(textIdCategoria, false, null);
		panelContenido.add(textIdCategoria, gbc);
		gbc.fill = GridBagConstraints.NONE;

		gbc.gridy = 6;
		gbc.gridx = 0;
		JLabel lblIdProveedor = new JLabel("IdProveedor:");
		styleLabel(lblIdProveedor);
		panelContenido.add(lblIdProveedor, gbc);

		gbc.gridx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		textIdProveedor = new JTextField(15);
		styleTextField(textIdProveedor, false, null);
		panelContenido.add(textIdProveedor, gbc);
		gbc.fill = GridBagConstraints.NONE;

		gbc.gridy = 7;
		gbc.gridx = 0;
		JLabel lblCategoriaProducto = new JLabel("Categoria:");
		styleLabel(lblCategoriaProducto);
		panelContenido.add(lblCategoriaProducto, gbc);

		gbc.gridx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		comboCategoria = new JComboBox();
		styleComboBox(comboCategoria);
		panelContenido.add(comboCategoria, gbc);
		gbc.fill = GridBagConstraints.NONE;

		gbc.gridy = 8;
		gbc.gridx = 0;
		JLabel lblFechaCompra = new JLabel("Fecha Compra:");
		styleLabel(lblFechaCompra);
		panelContenido.add(lblFechaCompra, gbc);

		gbc.gridx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		textFechaCompra = new JTextField(15);
		styleTextField(textFechaCompra, true, "YYYY-MM-DD");
		panelContenido.add(textFechaCompra, gbc);
		gbc.fill = GridBagConstraints.NONE;

		JPanel panelBotones = new JPanel(new GridBagLayout());
		// panelBotones.setBackground(COLOR_SURFACE_CARD); // Dejar al L&F
		GridBagConstraints gbcBotones = new GridBagConstraints();
		gbcBotones.insets = new Insets(5, 5, 5, 5);
		gbcBotones.fill = GridBagConstraints.HORIZONTAL;

		IconFontSwing.register(FontAwesomeSolid.getIconFont());

		btnAgregar = new JButton("Agregar");
		styleButton(btnAgregar);
		Icon iconAgregar = IconFontSwing.buildIcon(FontAwesomeSolid.SAVE, 15, COLOR_TEXT_NEGRO);
		btnAgregar.setIcon(iconAgregar);
		gbcBotones.gridx = 0; gbcBotones.gridy = 0; panelBotones.add(btnAgregar, gbcBotones);

		btnEditar = new JButton("Editar");
		styleButton(btnEditar);
		Icon iconEditar = IconFontSwing.buildIcon(FontAwesomeSolid.PEN, 15, COLOR_TEXT_NEGRO);
		btnEditar.setIcon(iconEditar);
		gbcBotones.gridx = 1; gbcBotones.gridy = 0; panelBotones.add(btnEditar, gbcBotones);

		btnEliminar = new JButton("Eliminar");
		styleButton(btnEliminar);
		Icon iconEliminar = IconFontSwing.buildIcon(FontAwesomeSolid.TRASH, 15, COLOR_TEXT_NEGRO);
		btnEliminar.setIcon(iconEliminar);
		gbcBotones.gridx = 0; gbcBotones.gridy = 1; panelBotones.add(btnEliminar, gbcBotones);

		btnBuscar = new JButton("Buscar");
		styleButton(btnBuscar);
		Icon iconSearch = IconFontSwing.buildIcon(FontAwesomeSolid.SEARCH, 15, COLOR_TEXT_NEGRO);
		btnBuscar.setIcon(iconSearch);
		gbcBotones.gridx = 1; gbcBotones.gridy = 1; panelBotones.add(btnBuscar, gbcBotones);

		gbc.gridy = 5;
		gbc.gridx = 2;
		gbc.gridwidth = 2;
		gbc.gridheight = 4;
		gbc.anchor = GridBagConstraints.NORTHEAST;
		gbc.fill = GridBagConstraints.NONE;
		panelContenido.add(panelBotones, gbc);
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.WEST;

		gbc.gridy = 9;
		gbc.gridx = 0;
		gbc.gridwidth = 4;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.insets = new Insets(20, 5, 5, 5);

		scrollPaneTabla = new JScrollPane();
		scrollPaneTabla.setBorder(new LineBorder(COLOR_DIVIDER_POR_DEFECTO)); // Usar un color de divisor por defecto

		tablaProductos = new JTable();
		styleTable(tablaProductos);
		scrollPaneTabla.setViewportView(tablaProductos);
		tablaProductos.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {
						"ID", "NOMBRE", "TIPO MEDIDA", "PRECIO UN.", "STOCK", "ID CAT."
				}
		));
		tablaProductos.getColumnModel().getColumn(0).setPreferredWidth(50);
		tablaProductos.getColumnModel().getColumn(1).setPreferredWidth(180);
		tablaProductos.getColumnModel().getColumn(2).setPreferredWidth(100);
		tablaProductos.getColumnModel().getColumn(3).setPreferredWidth(100);
		tablaProductos.getColumnModel().getColumn(4).setPreferredWidth(80);
		tablaProductos.getColumnModel().getColumn(5).setPreferredWidth(80);

		panelContenido.add(scrollPaneTabla, gbc);
	}

	private void styleLabel(JLabel label) {
		label.setFont(FONT_LABEL);
		label.setForeground(COLOR_TEXT_NEGRO); // Texto de etiquetas a negro
	}

	private void styleTextField(JTextField textField, boolean isEditable, String placeholder) {
		textField.setFont(FONT_INPUT);
		// textField.setBackground(COLOR_SURFACE_CARD); // Dejar al L&F
		textField.setMargin(new Insets(2, 6, 2, 6)); // Padding es útil

		// Borde simple, el L&F de Material debería definirlo mejor
		Border lineBorder = new MatteBorder(0, 0, 1, 0, COLOR_DIVIDER_POR_DEFECTO);
		textField.setForeground(COLOR_TEXT_NEGRO); // Texto del campo a negro

		if (isEditable) {
			if (placeholder != null && !placeholder.isEmpty()) {
				new TextPlaceholder(placeholder, textField, COLOR_PLACEHOLDER, FONT_INPUT.deriveFont(Font.ITALIC));
			}
		} else {
			// textField.setForeground(COLOR_TEXT_HINT_OR_DISABLED); // L&F debería manejar el color de texto deshabilitado
			textField.setEditable(false);
			// textField.setBackground(new Color(0xF5F5F5)); // Dejar al L&F
		}
		textField.setBorder(new CompoundBorder(lineBorder, new EmptyBorder(5, 8, 5, 8)));

		// El L&F de Material debería manejar el feedback de foco.
		// Si no, se puede añadir un FocusListener simple para un borde básico.
		textField.addFocusListener(new FocusAdapter() {
			Border originalBorder = textField.getBorder();
			// El L&F debería cambiar el borde, esto es un fallback.
			Border focusedBorder = new CompoundBorder(new MatteBorder(0,0,2,0, COLOR_TEXT_NEGRO), new EmptyBorder(5,8,4,8));
			@Override public void focusGained(FocusEvent e) {
				// if(textField.isEditable()) textField.setBorder(focusedBorder); // Dejar que el L&F lo maneje
			}
			@Override public void focusLost(FocusEvent e) {
				// if(textField.isEditable()) textField.setBorder(originalBorder); // Dejar que el L&F lo maneje
			}
		});
	}

	private void styleButton(JButton button) {
		button.setFont(FONT_BUTTON);
		// button.setBackground(normalBgColor); // Dejar al L&F
		button.setForeground(COLOR_TEXT_NEGRO); // Texto del botón a negro
		button.setFocusPainted(false); // Buena práctica
		button.setOpaque(false); // A menudo necesario para que el L&F pinte correctamente

		// Padding interno del botón
		button.setBorder(new EmptyBorder(8, 15, 8, 15));

		button.setText(button.getText().toUpperCase());
		button.setPreferredSize(new Dimension(140, 36)); // Tamaño preferido puede ser útil
	}

	@SuppressWarnings("rawtypes")
	private void styleComboBox(JComboBox comboBox) {
		comboBox.setFont(FONT_INPUT);
		// comboBox.setBackground(COLOR_SURFACE_CARD); // Dejar al L&F
		comboBox.setForeground(COLOR_TEXT_NEGRO); // Texto del combobox a negro
		// comboBox.setBorder(...); // Dejar al L&F
		comboBox.setPreferredSize(new Dimension(100, 30));
	}

	private void styleTable(JTable table) {
		table.setFont(FONT_TABLE_CELL);
		table.setForeground(COLOR_TEXT_NEGRO); // Texto de celdas a negro
		// table.setBackground(COLOR_SURFACE_CARD); // Dejar al L&F
		// table.setGridColor(COLOR_DIVIDER_POR_DEFECTO); // L&F debería manejar esto
		table.setRowHeight(30);
		table.setIntercellSpacing(new Dimension(0, 0)); // Común

		// table.setSelectionBackground(COLOR_PRIMARY_LIGHT); // L&F debería manejar esto
		// table.setSelectionForeground(COLOR_TEXT_NEGRO); // L&F debería manejar esto

		JTableHeader header = table.getTableHeader();
		header.setFont(FONT_TABLE_HEADER);
		// header.setBackground(new Color(0xF5F5F5)); // Dejar al L&F
		header.setForeground(COLOR_TEXT_NEGRO); // Texto del header a negro
		// header.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, COLOR_DIVIDER_POR_DEFECTO)); // L&F
		header.setPreferredSize(new Dimension(100, 35));
	}

	private static class TextPlaceholder extends FocusAdapter implements Border {
		private final String placeholder;
		private final JTextComponent textComponent;
		private final Color placeholderColor; // Mantenemos un color de placeholder distintivo
		private final Font placeholderFont;
		private Border originalBorder; // El L&F debería manejar el borde
		private boolean showingPlaceholder;
		private Color originalForeground;
		private Font originalFont;


		public TextPlaceholder(String placeholder, JTextComponent textComponent, Color placeholderColor, Font placeholderFont) {
			this.placeholder = placeholder;
			this.textComponent = textComponent;
			this.placeholderColor = placeholderColor;
			this.placeholderFont = placeholderFont;
			this.originalBorder = textComponent.getBorder(); // Capturar el borde del L&F
			this.originalForeground = COLOR_TEXT_NEGRO; // Texto normal será negro
			this.originalFont = FONT_INPUT; // Fuente normal

			textComponent.addFocusListener(this);
			focusLost(null);
		}

		@Override
		public void focusGained(FocusEvent e) {
			if (showingPlaceholder) {
				textComponent.setText("");
				textComponent.setForeground(originalForeground);
				textComponent.setFont(originalFont);
				showingPlaceholder = false;
			}
		}

		@Override
		public void focusLost(FocusEvent e) {
			if (textComponent.getText().trim().isEmpty()) {
				if(!showingPlaceholder) {
					// No es necesario guardar aquí si originalForeground/Font son constantes
				}
				textComponent.setText(placeholder);
				textComponent.setForeground(placeholderColor);
				textComponent.setFont(placeholderFont);
				showingPlaceholder = true;
			} else {
				textComponent.setForeground(originalForeground);
				textComponent.setFont(originalFont);
				showingPlaceholder = false;
			}
		}

		@Override
		public void paintBorder(java.awt.Component c, Graphics g, int x, int y, int width, int height) {
			if (originalBorder != null) {
				originalBorder.paintBorder(c, g, x, y, width, height);
			}
		}

		@Override
		public Insets getBorderInsets(java.awt.Component c) {
			return originalBorder != null ? originalBorder.getBorderInsets(c) : new Insets(0,0,0,0);
		}

		@Override
		public boolean isBorderOpaque() {
			return originalBorder != null && originalBorder.isBorderOpaque();
		}
	}
}
