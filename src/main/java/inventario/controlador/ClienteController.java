package inventario.controlador;


import inventario.DAO.ClienteDAO;
import inventario.modelo.ClienteModel;
import inventario.vistas.FrmPrincipal;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClienteController implements ActionListener {

	FrmPrincipal frame;
    ClienteDAO clienteDao;
	ClienteModel clienteModel;
	
	
	
	
	public ClienteController(FrmPrincipal frame) {
		super();
		this.frame = frame;
		
		clienteDao= new ClienteDAO("inventario");
		
		
		this.frame.vistaClientes.btnAgregar.addActionListener(this);
		this.frame.vistaClientes.btnBuscar.addActionListener(this);
		this.frame.vistaClientes.btnEditar.addActionListener(this);
		this.frame.vistaClientes.btnEliminar.addActionListener(this);
		
		llenarTablaClientes(this.frame.vistaClientes.tablaClientes);
		
		
	}



	
	

	//ACCIONES
	public void actionPerformed(ActionEvent e) {
		
		
		
		
		//Agregar
		if(e.getSource() == this.frame.vistaClientes.btnAgregar)
		{
					
			
			clienteModel= new ClienteModel(0,
					                    this.frame.vistaClientes.textNombre.getText(),
					                    this.frame.vistaClientes.textApellido.getText(),
					                    this.frame.vistaClientes.textTelefono.getText(),
					                    this.frame.vistaClientes.textEmail.getText());
			
			if(
				!this.frame.vistaClientes.textNombre.getText().equals("") && 
				!this.frame.vistaClientes.textApellido.getText().equals("") &&
				!this.frame.vistaClientes.textTelefono.getText().equals(""))
				
			{
				
			clienteDao.agregar(clienteModel);
			
			
			llenarTablaClientes(this.frame.vistaClientes.tablaClientes);
			borrarCampos();
				
				
				JOptionPane.showMessageDialog(null, "!cliente agregado con exito");
				
			    }
				
				else {
					
					JOptionPane.showMessageDialog(null, "!Invalido!Debes llenar todos los campos");
				     }	
		}//fin de agregar usuario
		
		
		
		
		
		
		
		//Buscar
		if (e.getSource() == this.frame.vistaClientes.btnBuscar) {
		    try {
		        int fila = this.frame.vistaClientes.tablaClientes.getSelectedRow();
		        
		        int id = Integer.parseInt((String) this.frame.vistaClientes.tablaClientes.getValueAt(fila, 0));
		        System.out.print(id);
		        
		        
		        clienteModel = new ClienteModel(id, "", "", "", "");
		        
		      
		      clienteDao.buscar(clienteModel);
		        
		    
		    
		        
		      
		        this.frame.vistaClientes.textId.setText(String.valueOf(clienteDao.buscar(clienteModel).getIdCliente()));
				this.frame.vistaClientes.textNombre.setText(clienteDao.buscar(clienteModel).getNombre());
				this.frame.vistaClientes.textApellido.setText(clienteDao.buscar(clienteModel).getApellido()); 
				this.frame.vistaClientes.textTelefono.setText(clienteDao.buscar(clienteModel).getTelefono());
				this.frame.vistaClientes.textEmail.setText(clienteDao.buscar(clienteModel).getEmail());
				
		        
		    } catch (Exception ex) {
		        ex.printStackTrace();
		        JOptionPane.showMessageDialog(null, "!Invalido!Debes seleccionar una fila");
		    }
		}
		
		
		
		
		        //Editar
				if(e.getSource() == this.frame.vistaClientes.btnEditar)
				{
					try {
						
						int fila = this.frame.vistaClientes.tablaClientes.getSelectedRow();
				        
				        int id = Integer.parseInt((String) this.frame.vistaClientes.tablaClientes.getValueAt(fila, 0));
				        System.out.print(id);
					
					clienteModel= new ClienteModel(id,this.frame.vistaClientes.textId.getText(),
							                    this.frame.vistaClientes.textNombre.getText(),
							                    this.frame.vistaClientes.textApellido.getText(),
							                    this.frame.vistaClientes.textTelefono.getText());
					                            this.frame.vistaClientes.textEmail.getText();
					
					
					if(	!this.frame.vistaClientes.textNombre.getText().equals("") && 
						!this.frame.vistaClientes.textApellido.getText().equals("") &&
						!this.frame.vistaClientes.textTelefono.getText().equals("") &&
						!this.frame.vistaClientes.textEmail.getText().equals(""))
						{
						clienteDao.editar(clienteModel);
						
						
						
						llenarTablaClientes(this.frame.vistaClientes.tablaClientes);
						borrarCampos();
						
						JOptionPane.showMessageDialog(null, "!cliente editado con exito");
						
					    }
						
						else {
							
							JOptionPane.showMessageDialog(null, "!El cliente no pudo ser editado");
						}	
					}catch(Exception exe)
					{
						exe.printStackTrace();
						JOptionPane.showMessageDialog(null, "!Invalido!Debes seleccionar una fila");
					}
				}
		
		
		
		
				
				//Eliminar
				if(e.getSource() == this.frame.vistaClientes.btnEliminar)
				{
						try {
							
						
						int fila= this.frame.vistaClientes.tablaClientes.getSelectedRow();
					    System.out.print(fila);
					    
					    
					    int id= Integer.parseInt((String)this.frame.vistaClientes.tablaClientes.getValueAt(fila,0));
						
					    System.out.print(id);
						
					    clienteModel = new ClienteModel(id,"","","","");
					    
					   
					    
					   clienteDao.buscar(clienteModel);
					   clienteDao.eliminar(clienteModel);
					    this.frame.vistaClientes.textId.setText(clienteDao.buscar(clienteModel).getIdCliente() + "" );
						this.frame.vistaClientes.textNombre.setText(clienteDao.buscar(clienteModel).getNombre());
						this.frame.vistaClientes.textApellido.setText(clienteDao.buscar(clienteModel).getApellido()); 
						this.frame.vistaClientes.textTelefono.setText(clienteDao.buscar(clienteModel).getTelefono());
						this.frame.vistaClientes.textEmail.setText(clienteDao.buscar(clienteModel).getEmail());
					
						
						
					
						
						llenarTablaClientes(this.frame.vistaClientes.tablaClientes);
						borrarCampos();
						
						JOptionPane.showMessageDialog(null, "!Cliente eliminado con exito");
						
						}catch(Exception ex)
						{
							ex.printStackTrace();
							JOptionPane.showMessageDialog(null, "!Debes seleccionar una fila -Obligatorio-");
						}
						
						
					}
						
		
		
	}//fin de mis acciones
	
	
	
	
	
	//Metodo llenar tabla
	public void llenarTablaClientes(JTable tablaClientes) {
	    DefaultTableModel modelo = (DefaultTableModel) tablaClientes.getModel();
	    

	    modelo.setRowCount(0);
	    
	    for (ClienteModel cli: clienteDao.obtener()) {
	    	
	    	  
	    
	        String[] fila = { 
	            String.valueOf( cli.getIdCliente()),	
	            cli.getNombre(),
	            cli.getApellido(),
	            cli.getTelefono(),
	            cli.getEmail(),
	           
	        };
	        
	        modelo.addRow(fila);
	    }
	}
	


	

	public void borrarCampos() {
		this.frame.vistaClientes.textNombre.setText("");
		this.frame.vistaClientes.textApellido.setText("");
		this.frame.vistaClientes.textTelefono.setText("");
		this.frame.vistaClientes.textEmail.setText("");
		
	}
	

}//Fin de mi clase
