package inventario.vistas;

import com.github.pervoj.jiconfont.FontAwesomeSolid; // Asumiendo que también usarás iconos aquí
import jiconfont.swing.IconFontSwing; // Asumiendo que también usarás iconos aquí

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.text.JTextComponent;
import javax.swing.JScrollPane;
import javax.swing.BorderFactory;
import java.awt.BorderLayout;

public class PanelCategorias extends JPanel {

	private static final long serialVersionUID = 1L;

	private static final Color COLOR_TEXT_NEGRO = Color.BLACK;
	private static final Color COLOR_PLACEHOLDER = new Color(0x9E9E9E);
	private static final Color COLOR_DIVIDER_POR_DEFECTO = new Color(0xE0E0E0);

	private static final Font FONT_LABEL = new Font("SansSerif", Font.PLAIN, 13);
	private static final Font FONT_INPUT = new Font("SansSerif", Font.PLAIN, 14);
	private static final Font FONT_BUTTON = new Font("SansSerif", Font.BOLD, 13);
	private static final Font FONT_PANEL_TITLE = new Font("SansSerif", Font.BOLD, 18);
	private static final Font FONT_TABLE_HEADER = new Font("SansSerif", Font.BOLD, 12);
	private static final Font FONT_TABLE_CELL = new Font("SansSerif", Font.PLAIN, 12);

	public JTextField textNombre;
	public JTextField textDescripcion;
	public JButton btnAgregar;
	public JButton btnBuscar;
	public JButton btnEditar;
	public JButton btnEliminar;
	public JTable tablaCategorias;
	public JScrollPane scrollPane;
	public JTextField textId;

	public PanelCategorias() {
		setLayout(new BorderLayout(5,5));
		setBorder(new EmptyBorder(5, 5, 5, 5));

		JPanel panelContenido = new JPanel();
		panelContenido.setBorder(new CompoundBorder(
				new LineBorder(COLOR_DIVIDER_POR_DEFECTO, 1),
				new EmptyBorder(15, 15, 15, 15)
		));
		panelContenido.setLayout(new GridBagLayout());
		add(panelContenido, BorderLayout.CENTER);

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(8, 8, 8, 8);
		gbc.anchor = GridBagConstraints.WEST;

		JLabel lblSuperiorCategorias = new JLabel("CONTROL DE CATEGORÍAS");
		lblSuperiorCategorias.setFont(FONT_PANEL_TITLE);
		lblSuperiorCategorias.setForeground(COLOR_TEXT_NEGRO);
		lblSuperiorCategorias.setHorizontalAlignment(SwingConstants.CENTER);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 4;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 1.0;
		gbc.insets = new Insets(5, 5, 25, 5);
		panelContenido.add(lblSuperiorCategorias, gbc);
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = 0;
		gbc.insets = new Insets(8,8,8,8);

		gbc.gridy = 1;
		gbc.gridx = 0;
		JLabel lblId = new JLabel("Id:");
		styleLabel(lblId);
		panelContenido.add(lblId, gbc);

		gbc.gridx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 0.7;
		textId = new JTextField(20);
		styleTextField(textId, false, null);
		panelContenido.add(textId, gbc);
		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = 0;

		gbc.gridy = 2;
		gbc.gridx = 0;
		JLabel lblNombreProducto = new JLabel("Nombre:");
		styleLabel(lblNombreProducto);
		panelContenido.add(lblNombreProducto, gbc);

		gbc.gridx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		textNombre = new JTextField(20);
		styleTextField(textNombre, true, "Nombre de la categoría");
		panelContenido.add(textNombre, gbc);
		gbc.fill = GridBagConstraints.NONE;

		gbc.gridy = 3;
		gbc.gridx = 0;
		JLabel lblDescripcionProducto = new JLabel("Descripción:");
		styleLabel(lblDescripcionProducto);
		panelContenido.add(lblDescripcionProducto, gbc);

		gbc.gridx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		textDescripcion = new JTextField(20);
		styleTextField(textDescripcion, true, "Descripción detallada");
		panelContenido.add(textDescripcion, gbc);
		gbc.fill = GridBagConstraints.NONE;

		JPanel panelBotones = new JPanel(new GridBagLayout());
		GridBagConstraints gbcBotones = new GridBagConstraints();
		gbcBotones.insets = new Insets(5,5,5,5);
		gbcBotones.fill = GridBagConstraints.HORIZONTAL;

		IconFontSwing.register(FontAwesomeSolid.getIconFont());

		btnAgregar = new JButton("Agregar");
		styleButton(btnAgregar);
		btnAgregar.setIcon(IconFontSwing.buildIcon(FontAwesomeSolid.SAVE, 15, COLOR_TEXT_NEGRO));
		gbcBotones.gridx = 0; gbcBotones.gridy = 0; panelBotones.add(btnAgregar, gbcBotones);

		btnEditar = new JButton("Editar");
		styleButton(btnEditar);
		btnEditar.setIcon(IconFontSwing.buildIcon(FontAwesomeSolid.PEN, 15, COLOR_TEXT_NEGRO));
		gbcBotones.gridx = 1; gbcBotones.gridy = 0; panelBotones.add(btnEditar, gbcBotones);

		btnEliminar = new JButton("Eliminar");
		styleButton(btnEliminar);
		btnEliminar.setIcon(IconFontSwing.buildIcon(FontAwesomeSolid.TRASH, 15, COLOR_TEXT_NEGRO));
		gbcBotones.gridx = 0; gbcBotones.gridy = 1; panelBotones.add(btnEliminar, gbcBotones);

		btnBuscar = new JButton("Buscar");
		styleButton(btnBuscar);
		btnBuscar.setIcon(IconFontSwing.buildIcon(FontAwesomeSolid.SEARCH, 15, COLOR_TEXT_NEGRO));
		gbcBotones.gridx = 1; gbcBotones.gridy = 1; panelBotones.add(btnBuscar, gbcBotones);

		gbc.gridy = 1;
		gbc.gridx = 2;
		gbc.gridwidth = 2;
		gbc.gridheight = 3;
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.fill = GridBagConstraints.NONE;
		gbc.insets = new Insets(0, 20, 0, 0);
		panelContenido.add(panelBotones, gbc);
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(8,8,8,8);

		gbc.gridy = 4;
		gbc.gridx = 0;
		gbc.gridwidth = 4;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.insets = new Insets(20, 0, 0, 0);

		scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(COLOR_DIVIDER_POR_DEFECTO));

		tablaCategorias = new JTable();
		styleTable(tablaCategorias);
		scrollPane.setViewportView(tablaCategorias);
		tablaCategorias.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {
						"ID", "NOMBRE CATEGORÍA", "DESCRIPCIÓN"
				}
		));
		tablaCategorias.getColumnModel().getColumn(0).setPreferredWidth(50);
		tablaCategorias.getColumnModel().getColumn(1).setPreferredWidth(200);
		tablaCategorias.getColumnModel().getColumn(2).setPreferredWidth(350);

		panelContenido.add(scrollPane, gbc);
	}

	private void styleLabel(JLabel label) {
		label.setFont(FONT_LABEL);
		label.setForeground(COLOR_TEXT_NEGRO);
	}

	private void styleTextField(JTextField textField, boolean isEditable, String placeholder) {
		textField.setFont(FONT_INPUT);
		textField.setMargin(new Insets(2, 6, 2, 6));
		Border lineBorder = new MatteBorder(0, 0, 1, 0, COLOR_DIVIDER_POR_DEFECTO);
		textField.setForeground(COLOR_TEXT_NEGRO);

		if (isEditable) {
			if (placeholder != null && !placeholder.isEmpty()) {
				new TextPlaceholder(placeholder, textField, COLOR_PLACEHOLDER, FONT_INPUT.deriveFont(Font.ITALIC));
			}
		} else {
			textField.setEditable(false);
		}
		textField.setBorder(new CompoundBorder(lineBorder, new EmptyBorder(5, 8, 5, 8)));
		textField.addFocusListener(new FocusAdapter() {
			Border originalBorder = textField.getBorder();
			Border focusedBorder = new CompoundBorder(new MatteBorder(0,0,2,0, COLOR_TEXT_NEGRO), new EmptyBorder(5,8,4,8));
			@Override public void focusGained(FocusEvent e) {
				// L&F should handle focus indication
			}
			@Override public void focusLost(FocusEvent e) {
				// L&F should handle focus indication
			}
		});
	}

	private void styleButton(JButton button) {
		button.setFont(FONT_BUTTON);
		button.setForeground(COLOR_TEXT_NEGRO);
		button.setFocusPainted(false);
		button.setOpaque(false);
		button.setBorder(new EmptyBorder(8, 15, 8, 15));
		button.setText(button.getText().toUpperCase());
		button.setPreferredSize(new Dimension(130, 36));
	}

	private void styleTable(JTable table) {
		table.setFont(FONT_TABLE_CELL);
		table.setForeground(COLOR_TEXT_NEGRO);
		table.setRowHeight(30);
		table.setIntercellSpacing(new Dimension(0, 0));

		JTableHeader header = table.getTableHeader();
		header.setFont(FONT_TABLE_HEADER);
		header.setForeground(COLOR_TEXT_NEGRO);
		header.setPreferredSize(new Dimension(100, 35));
	}

	private static class TextPlaceholder extends FocusAdapter implements Border {
		private final String placeholder;
		private final JTextComponent textComponent;
		private final Color placeholderColor;
		private final Font placeholderFont;
		private Border originalBorder;
		private boolean showingPlaceholder;
		private Color originalForeground;
		private Font originalFont;

		public TextPlaceholder(String placeholder, JTextComponent textComponent, Color placeholderColor, Font placeholderFont) {
			this.placeholder = placeholder;
			this.textComponent = textComponent;
			this.placeholderColor = placeholderColor;
			this.placeholderFont = placeholderFont;
			this.originalBorder = textComponent.getBorder();
			this.originalForeground = COLOR_TEXT_NEGRO;
			this.originalFont = FONT_INPUT;

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
