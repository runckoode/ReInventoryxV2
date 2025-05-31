package inventario.controlador;

import inventario.DAO.CategoriaDAO;
import inventario.modelo.CategoriaModel;
import inventario.vistas.FrmPrincipal;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CategoriaController implements ActionListener {

	FrmPrincipal frame;
	CategoriaDAO categoriaDao;
	CategoriaModel categoriaModel;
	
	
	
	
	public CategoriaController(FrmPrincipal frame) {
		super();
		this.frame = frame;
		
		categoriaDao= new CategoriaDAO("inventario");
		
		
		this.frame.getVistaCategorias().btnAgregar.addActionListener(this);
		this.frame.getVistaCategorias().btnBuscar.addActionListener(this);
		this.frame.getVistaCategorias().btnEditar.addActionListener(this);
		this.frame.getVistaCategorias().btnEliminar.addActionListener(this);
		
		llenarTablaCategorias(this.frame.getVistaCategorias().tablaCategorias);
		
		
	}



	
	

	//ACCIONES
	public void actionPerformed(ActionEvent e) {
		
		
		
		
		//Agregar
		if(e.getSource() == this.frame.getVistaCategorias().btnAgregar)
		{
					
			
			categoriaModel= new CategoriaModel(0,
					                    this.frame.getVistaCategorias().textNombre.getText(),
					                    this.frame.getVistaCategorias().textDescripcion.getText()
					                   );
			
			if(
				!this.frame.getVistaCategorias().textNombre.getText().equals("") && 
				!this.frame.getVistaCategorias().textDescripcion.getText().equals(""))
		
				
			{
				
			categoriaDao.agregar(categoriaModel);
			
			
			llenarTablaCategorias(this.frame.getVistaCategorias().tablaCategorias);
			borrarCampos();
				
				
				JOptionPane.showMessageDialog(null, "!Categoria agregado con exito");
				
			    }
				
				else {
					
					JOptionPane.showMessageDialog(null, "!Invalido!Debes llenar todos los campos");
				     }	
		}//fin de agregar usuario
		
		
		
		
		
		
		
		//Buscar
		if (e.getSource() == this.frame.getVistaCategorias().btnBuscar) {
		    try {
		        int fila = this.frame.getVistaCategorias().tablaCategorias.getSelectedRow();
		        
		        int id = Integer.parseInt((String) this.frame.getVistaCategorias().tablaCategorias.getValueAt(fila, 0));
		        System.out.print(id);
		        
		        
		        categoriaModel = new CategoriaModel(id, "", "");
		        
		      
		       categoriaDao.buscar(categoriaModel);
		        
		    
		    
		        
		      
		        this.frame.getVistaCategorias().textId.setText(categoriaDao.buscar(categoriaModel).getIdCategoria() + "" );
				this.frame.getVistaCategorias().textNombre.setText(categoriaDao.buscar(categoriaModel).getNombre());
				this.frame.getVistaCategorias().textDescripcion.setText(categoriaDao.buscar(categoriaModel).getDescripcion()); 
				
			
				
		        
		    } catch (Exception ex) {
		        ex.printStackTrace();
		        JOptionPane.showMessageDialog(null, "!Invalido!Debes seleccionar una fila");
		    }
		}
		
		
		
		
		        //Editar
				if(e.getSource() == this.frame.getVistaCategorias().btnEditar)
				{
					try {
					int idCategoria = Integer.parseInt(this.frame.getVistaCategorias().textId.getText());
					
					categoriaModel= new CategoriaModel(idCategoria,
							                    this.frame.getVistaCategorias().textNombre.getText(),
							                    this.frame.getVistaCategorias().textDescripcion.getText());
							    				
					
					if(	!this.frame.getVistaCategorias().textNombre.getText().equals("") && 
						!this.frame.getVistaCategorias().textDescripcion.getText().equals(""))
						{
						categoriaDao.editar(categoriaModel);
						
						
						
						llenarTablaCategorias(this.frame.getVistaCategorias().tablaCategorias);
						borrarCampos();
						
						JOptionPane.showMessageDialog(null, "!categoria editada con exito");
						
					    }
						
						else {
							
							JOptionPane.showMessageDialog(null, "¡Los campos no deben estar vacíos! Llenalos para continuar.");
						}	
					}catch(Exception exe)
					{
						exe.printStackTrace();
						JOptionPane.showMessageDialog(null, "!Invalido!Debes seleccionar una fila de la tabla categorias");
					}
				}
		
		
		
		
				
				//Eliminar
				if(e.getSource() == this.frame.getVistaCategorias().btnEliminar)
				{
						
						int fila= this.frame.getVistaCategorias().tablaCategorias.getSelectedRow();
					    System.out.print(fila);
					    
					    
					    int id= Integer.parseInt((String)this.frame.getVistaCategorias().tablaCategorias.getValueAt(fila,0));
						
					    System.out.print(id);
						
					   categoriaModel = new CategoriaModel(id,"","");
					    
					   
					    
					    categoriaDao.buscar(categoriaModel);
						
						
					    this.frame.getVistaCategorias().textId.setText(categoriaDao.buscar(categoriaModel).getIdCategoria() + "" );
						this.frame.getVistaCategorias().textNombre.setText(categoriaDao.buscar(categoriaModel).getNombre());
						this.frame.getVistaCategorias().textDescripcion.setText(categoriaDao.buscar(categoriaModel).getDescripcion()); 

						
						categoriaDao.eliminar(categoriaModel);
						
					
						
						llenarTablaCategorias(this.frame.getVistaCategorias().tablaCategorias);
						borrarCampos();
						
						JOptionPane.showMessageDialog(null, "!categoria eliminada con exito");
						
						
					}
						
		
		
	}//fin de mis acciones
	
	
	
	
	
	//Metodo llenar tabla
	public void llenarTablaCategorias(JTable tablaCategorias) {
	    DefaultTableModel modelo = (DefaultTableModel) tablaCategorias.getModel();
	    

	    modelo.setRowCount(0);
	    
	    for (CategoriaModel categoria: categoriaDao.obtener()) {
	    	
	    	  
	    	
	        String[] fila = 
	        	{ 
	            String.valueOf(categoria.getIdCategoria()),	
	            categoria.getNombre(),
	            categoria.getDescripcion()
	            };
	        
	        modelo.addRow(fila);
	    }
	}
	


	

	public void borrarCampos() {
		this.frame.getVistaCategorias().textNombre.setText("");
		this.frame.getVistaCategorias().textDescripcion.setText("");
		
		
	}
	

}//Fin de mi clase
