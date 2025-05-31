package inventario.controlador;


import inventario.DAO.CategoriaDAO;
import inventario.DAO.ProductoDAO;
import inventario.modelo.CategoriaModel;
import inventario.modelo.ComboModel;
import inventario.modelo.ProductoModel;
import inventario.vistas.FrmPrincipal;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ProductoController implements ActionListener {

	
	
	FrmPrincipal frame;
	ProductoDAO productoDao;
	ProductoModel productoModel;
	CategoriaDAO categoriaDao;

	

	
	
	public ProductoController(FrmPrincipal frame) {
		super();
		this.frame = frame;
		
		productoDao= new ProductoDAO("inventario");
		categoriaDao= new CategoriaDAO("inventario");
		
		
		this.frame.vistaProductos.btnAgregar.addActionListener(this);
		this.frame.vistaProductos.btnBuscar.addActionListener(this);
		this.frame.vistaProductos.btnEditar.addActionListener(this);
		this.frame.vistaProductos.btnEliminar.addActionListener(this);
		
		llenarTablaProductos(this.frame.vistaProductos.tablaProductos);
	
		 llenarCombo(categoriaDao.obtener(), this.frame.vistaProductos.comboCategoria);
		
	}


	


	//ACCIONES
	public void actionPerformed(ActionEvent e) {
		
		
		
		//Agregar
		if (e.getSource() == this.frame.vistaProductos.btnAgregar) {
			
		    String nombre = this.frame.vistaProductos.textNombre.getText();
		    String cantidadStopTexto = this.frame.vistaProductos.textCantidadStop.getText();
		    String cantidadIngresadaTexto = this.frame.vistaProductos.textCantidadIngresada.getText();
		    String fechaCompraTexto = this.frame.vistaProductos.textFechaCompra.getText();
		    String fechaVencimientoTexto = this.frame.vistaProductos.textFechaVencimiento.getText();
		    String precioTexto = this.frame.vistaProductos.textPrecioCompra.getText();
		    String MedidaSeleccionado = (String) frame.vistaProductos.comboTipoMedida.getSelectedItem();
			
	
		

		    if (!nombre.isEmpty() && !precioTexto.isEmpty() && !cantidadIngresadaTexto.isEmpty() 
		        &&  !fechaCompraTexto.isEmpty() && !fechaVencimientoTexto.isEmpty() ) {
		        try {
		            double precioUnitario = Double.parseDouble(precioTexto);
		            int cantidadIngresada = Integer.parseInt(cantidadIngresadaTexto);
		            int cantidadStop = Integer.parseInt(cantidadStopTexto);
		            

		            ComboModel categoriaSeleccionada = (ComboModel) this.frame.vistaProductos.comboCategoria.getSelectedItem();
		            int idCategoriaSeleccionada = categoriaSeleccionada.getId();
		            
		           
				
		          
		            

		            productoModel = new ProductoModel(0, nombre, precioUnitario, cantidadIngresada, 
		                                              idCategoriaSeleccionada, 0, cantidadStop, 
		                                              fechaCompraTexto, fechaVencimientoTexto, MedidaSeleccionado);

		            productoDao.insertar(productoModel);

		            llenarTablaProductos(this.frame.vistaProductos.tablaProductos);
		            borrarCampos();

		            JOptionPane.showMessageDialog(null, "¡Producto: " + productoModel.getNombre() + " agregado con éxito!");
		        } catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(null, "¡Error! Revisa los valores numéricos ingresados.");
		        }
		    } else {
		        JOptionPane.showMessageDialog(null, "¡Inválido! Debes llenar todos los campos.");
		    }
		}
		
		
		
		//Buscar
		if (e.getSource() == this.frame.vistaProductos.btnBuscar) {
		    try {
		        int fila = this.frame.vistaProductos.tablaProductos.getSelectedRow();
		        
		        int id = Integer.parseInt((String) this.frame.vistaProductos.tablaProductos.getValueAt(fila, 0));
		        System.out.print(id);
		        
		        
		        productoModel = new ProductoModel(id, "",0, 0, 0,0,0,"","","");
		        
		      
		      productoDao.buscar(productoModel);
		        
		    
		    
		        
		      
		        this.frame.vistaProductos.textId.setText(productoDao.buscar(productoModel).getIdProducto() + "" );
				this.frame.vistaProductos.textNombre.setText(productoDao.buscar(productoModel).getNombre());
				this.frame.vistaProductos.textPrecioCompra.setText(productoDao.buscar(productoModel).getPrecioCompra() + ""); 
				this.frame.vistaProductos.textIdCategoria.setText(productoDao.buscar(productoModel).getIdCategoria()+"");
				this.frame.vistaProductos.textIdProveedor.setText(productoDao.buscar(productoModel).getIdProveedor()+"");
				this.frame.vistaProductos.textCantidadStop.setText(productoDao.buscar(productoModel).getCantidadStop()+"");
				this.frame.vistaProductos.textFechaCompra.setText(productoDao.buscar(productoModel).getFechaCompra());
				this.frame.vistaProductos.textFechaVencimiento.setText(productoDao.buscar(productoModel).getFechaVencimiento());
				
		
				
				
		    } catch (Exception ex) {
		        ex.printStackTrace();
		        JOptionPane.showMessageDialog(null, "!Invalido!Debes seleccionar una fila");
		    }
		}
		
		
		
		
		// Editar Producto
		if (e.getSource() == this.frame.vistaProductos.btnEditar) {
		    try {
		      
		        String nombre = this.frame.vistaProductos.textNombre.getText().trim();
		        String precioTexto = this.frame.vistaProductos.textPrecioCompra.getText().trim();
		        String fechaCompraTexto = this.frame.vistaProductos.textFechaCompra.getText().trim();
		        String fechaVencimientoTexto = this.frame.vistaProductos.textFechaVencimiento.getText().trim();
		      
		     
		        if (!nombre.isEmpty() && !precioTexto.isEmpty() && !fechaCompraTexto.isEmpty() && !fechaVencimientoTexto.isEmpty() ) {
		            try {
		              
		                int idProducto = Integer.parseInt(this.frame.vistaProductos.textId.getText().trim());
		                double precioUnitario = Double.parseDouble(precioTexto);
		               

		                
		                ComboModel categoriaSeleccionada = (ComboModel) this.frame.vistaProductos.comboCategoria.getSelectedItem();
		                int idCategoria = categoriaSeleccionada.getId();
		            


		             
		                productoModel = new ProductoModel(idProducto,nombre,precioUnitario,0,idCategoria,0,               
		                                                  0, fechaCompraTexto, fechaVencimientoTexto, ""
		                );

		               
		                productoDao.editar(productoModel);

		                // Actualizar la tabla de productos
		                llenarTablaProductos(this.frame.vistaProductos.tablaProductos);
		                borrarCampos();

		            
		                JOptionPane.showMessageDialog(null, "¡Producto: " + productoModel.getNombre() + " editado con éxito!");
		            
		            } catch (NumberFormatException ex) {
		                JOptionPane.showMessageDialog(null, "¡Error! Verifica que los datos sean numéricos donde corresponda.");
		            }
		        } else {
		            JOptionPane.showMessageDialog(null, "¡Inválido! Debes llenar todos los campos.");
		        }
		    } catch (Exception exe) {
		        exe.printStackTrace();
		        JOptionPane.showMessageDialog(null, "¡Invalido! Debes seleccionar un producto.");
		    }
		}
		
				
				//Eliminar
				if(e.getSource() == this.frame.vistaProductos.btnEliminar)
				{
						
						int fila= this.frame.vistaProductos.tablaProductos.getSelectedRow();
					    System.out.print(fila);
					    
					    
					    int id= Integer.parseInt((String)this.frame.vistaProductos.tablaProductos.getValueAt(fila,0));
						
					    System.out.print(id);
						
					    productoModel = new ProductoModel(id,"",0,0,0,0,0,"","","");
					    
					   
					    
					    productoDao.buscar(productoModel);
						
					    this.frame.vistaProductos.textId.setText(productoDao.buscar(productoModel).getIdProducto() + "" );
						this.frame.vistaProductos.textNombre.setText(productoDao.buscar(productoModel).getNombre());
						this.frame.vistaProductos.textPrecioCompra.setText(productoDao.buscar(productoModel).getPrecioCompra()+""); 
						this.frame.vistaProductos.textCantidadStop.setText(productoDao.buscar(productoModel).getCantidadStop()+"");
						this.frame.vistaProductos.textIdCategoria.setText(productoDao.buscar(productoModel).getIdCategoria()+"");
						
						productoDao.eliminar(productoModel);
					
						
						llenarTablaProductos(this.frame.vistaProductos.tablaProductos);
						borrarCampos();
						
						JOptionPane.showMessageDialog(null, "!Producto eliminado con exito");
						
						
					}	
		
	}//FIN DE MIS ACCIONESS
	
	
	
	
	//lleno el combo de las categorias
	private void llenarCombo(List<CategoriaModel> lista, JComboBox<ComboModel> combo) {
		combo.removeAllItems();
		for(CategoriaModel categoriaDao: lista)
		{
			ComboModel comboModel= new ComboModel(categoriaDao.getIdCategoria(),categoriaDao.getNombre());
			combo.addItem(comboModel);
		}
		
	}

	
	
	
	
	// Método para llenar la tabla de productos
	public void llenarTablaProductos(JTable tablaProductos) {
	    DefaultTableModel modelo = (DefaultTableModel) tablaProductos.getModel();

	    // Limpiamos las filas previas
	    modelo.setRowCount(0);

	    // Recorremos la lista de productos y agregamos las filas correspondientes
	    for (ProductoModel producto : productoDao.obtener()) {
	        
	    	
	    	// Creamos una fila con todos los campos del producto
	        String[] fila = { 
	            String.valueOf(producto.getIdProducto()),  
	            producto.getNombre(),                       
	            producto.getPrecioCompra() + "",            
	            producto.getCantidadStop() + "",            
	            producto.getCantidad() + "",                
	            producto.getIdCategoria() + "",             
	            producto.getIdProveedor() + "",             
	            producto.getFechaCompra(),                 
	            producto.getFechaVencimiento(),            
	            producto.getTipoMedida()                    
	        };
	        
	        // Agregar la fila al src.modelo de la tabla
	        modelo.addRow(fila);
	    }
	}


	

	public void borrarCampos() {
	    this.frame.vistaProductos.textNombre.setText("");
	    this.frame.vistaProductos.textPrecioCompra.setText("");
	    this.frame.vistaProductos.textCantidadIngresada.setText("");
	    this.frame.vistaProductos.textCantidadStop.setText("");  
	    this.frame.vistaProductos.textFechaCompra.setText("");   
	    this.frame.vistaProductos.textFechaVencimiento.setText(""); 
	    this.frame.vistaProductos.textId.setText("");            
	    this.frame.vistaProductos.textIdCategoria.setText("");   
	    this.frame.vistaProductos.textIdProveedor.setText("");   
	 
	}


	

}//Fin de mi clase
