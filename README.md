
```
ReInventoryxV2
├─ .dockerignore
├─ .env
├─ .idea
│  ├─ compiler.xml
│  ├─ encodings.xml
│  ├─ jarRepositories.xml
│  ├─ misc.xml
│  ├─ sqldialects.xml
│  └─ workspace.xml
├─ .mvn
├─ Dockerfile
├─ docker-compose.yml
├─ docker.ps1
├─ init.sql
├─ insert.sql
├─ insertv2.sql
├─ podman.sh
├─ pom.xml
├─ src
│  ├─ main
│  │  ├─ java
│  │  │  └─ inventario
│  │  │     ├─ DAO
│  │  │     │  ├─ CategoriaDAO.java
│  │  │     │  ├─ ClienteDAO.java
│  │  │     │  ├─ Conexion.java
│  │  │     │  ├─ LoginDAO.java
│  │  │     │  ├─ ProductoDAO.java
│  │  │     │  ├─ ProveedorDAO.java
│  │  │     │  └─ UsuarioDAO.java
│  │  │     ├─ MainForm.java
│  │  │     ├─ controlador
│  │  │     │  ├─ CategoriaController.java
│  │  │     │  ├─ ClienteController.java
│  │  │     │  ├─ LoginController.java
│  │  │     │  ├─ PrincipalController.java
│  │  │     │  ├─ ProductoController.java
│  │  │     │  ├─ ProveedorController.java
│  │  │     │  └─ UsuarioController.java
│  │  │     ├─ librerias
│  │  │     │  ├─ jcalendar-1.4.jar
│  │  │     │  └─ mysql-connector-java-5.1.46-bin.jar
│  │  │     ├─ modelo
│  │  │     │  ├─ CategoriaModel.java
│  │  │     │  ├─ ClienteModel.java
│  │  │     │  ├─ ComboModel.java
│  │  │     │  ├─ ProductoModel.java
│  │  │     │  ├─ ProveedorModel.java
│  │  │     │  └─ UsuarioModel.java
│  │  │     └─ vistas
│  │  │        ├─ FrmLogin.java
│  │  │        ├─ FrmPrincipal.java
│  │  │        ├─ PanelCategorias.java
│  │  │        ├─ PanelClientes.java
│  │  │        ├─ PanelProductos.java
│  │  │        ├─ PanelProveedores.java
│  │  │        ├─ PanelReportes.java
│  │  │        └─ PanelUsuarios.java
│  │  └─ resources
│  │     └─ img
│  │        ├─ HombreniñoCarrito.jpg
│  │        ├─ InventarioIza.png
│  │        ├─ LibretaInventario.jpg
│  │        ├─ anadir.png
│  │        ├─ buscar.svg
│  │        ├─ cajaInvent.jpg
│  │        ├─ carrito.png
│  │        ├─ carrito1.png
│  │        ├─ categorias.png
│  │        ├─ cerrar-sesion.png
│  │        ├─ cliente.png
│  │        ├─ clienteIza.png
│  │        ├─ clientes.png
│  │        ├─ comidapn.png
│  │        ├─ configuraciones.png
│  │        ├─ eliminar.jpg
│  │        ├─ fondo2.jpg
│  │        ├─ fondo3.jpg
│  │        ├─ guardar-el-archivo.png
│  │        ├─ header1.jpg
│  │        ├─ historial.png
│  │        ├─ historial1.png
│  │        ├─ hombreInventario.png
│  │        ├─ inventario.png
│  │        ├─ nuevo-cliente.png
│  │        ├─ nuevo-producto.png
│  │        ├─ nuevo.png
│  │        ├─ password.png
│  │        ├─ producto.png
│  │        ├─ reporte.png
│  │        ├─ reporte1.png
│  │        ├─ reportes.png
│  │        ├─ user1.png
│  │        ├─ user2.png
│  │        ├─ usuario.png
│  │        ├─ venta.png
│  │        └─ ventas.png
│  └─ test
│     └─ java
└─ target
   ├─ classes
   │  ├─ img
   │  │  ├─ HombreniñoCarrito.jpg
   │  │  ├─ InventarioIza.png
   │  │  ├─ LibretaInventario.jpg
   │  │  ├─ anadir.png
   │  │  ├─ buscar.svg
   │  │  ├─ cajaInvent.jpg
   │  │  ├─ carrito.png
   │  │  ├─ carrito1.png
   │  │  ├─ categorias.png
   │  │  ├─ cerrar-sesion.png
   │  │  ├─ cliente.png
   │  │  ├─ clienteIza.png
   │  │  ├─ clientes.png
   │  │  ├─ comidapn.png
   │  │  ├─ configuraciones.png
   │  │  ├─ eliminar.jpg
   │  │  ├─ fondo2.jpg
   │  │  ├─ fondo3.jpg
   │  │  ├─ guardar-el-archivo.png
   │  │  ├─ header1.jpg
   │  │  ├─ historial.png
   │  │  ├─ historial1.png
   │  │  ├─ hombreInventario.png
   │  │  ├─ inventario.png
   │  │  ├─ nuevo-cliente.png
   │  │  ├─ nuevo-producto.png
   │  │  ├─ nuevo.png
   │  │  ├─ password.png
   │  │  ├─ producto.png
   │  │  ├─ reporte.png
   │  │  ├─ reporte1.png
   │  │  ├─ reportes.png
   │  │  ├─ user1.png
   │  │  ├─ user2.png
   │  │  ├─ usuario.png
   │  │  ├─ venta.png
   │  │  └─ ventas.png
   │  └─ inventario
   │     ├─ DAO
   │     │  ├─ CategoriaDAO.class
   │     │  ├─ ClienteDAO.class
   │     │  ├─ Conexion.class
   │     │  ├─ LoginDAO.class
   │     │  ├─ ProductoDAO.class
   │     │  ├─ ProveedorDAO.class
   │     │  └─ UsuarioDAO.class
   │     ├─ MainForm.class
   │     ├─ controlador
   │     │  ├─ CategoriaController.class
   │     │  ├─ ClienteController.class
   │     │  ├─ LoginController.class
   │     │  ├─ PrincipalController.class
   │     │  ├─ ProductoController.class
   │     │  ├─ ProveedorController.class
   │     │  └─ UsuarioController.class
   │     ├─ modelo
   │     │  ├─ CategoriaModel.class
   │     │  ├─ ClienteModel.class
   │     │  ├─ ComboModel.class
   │     │  ├─ ProductoModel.class
   │     │  ├─ ProveedorModel.class
   │     │  └─ UsuarioModel.class
   │     └─ vistas
   │        ├─ FrmLogin$1.class
   │        ├─ FrmLogin.class
   │        ├─ FrmPrincipal.class
   │        ├─ PanelCategorias.class
   │        ├─ PanelClientes.class
   │        ├─ PanelProductos.class
   │        ├─ PanelProveedores.class
   │        ├─ PanelReportes.class
   │        └─ PanelUsuarios.class
   └─ generated-sources
      └─ annotations

```