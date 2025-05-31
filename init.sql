CREATE DATABASE IF NOT EXISTS inventario CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE inventario;

CREATE TABLE inventario.tabla_usuarios (
                                           idUsuario INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                           nombre VARCHAR(40),
                                           apellido VARCHAR(40),
                                           usuario VARCHAR(50),
                                           contrasena VARCHAR(250) UNIQUE
);

-- Tabla de categorías
CREATE TABLE inventario.tabla_categorias (
                                             idCategoria INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                             nombre VARCHAR(100) NOT NULL,
                                             descripcion VARCHAR(180) NOT NULL
);

-- Tabla de proveedores
CREATE TABLE inventario.tabla_proveedores (
                                              idProveedor INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                              nombre VARCHAR(40) NOT NULL,
                                              apellido VARCHAR(40) NOT NULL,
                                              celular VARCHAR(15) NOT NULL
);

-- Tabla de clientes
CREATE TABLE inventario.tabla_clientes (
                                           idCliente INT PRIMARY KEY AUTO_INCREMENT,
                                           nombre VARCHAR(50) NOT NULL,
                                           apellido VARCHAR(50) NOT NULL,
                                           telefono VARCHAR(15),
                                           email VARCHAR(100) UNIQUE
);

-- Tabla de productos
CREATE TABLE inventario.tabla_productos (
                                            idProducto INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                            nombre VARCHAR(100) NOT NULL,
                                            precioCompra DECIMAL(10,2) NOT NULL,
                                            cantidad INT NOT NULL,
                                            idCategoria INT NOT NULL,
                                            idProveedor INT NOT NULL,
                                            cantidadStop INT NOT NULL,
                                            fechaCompra DATE,
                                            fechaVencimiento DATE,
                                            tipoMedida VARCHAR(30),
                                            FOREIGN KEY (idCategoria) REFERENCES inventario.tabla_categorias(idCategoria),
                                            FOREIGN KEY (idProveedor) REFERENCES inventario.tabla_proveedores(idProveedor)
);

-- Tabla de ventas
CREATE TABLE inventario.tabla_ventas (
                                         idVenta INT PRIMARY KEY AUTO_INCREMENT,
                                         idCliente INT NOT NULL,
                                         fechaVenta DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP, -- Corrected line
                                         total DECIMAL(10,2) NOT NULL,
                                         FOREIGN KEY (idCliente) REFERENCES inventario.tabla_clientes(idCliente)
);

-- Tabla de detalles de ventas
CREATE TABLE inventario.tabla_detalle_ventas (
                                                 idDetalle INT PRIMARY KEY AUTO_INCREMENT,
                                                 idVenta INT NOT NULL,
                                                 idProducto INT NOT NULL,
                                                 cantidad INT NOT NULL,
                                                 precioUnitario DECIMAL(10,2) NOT NULL,
                                                 FOREIGN KEY (idVenta) REFERENCES inventario.tabla_ventas(idVenta) ON DELETE CASCADE,
                                                 FOREIGN KEY (idProducto) REFERENCES inventario.tabla_productos(idProducto)
);