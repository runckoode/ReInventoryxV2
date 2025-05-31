package inventario.controlador;

import inventario.vistas.FrmPrincipal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrincipalController implements ActionListener {

	
	//Atributos
	FrmPrincipal frame;

	
	//Constructor
	public PrincipalController(FrmPrincipal frame) {
		super();
		this.frame = frame;

		this.frame.getBtnProductos().addActionListener(this);
		this.frame.getBtnReportes().addActionListener(this);
		this.frame.getBtnCategorias().addActionListener(this);
		this.frame.getBtnClientes().addActionListener(this);
		this.frame.getBtnProveedores().addActionListener(this);
		this.frame.getBtnUsuarios().addActionListener(this);

	}

	
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==this.frame.getBtnUsuarios())
		{
			mostrarPanel(this.frame.getVistaUsuarios());
		}
		
		if(e.getSource()== this.frame.getBtnProductos())
		{
			mostrarPanel(this.frame.getVistaProductos());
		}

		if(e.getSource()==this.frame.getBtnCategorias())
		{
			mostrarPanel(this.frame.getVistaCategorias());
		}
		
		
		if(e.getSource()==this.frame.getBtnReportes())
		{
			mostrarPanel(this.frame.getVistaReportes());
		}
		
		
		if(e.getSource()==this.frame.getBtnClientes())
		{
			mostrarPanel(this.frame.getVistaClientes());
		}
		
		
		if(e.getSource()==this.frame.getBtnProveedores())
		{
			mostrarPanel(this.frame.getVistaProveedores());
		}
		
	}
	
	
	public void mostrarPanel(JPanel panel)
	{
		this.frame.getVistaProductos().setVisible(false);
        this.frame.getVistaCategorias().setVisible(false);
        this.frame.getVistaReportes().setVisible(false);
        this.frame.getVistaClientes().setVisible(false);
        this.frame.getVistaProveedores().setVisible(false);

        panel.setVisible(true);

	}
	
}
