package inventario.vistas;

import com.github.pervoj.jiconfont.FontAwesomeSolid;
import jiconfont.swing.IconFontSwing;

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
import javax.swing.SwingConstants;
import javax.swing.text.JTextComponent;
import javax.swing.BorderFactory;
import java.awt.BorderLayout;

public class PanelReportes extends JPanel {

	private static final long serialVersionUID = 1L;

	private static final Color COLOR_TEXT_NEGRO = Color.BLACK;
	private static final Color COLOR_PLACEHOLDER = new Color(0x9E9E9E);
	private static final Color COLOR_DIVIDER_POR_DEFECTO = new Color(0xE0E0E0);

	private static final Font FONT_LABEL = new Font("SansSerif", Font.PLAIN, 13);
	private static final Font FONT_INPUT = new Font("SansSerif", Font.PLAIN, 14);
	private static final Font FONT_BUTTON = new Font("SansSerif", Font.BOLD, 13);
	private static final Font FONT_PANEL_TITLE = new Font("SansSerif", Font.BOLD, 18);

	public JTextField textNombre;
	public JTextField textId;
	public JButton btnReporteGeneral;
	public JButton btnReporteNombre;
	public JButton btnReporteId;

	public PanelReportes() {
		setLayout(new BorderLayout(5, 5));
		setBorder(new EmptyBorder(15, 15, 15, 15)); // Aumentar padding general

		JPanel panelContenido = new JPanel();
		panelContenido.setBorder(new CompoundBorder(
				new LineBorder(COLOR_DIVIDER_POR_DEFECTO, 1),
				new EmptyBorder(20, 20, 20, 20) // Aumentar padding interno
		));
		panelContenido.setLayout(new GridBagLayout());
		add(panelContenido, BorderLayout.CENTER);

		GridBagConstraints gbcMain = new GridBagConstraints();
		gbcMain.gridwidth = 1;
		gbcMain.fill = GridBagConstraints.HORIZONTAL;
		gbcMain.weightx = 1.0;


		JLabel lblControlDeLos = new JLabel("CONTROL DE REPORTES");
		lblControlDeLos.setFont(FONT_PANEL_TITLE);
		lblControlDeLos.setForeground(COLOR_TEXT_NEGRO);
		lblControlDeLos.setHorizontalAlignment(SwingConstants.CENTER);
		gbcMain.gridx = 0;
		gbcMain.gridy = 0;
		gbcMain.insets = new Insets(5, 5, 30, 5);
		panelContenido.add(lblControlDeLos, gbcMain);

		JPanel panelInputs = new JPanel(new GridBagLayout());
		GridBagConstraints gbcInputs = new GridBagConstraints();
		gbcInputs.insets = new Insets(5,5,5,5);
		gbcInputs.anchor = GridBagConstraints.WEST;

		gbcInputs.gridx = 0;
		gbcInputs.gridy = 0;
		gbcInputs.anchor = GridBagConstraints.EAST;
		JLabel lblIDProducto = new JLabel("Id Producto:");
		styleLabel(lblIDProducto);
		panelInputs.add(lblIDProducto, gbcInputs);

		gbcInputs.gridx = 1;
		gbcInputs.anchor = GridBagConstraints.WEST;
		gbcInputs.fill = GridBagConstraints.HORIZONTAL;
		gbcInputs.weightx = 1.0;
		textId = new JTextField(20); // Reducir tamaño sugerido
		styleTextField(textId, true, "Ingrese ID del producto");
		panelInputs.add(textId, gbcInputs);
		gbcInputs.fill = GridBagConstraints.NONE;
		gbcInputs.weightx = 0;


		gbcInputs.gridx = 0;
		gbcInputs.gridy = 1;
		gbcInputs.anchor = GridBagConstraints.EAST;
		JLabel lblNombreUsuario = new JLabel("Nombre Producto:");
		styleLabel(lblNombreUsuario);
		panelInputs.add(lblNombreUsuario, gbcInputs);

		gbcInputs.gridx = 1;
		gbcInputs.anchor = GridBagConstraints.WEST;
		gbcInputs.fill = GridBagConstraints.HORIZONTAL;
		gbcInputs.weightx = 1.0;
		textNombre = new JTextField(20); // Reducir tamaño sugerido
		styleTextField(textNombre, true, "Ingrese nombre del producto");
		panelInputs.add(textNombre, gbcInputs);
		gbcInputs.fill = GridBagConstraints.NONE;
		gbcInputs.weightx = 0;

		gbcMain.gridy = 1;
		gbcMain.gridx = 0;
		gbcMain.fill = GridBagConstraints.NONE; // No expandir el panel de inputs
		gbcMain.anchor = GridBagConstraints.CENTER; // Centrar el panel de inputs
		gbcMain.insets = new Insets(10,10,20,10);
		panelContenido.add(panelInputs, gbcMain);

		IconFontSwing.register(FontAwesomeSolid.getIconFont());

		JPanel panelBotonesReportes = new JPanel(new GridBagLayout());
		GridBagConstraints gbcInnerBotones = new GridBagConstraints();
		gbcInnerBotones.insets = new Insets(5, 8, 5, 8);
		gbcInnerBotones.fill = GridBagConstraints.HORIZONTAL;
		gbcInnerBotones.weightx = 1.0;

		gbcInnerBotones.gridx = 0;
		gbcInnerBotones.gridy = 0;
		btnReporteGeneral = new JButton("Stock General");
		styleButton(btnReporteGeneral);
		btnReporteGeneral.setIcon(IconFontSwing.buildIcon(FontAwesomeSolid.FILE_ALT, 15, COLOR_TEXT_NEGRO));
		panelBotonesReportes.add(btnReporteGeneral, gbcInnerBotones);

		gbcInnerBotones.gridx = 1;
		btnReporteId = new JButton("Stock por ID");
		styleButton(btnReporteId);
		btnReporteId.setIcon(IconFontSwing.buildIcon(FontAwesomeSolid.FILE_INVOICE, 15, COLOR_TEXT_NEGRO));
		panelBotonesReportes.add(btnReporteId, gbcInnerBotones);

		gbcInnerBotones.gridx = 2;
		btnReporteNombre = new JButton("Stock por Nombre");
		styleButton(btnReporteNombre);
		btnReporteNombre.setIcon(IconFontSwing.buildIcon(FontAwesomeSolid.FILE_SIGNATURE, 15, COLOR_TEXT_NEGRO));
		panelBotonesReportes.add(btnReporteNombre, gbcInnerBotones);

		gbcMain.gridy = 2;
		gbcMain.gridx = 0;
		gbcMain.anchor = GridBagConstraints.CENTER;
		gbcMain.fill = GridBagConstraints.HORIZONTAL;
		gbcMain.weightx = 1.0;
		gbcMain.insets = new Insets(10, 10, 15, 10);
		panelContenido.add(panelBotonesReportes, gbcMain);

		gbcMain.gridy = 3;
		gbcMain.weighty = 1.0;
		JPanel spacer = new JPanel();
		spacer.setOpaque(false);
		panelContenido.add(spacer, gbcMain);

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
		button.setBorder(new EmptyBorder(10, 15, 10, 15));
		button.setText(button.getText().toUpperCase());
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
