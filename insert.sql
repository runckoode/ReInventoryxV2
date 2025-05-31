
USE inventario;
SET NAMES 'utf8mb4';


INSERT INTO inventario.tabla_usuarios (nombre, apellido, usuario, contrasena) VALUES
('Ana', 'Pérez', 'aperez', 'claveSegura123'),
('Luis', 'Gómez', 'lgomez', 'otraClave456'),
('Carlos', 'Ruiz', 'cruiz', 'password789'),
('Sofía', 'Martínez', 'smartinez', 'micontrasena01'),
('Juan', 'Rodríguez', 'jrodriguez', 'accesoPermitido22'),
('Elena', 'Jiménez', 'ejimenez', 'nuevaClave2024'),
('Miguel', 'Sánchez', 'msanchez', 'seguridadTotal*'),
('Laura', 'Fernández', 'lfernandez', 'acceso.007'),
('Pedro', 'González', 'pgonzalez', 'miClaveSecreta!'),
('Isabel', 'Díaz', 'idiaz', '123456qwerty'),
('Arturo', 'Vidal', 'avidal', 'campeonDelMundo#1'),
('Beatriz', 'Luengo', 'bluengo', 'musicaEsVida77'),
('Camilo', 'Sesto', 'csesto', 'algoDeMi88'),
('Diana', 'Navarro', 'dnavarro', 'vozPuraEstilo'),
('Esteban', 'Quito', 'equito', 'trabajoDuro55'),
('Fernanda', 'Castillo', 'fcastillo', 'actrizFamosa3'),
('Gabriel', 'Soto', 'gsoto', 'galanTVmex'),
('Hugo', 'Silva', 'hsilva', 'cineEspañolTop'),
('Irene', 'Villa', 'ivilla', 'superacion2025'),
('Javier', 'Bardem', 'jbardem', 'oscarWinnerXY');

INSERT INTO inventario.tabla_categorias (nombre, descripcion) VALUES
('Electrónicos', 'Dispositivos y componentes electrónicos'), -- Corregido
('Ropa', 'Prendas de vestir y accesorios'),
('Hogar', 'Artículos para el hogar y decoración'),
('Alimentos', 'Productos alimenticios y bebidas'),
('Juguetes', 'Artículos de entretenimiento para niños'),
('Deportes', 'Artículos y equipamiento deportivo'),
('Libros', 'Libros de diversos géneros y material de lectura'),
('Herramientas', 'Herramientas manuales y eléctricas'),
('Mascotas', 'Alimentos y accesorios para mascotas'),
('Oficina', 'Suministros y mobiliario de oficina');

INSERT INTO inventario.tabla_proveedores (nombre, apellido, celular) VALUES
('ElectroMax', 'S.A.', '555-111-222'),
('ModaGlobal', 'Ltda.', '555-333-444'),
('CasaBonita', 'Distribuidores', '555-555-666'),
('AlimentosFrescos', 'S.R.L.', '555-777-888'),
('DivertiKids', 'Importaciones', '555-999-000'),
('SportPro', 'Equipamientos', '555-222-111'),
('EditorialMundo', 'S.A. de C.V.', '555-444-333'),
('FerreTotal', 'Suministros', '555-666-555'),
('PetPlanet', 'Universal', '555-888-777'),
('OfficeSolutions', 'Group', '555-000-999');

INSERT INTO inventario.tabla_clientes (nombre, apellido, telefono, email) VALUES
('Elena', 'Vargas', '777-123-4567', 'elena.vargas@email.com'),
('Mario', 'Luna', '777-987-6543', 'mario.luna@email.com'),
('Laura', 'Campos', '777-555-1212', 'laura.campos@email.com'),
('Pedro', 'Soto', '777-222-3333', 'pedro.soto@email.com'),
('Isabel', 'Núñez', '777-888-9999', 'isabel.nunez@email.com'),
('Ricardo', 'Mendoza', '777-101-2020', 'ricardo.mendoza@email.com'),
('Patricia', 'Rojas', '777-303-4040', 'patricia.rojas@email.com'),
('Fernando', 'Silva', '777-505-6060', 'fernando.silva@email.com'),
('Gabriela', 'Torres', '777-707-8080', 'gabriela.torres@email.com'),
('Andrés', 'Flores', '777-909-0000', 'andres.flores@email.com'),
('Valeria', 'Guzmán', '777-112-2334', 'valeria.guzman@email.com'),
('Diego', 'Castro', '777-445-5667', 'diego.castro@email.com'),
('Camila', 'Ortiz', '777-778-8990', 'camila.ortiz@email.com'),
('Mateo', 'Jiménez', '777-001-1223', 'mateo.jimenez@email.com'),
('Luciana', 'Ramírez', '777-334-4556', 'luciana.ramirez@email.com'),
('Sebastián', 'Cruz', '777-667-7889', 'sebastian.cruz@email.com'),
('Martina', 'Herrera', '777-990-0112', 'martina.herrera@email.com'),
('Benjamín', 'Morales', '777-223-3445', 'benjamin.morales@email.com'),
('Renata', 'Paredes', '777-556-6778', 'renata.paredes@email.com'),
('Emiliano', 'Reyes', '777-889-9001', 'emiliano.reyes@email.com'),
('Julieta', 'Vega', '771-123-4567', 'julieta.vega@email.com'),
('Adrián', 'Molina', '771-987-6543', 'adrian.molina@email.com'),
('Daniela', 'Suárez', '771-555-1212', 'daniela.suarez@email.com'),
('Joaquín', 'López', '771-222-3333', 'joaquin.lopez@email.com'),
('Abril', 'Cordero', '771-888-9999', 'abril.cordero@email.com'),
('Nicolás', 'Pinto', '771-101-2020', 'nicolas.pinto@email.com'),
('Valentina', 'Gallardo', '771-303-4040', 'valentina.gallardo@email.com'),
('Samuel', 'Guerrero', '771-505-6060', 'samuel.guerrero@email.com'),
('Victoria', 'Blanco', '771-707-8080', 'victoria.blanco@email.com'),
('Leonardo', 'Salas', '771-909-0000', 'leonardo.salas@email.com');

INSERT INTO inventario.tabla_productos (nombre, precioCompra, cantidad, idCategoria, idProveedor, cantidadStop, fechaCompra, fechaVencimiento, tipoMedida) VALUES
('Laptop Gamer XZ', 750.00, 15, 1, 1, 5, '2023-01-15', NULL, 'Unidad'),
('Smartphone Pro', 450.50, 25, 1, 1, 10, '2023-02-20', NULL, 'Unidad'),
('Camiseta Algodón', 12.75, 150, 2, 2, 30, '2023-03-10', NULL, 'Unidad'),
('Pantalón Jean', 25.00, 100, 2, 2, 20, '2023-03-10', NULL, 'Unidad'),
('Juego de Sábanas Queen', 35.99, 50, 3, 3, 10, '2023-04-05', NULL, 'Juego'),
('Lámpara de Escritorio LED', 18.50, 75, 3, 3, 15, '2023-04-05', NULL, 'Unidad'),
('Arroz Blanco (1kg)', 1.20, 500, 4, 4, 100, '2023-05-01', '2024-11-01', 'Kilogramo'),
('Aceite de Oliva Extra Virgen (750ml)', 5.50, 200, 4, 4, 40, '2023-05-01', '2025-07-15', 'Litro'),
('Muñeca Articulada', 22.95, 80, 5, 5, 15, '2023-06-10', NULL, 'Unidad'),
('Bloques de Construcción (Set Grande)', 30.00, 60, 5, 5, 10, '2023-06-10', NULL, 'Set'),
('Balón de Fútbol Profesional', 29.99, 40, 6, 6, 8, '2023-07-15', NULL, 'Unidad'),
('Set de Pesas (10kg)', 45.50, 30, 6, 6, 5, '2023-07-20', NULL, 'Set'),
('Novela de Misterio "El Secreto Oculto"', 15.00, 120, 7, 7, 25, '2023-08-01', NULL, 'Unidad'),
('Libro de Cocina Internacional', 22.75, 90, 7, 7, 18, '2023-08-01', NULL, 'Unidad'),
('Taladro Inalámbrico 18V', 89.90, 20, 8, 8, 4, '2023-09-05', NULL, 'Unidad'),
('Juego de Destornilladores (20 piezas)', 19.99, 50, 8, 8, 10, '2023-09-05', NULL, 'Juego'),
('Tablet Económica 10"', 120.00, 35, 1, 1, 7, '2023-09-15', NULL, 'Unidad'),
('Sudadera con Capucha', 28.50, 110, 2, 2, 22, '2023-10-02', NULL, 'Unidad'),
('Café Orgánico Molido (500g)', 8.75, 180, 4, 4, 35, '2023-10-10', '2024-10-10', 'Gramo'),
('Rompecabezas 1000 Piezas', 17.50, 70, 5, 5, 14, '2023-10-20', NULL, 'Unidad'),
('Alimento Seco para Perro Adulto (3kg)', 12.50, 250, 9, 9, 50, '2023-11-01', '2025-05-01', 'Kilogramo'),
('Arena Aglomerante para Gato (5L)', 7.25, 150, 9, 9, 30, '2023-11-01', NULL, 'Litro'),
('Resma de Papel Bond (500 hojas)', 4.50, 300, 10, 10, 60, '2023-11-15', NULL, 'Unidad'),
('Set de Bolígrafos de Colores (12u)', 3.99, 200, 10, 10, 40, '2023-11-15', NULL, 'Set'),
('Monitor Curvo 27"', 280.00, 20, 1, 1, 5, '2023-12-01', NULL, 'Unidad'),
('Teclado Mecánico RGB', 65.00, 40, 1, 1, 8, '2023-12-01', NULL, 'Unidad'),
('Chaqueta Impermeable', 45.00, 80, 2, 2, 15, '2024-01-10', NULL, 'Unidad'),
('Zapatillas Deportivas Correr', 55.75, 90, 2, 6, 18, '2024-01-10', NULL, 'Par'),
('Sofá Modular 3 Piezas', 350.00, 10, 3, 3, 2, '2024-01-20', NULL, 'Unidad'),
('Set de Ollas Antiadherentes (5 piezas)', 70.50, 30, 3, 3, 6, '2024-01-20', NULL, 'Set'),
('Leche Entera Larga Vida (1L)', 0.90, 600, 4, 4, 120, '2024-02-01', '2024-08-01', 'Litro'),
('Yogurt Griego Natural (500g)', 2.10, 300, 4, 4, 60, '2024-02-01', '2024-03-15', 'Gramo'),
('Coche de Juguete Todoterreno RC', 38.25, 50, 5, 5, 10, '2024-02-15', NULL, 'Unidad'),
('Juego de Mesa Estrategia Avanzada', 42.00, 25, 5, 5, 5, '2024-02-15', NULL, 'Unidad'),
('Raqueta de Tenis Profesional', 95.00, 15, 6, 6, 3, '2024-03-01', NULL, 'Unidad'),
('Mancuernas Ajustables (Par)', 60.20, 20, 6, 6, 4, '2024-03-01', NULL, 'Par'),
('Ensayo Filosófico "Pensar Hoy"', 18.99, 70, 7, 7, 14, '2024-03-10', NULL, 'Unidad'),
('Diccionario Bilingüe Avanzado', 25.50, 60, 7, 7, 12, '2024-03-10', NULL, 'Unidad'),
('Martillo de Carpintero Profesional', 15.75, 80, 8, 8, 16, '2024-04-01', NULL, 'Unidad'),
('Sierra Circular Eléctrica', 110.00, 12, 8, 8, 2, '2024-04-01', NULL, 'Unidad'),
('Juguete Interactivo para Perro', 9.99, 100, 9, 9, 20, '2024-04-15', NULL, 'Unidad'),
('Comida Húmeda para Gato Gourmet (lata)', 1.10, 400, 9, 9, 80, '2024-04-15', '2025-10-15', 'Unidad'),
('Silla Ergonómica de Oficina', 150.00, 20, 10, 10, 4, '2024-05-01', NULL, 'Unidad'),
('Organizador de Escritorio Metálico', 12.30, 90, 10, 10, 18, '2024-05-01', NULL, 'Unidad'),
('Auriculares Inalámbricos Pro', 85.00, 50, 1, 1, 10, '2024-02-10', NULL, 'Unidad'),
('Vestido de Noche Elegante', 75.60, 30, 2, 2, 6, '2024-02-18', NULL, 'Unidad'),
('Mesa de Centro Moderna', 90.00, 25, 3, 3, 5, '2024-03-05', NULL, 'Unidad'),
('Pasta Integral (500g)', 1.50, 400, 4, 4, 80, '2024-03-12', '2025-09-12', 'Gramo'),
('Pelota de Goma para Perro', 4.99, 150, 9, 9, 30, '2024-03-20', NULL, 'Unidad'),
('Cuaderno Ejecutivo Tapa Dura', 7.20, 120, 10, 10, 24, '2024-04-05', NULL, 'Unidad');

INSERT INTO inventario.tabla_ventas (idVenta, idCliente, fechaVenta, total) VALUES (62, 5, '2024-05-21 09:15:00', 0);


INSERT INTO inventario.tabla_ventas (idVenta, idCliente, fechaVenta, total) VALUES (64, 22, '2024-05-22 11:00:00', 0);

INSERT INTO inventario.tabla_ventas (idVenta, idCliente, fechaVenta, total) VALUES (65, 3, '2024-05-22 16:45:00', 0);

INSERT INTO inventario.tabla_ventas (idVenta, idCliente, fechaVenta, total) VALUES (66, 18, '2024-05-23 10:00:00', 0);




INSERT INTO inventario.tabla_ventas (idVenta, idCliente, fechaVenta, total) VALUES (70, 25, '2024-05-25 09:30:00', 0);



INSERT INTO inventario.tabla_ventas (idVenta, idCliente, fechaVenta, total) VALUES (72, 7, '2024-05-26 11:50:00', 0);

INSERT INTO inventario.tabla_ventas (idVenta, idCliente, fechaVenta, total) VALUES (73, 19, '2024-05-26 16:00:00', 0);

INSERT INTO inventario.tabla_ventas (idVenta, idCliente, fechaVenta, total) VALUES (74, 33, '2024-05-27 10:10:00', 0);

INSERT INTO inventario.tabla_ventas (idVenta, idCliente, fechaVenta, total) VALUES (75, 1, '2024-05-27 19:00:00', 0);

INSERT INTO inventario.tabla_ventas (idVenta, idCliente, fechaVenta, total) VALUES (76, 10, '2024-05-28 12:30:00', 0);

INSERT INTO inventario.tabla_ventas (idVenta, idCliente, fechaVenta, total) VALUES (77, 20, '2024-05-28 14:55:00', 0);


INSERT INTO inventario.tabla_ventas (idVenta, idCliente, fechaVenta, total) VALUES (79, 4, '2024-05-29 15:20:00', 0);

INSERT INTO inventario.tabla_ventas (idVenta, idCliente, fechaVenta, total) VALUES (80, 16, '2024-05-30 11:10:00', 0);

INSERT INTO inventario.tabla_ventas (idVenta, idCliente, fechaVenta, total) VALUES (81, 28, '2024-05-30 17:40:00', 0);


INSERT INTO inventario.tabla_ventas (idVenta, idCliente, fechaVenta, total) VALUES (83, 2, '2024-06-01 13:15:00', 0);

INSERT INTO inventario.tabla_ventas (idVenta, idCliente, fechaVenta, total) VALUES (84, 11, '2024-06-02 16:30:00', 0);

INSERT INTO inventario.tabla_ventas (idVenta, idCliente, fechaVenta, total) VALUES (85, 21, '2024-06-02 18:00:00', 0);

INSERT INTO inventario.tabla_ventas (idVenta, idCliente, fechaVenta, total) VALUES (86, 30, '2024-06-03 09:00:00', 0);

INSERT INTO inventario.tabla_ventas (idVenta, idCliente, fechaVenta, total) VALUES (87, 6, '2024-06-03 11:30:00', 0);

INSERT INTO inventario.tabla_ventas (idVenta, idCliente, fechaVenta, total) VALUES (88, 13, '2024-06-04 15:00:00', 0);

INSERT INTO inventario.tabla_ventas (idVenta, idCliente, fechaVenta, total) VALUES (89, 23, '2024-06-04 17:45:00', 0);


INSERT INTO inventario.tabla_detalle_ventas (idVenta, idProducto, cantidad, precioUnitario) VALUES (62, 7, 5, 1.50);

INSERT INTO inventario.tabla_detalle_ventas (idVenta, idProducto, cantidad, precioUnitario) VALUES (62, 8, 2, 6.75);


INSERT INTO inventario.tabla_detalle_ventas (idVenta, idProducto, cantidad, precioUnitario) VALUES (64, 19, 3, 10.50);

INSERT INTO inventario.tabla_detalle_ventas (idVenta, idProducto, cantidad, precioUnitario) VALUES (64, 31, 12, 1.10);

INSERT INTO inventario.tabla_detalle_ventas (idVenta, idProducto, cantidad, precioUnitario) VALUES (65, 3, 2, 15.00);

INSERT INTO inventario.tabla_detalle_ventas (idVenta, idProducto, cantidad, precioUnitario) VALUES (65, 4, 1, 29.50);

INSERT INTO inventario.tabla_detalle_ventas (idVenta, idProducto, cantidad, precioUnitario) VALUES (66, 21, 2, 14.00);



INSERT INTO inventario.tabla_detalle_ventas (idVenta, idProducto, cantidad, precioUnitario) VALUES (68, 15, 1, 99.90);

INSERT INTO inventario.tabla_detalle_ventas (idVenta, idProducto, cantidad, precioUnitario) VALUES (69, 50, 5, 8.00);

INSERT INTO inventario.tabla_detalle_ventas (idVenta, idProducto, cantidad, precioUnitario) VALUES (69, 24, 2, 4.50);


INSERT INTO inventario.tabla_detalle_ventas (idVenta, idProducto, cantidad, precioUnitario) VALUES (72, 13, 1, 17.00);

INSERT INTO inventario.tabla_detalle_ventas (idVenta, idProducto, cantidad, precioUnitario) VALUES (72, 14, 1, 25.00);


INSERT INTO inventario.tabla_detalle_ventas (idVenta, idProducto, cantidad, precioUnitario) VALUES (75, 17, 1, 135.00);

INSERT INTO inventario.tabla_detalle_ventas (idVenta, idProducto, cantidad, precioUnitario) VALUES (75, 2, 1, 499.00);

INSERT INTO inventario.tabla_detalle_ventas (idVenta, idProducto, cantidad, precioUnitario) VALUES (76, 23, 10, 5.00);

INSERT INTO inventario.tabla_detalle_ventas (idVenta, idProducto, cantidad, precioUnitario) VALUES (76, 44, 1, 14.00);

INSERT INTO inventario.tabla_detalle_ventas (idVenta, idProducto, cantidad, precioUnitario) VALUES (77, 20, 1, 19.00);

INSERT INTO inventario.tabla_detalle_ventas (idVenta, idProducto, cantidad, precioUnitario) VALUES (77, 10, 1, 33.00);



INSERT INTO inventario.tabla_detalle_ventas (idVenta, idProducto, cantidad, precioUnitario) VALUES (79, 5, 1, 40.00);

INSERT INTO inventario.tabla_detalle_ventas (idVenta, idProducto, cantidad, precioUnitario) VALUES (79, 6, 2, 20.00);

INSERT INTO inventario.tabla_detalle_ventas (idVenta, idProducto, cantidad, precioUnitario) VALUES (80, 42, 10, 1.25);

INSERT INTO inventario.tabla_detalle_ventas (idVenta, idProducto, cantidad, precioUnitario) VALUES (80, 22, 3, 8.00);

INSERT INTO inventario.tabla_detalle_ventas (idVenta, idProducto, cantidad, precioUnitario) VALUES (81, 27, 1, 50.00);

INSERT INTO inventario.tabla_detalle_ventas (idVenta, idProducto, cantidad, precioUnitario) VALUES (81, 18, 1, 32.00);

INSERT INTO inventario.tabla_detalle_ventas (idVenta, idProducto, cantidad, precioUnitario) VALUES (83, 46, 1, 85.00);

INSERT INTO inventario.tabla_detalle_ventas (idVenta, idProducto, cantidad, precioUnitario) VALUES (84, 12, 1, 50.00);

INSERT INTO inventario.tabla_detalle_ventas (idVenta, idProducto, cantidad, precioUnitario) VALUES (84, 36, 1, 65.00);

INSERT INTO inventario.tabla_detalle_ventas (idVenta, idProducto, cantidad, precioUnitario) VALUES (85, 41, 3, 11.00);

INSERT INTO inventario.tabla_detalle_ventas (idVenta, idProducto, cantidad, precioUnitario) VALUES (85, 49, 2, 5.50);

INSERT INTO inventario.tabla_detalle_ventas (idVenta, idProducto, cantidad, precioUnitario) VALUES (86, 30, 1, 78.00);

INSERT INTO inventario.tabla_detalle_ventas (idVenta, idProducto, cantidad, precioUnitario) VALUES (86, 47, 1, 99.00);

INSERT INTO inventario.tabla_detalle_ventas (idVenta, idProducto, cantidad, precioUnitario) VALUES (87, 11, 2, 32.50);

INSERT INTO inventario.tabla_detalle_ventas (idVenta, idProducto, cantidad, precioUnitario) VALUES (87, 35, 1, 102.00);

INSERT INTO inventario.tabla_detalle_ventas (idVenta, idProducto, cantidad, precioUnitario) VALUES (88, 37, 1, 20.00);

INSERT INTO inventario.tabla_detalle_ventas (idVenta, idProducto, cantidad, precioUnitario) VALUES (88, 38, 1, 28.00);

INSERT INTO inventario.tabla_detalle_ventas (idVenta, idProducto, cantidad, precioUnitario) VALUES (89, 43, 1, 165.00);

INSERT INTO inventario.tabla_detalle_ventas (idVenta, idProducto, cantidad, precioUnitario) VALUES (89, 23, 5, 4.75);


UPDATE inventario.tabla_ventas v
SET v.total = (
    SELECT SUM(dv.cantidad * dv.precioUnitario)
    FROM inventario.tabla_detalle_ventas dv
    WHERE dv.idVenta = v.idVenta
)
WHERE EXISTS (
    SELECT 1
    FROM inventario.tabla_detalle_ventas dv
    WHERE dv.idVenta = v.idVenta
);



UPDATE inventario.tabla_productos
SET precioCompra = 725.00
WHERE idProducto = 1;
