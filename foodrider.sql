/*
mysql -u root -p

CREATE USER 'proyecto_food_rider'@'localhost' IDENTIFIED BY 'proyecto_food_rider';
GRANT ALL PRIVILEGES ON proyecto_food_rider.* TO 'proyecto_food_rider'@'localhost' WITH GRANT OPTION;
Flush privileges
*/

DROP DATABASE IF EXISTS proyecto_food_rider;
CREATE DATABASE IF NOT EXISTS proyecto_food_rider;
USE proyecto_food_rider;

-- Empezamos a crear tablas

CREATE TABLE UsuariosNoAceptado (
    id_usuario_no_aceptado INT AUTO_INCREMENT PRIMARY KEY,
    nick VARCHAR(100) NOT NULL UNIQUE,
    contrasenia VARCHAR(100) NOT NULL,
    telefono VARCHAR(20),
    email VARCHAR(100),
    tipo VARCHAR(20) NOT NULL
);

CREATE TABLE EmpresasClienteNoAceptado (
    id_empresa_cliente_no_aceptada INT AUTO_INCREMENT PRIMARY KEY,
    nombre_empresa_cliente VARCHAR(255) NOT NULL UNIQUE,
    cif VARCHAR(100) UNIQUE,
    direccion VARCHAR(255) NOT NULL UNIQUE,
    id_usuario_no_aceptado INT,
    FOREIGN KEY (id_usuario_no_aceptado) 
        REFERENCES UsuariosNoAceptado(id_usuario_no_aceptado)
        ON DELETE CASCADE
);


-- Tabla Usuarios
CREATE TABLE Usuarios (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nick VARCHAR(100) NOT NULL UNIQUE,
    contrasenia VARCHAR(100) NOT NULL,
    telefono VARCHAR(20),
    email VARCHAR(100),
    tipo VARCHAR(20) NOT NULL
);

CREATE TABLE EmpresasCliente (
    id_empresa_cliente INT AUTO_INCREMENT PRIMARY KEY,
    nombre_empresa_cliente VARCHAR(255) NOT NULL UNIQUE,
    cif VARCHAR(100) UNIQUE,
    direccion VARCHAR(255) NOT NULL UNIQUE,
    id_usuario INT,
        FOREIGN KEY (id_usuario) 
        REFERENCES Usuarios(id_usuario)
        ON DELETE CASCADE
);

-- Tabla Administradores
CREATE TABLE Administradores (
    id_administrador INT AUTO_INCREMENT PRIMARY KEY,
    numero_documento_administrador VARCHAR(100) NOT NULL UNIQUE,
    nss VARCHAR(100) NOT NULL UNIQUE,
    nombre VARCHAR(100) NOT NULL,
    apellido_principal VARCHAR(100) NOT NULL,
    apellido_secundario VARCHAR(100),
    id_usuario INT,
        FOREIGN KEY (id_usuario) 
        REFERENCES Usuarios(id_usuario)
        ON DELETE CASCADE
);

-- Tabla EmpleadosRider
CREATE TABLE EmpleadosRider (
    id_empleado_rider INT AUTO_INCREMENT PRIMARY KEY,
    numero_documento_empleado_rider VARCHAR(100) NOT NULL UNIQUE,
    nss VARCHAR(100) NOT NULL UNIQUE,
    nombre VARCHAR(100) NOT NULL,
    apellido_principal VARCHAR(100) NOT NULL,
    apellido_secundario VARCHAR(100),
    id_usuario INT,
        FOREIGN KEY (id_usuario) 
        REFERENCES Usuarios(id_usuario)
        ON DELETE CASCADE
);

-- Tabla Comprador
CREATE TABLE Compradores (
    id_comprador INT AUTO_INCREMENT PRIMARY KEY,
    numero_documento_comprador VARCHAR(100) NOT NULL UNIQUE,
    nss VARCHAR(100) NOT NULL UNIQUE,
    nombre VARCHAR(100) NOT NULL,
    apellido_principal VARCHAR(100) NOT NULL,
    apellido_secundario VARCHAR(100),
    id_usuario INT,
        FOREIGN KEY (id_usuario) 
        REFERENCES Usuarios(id_usuario)
        ON DELETE CASCADE
);

-- Tabla de tipos de producto
CREATE TABLE TiposProducto (
    id_tipo_producto INT AUTO_INCREMENT PRIMARY KEY,
    nombre_tipo VARCHAR(100) NOT NULL UNIQUE
);

-- Tabla de productos generales
CREATE TABLE Productos (
    id_producto INT AUTO_INCREMENT PRIMARY KEY,
    nombre_producto VARCHAR(255) NOT NULL,
    marca VARCHAR(100),
    peso INT,
    volumen INT,
    descripcion TEXT,
    ruta_imagen VARCHAR(255), -- NUEVA COLUMNA para la ruta de imagen
    id_tipo_producto INT,
    UNIQUE(nombre_producto, marca),
    FOREIGN KEY (id_tipo_producto) REFERENCES TiposProducto(id_tipo_producto)
);


-- Tabla de empresas proveedoras
CREATE TABLE EmpresasProveedora (
    id_empresa_proveedora INT AUTO_INCREMENT PRIMARY KEY,
    nombre_empresa_proveedora VARCHAR(255) NOT NULL UNIQUE,
    cif VARCHAR(100) UNIQUE,
    direccion VARCHAR(255) NOT NULL UNIQUE,
    especialidad VARCHAR(255) NOT NULL,
    telefono VARCHAR(20) NOT NULL UNIQUE,
    email VARCHAR(100) UNIQUE
);

-- Tabla intermedia para productos vendidos por empresas proveedoras
CREATE TABLE ProductosFrecuentes (
    id_producto_frecuente INT AUTO_INCREMENT PRIMARY KEY,
    id_producto INT NOT NULL,
    id_empresa_proveedora INT NOT NULL,
    precio DECIMAL(10,2),
    
    FOREIGN KEY (id_producto) REFERENCES Productos(id_producto),
    FOREIGN KEY (id_empresa_proveedora) REFERENCES EmpresasProveedora(id_empresa_proveedora),
    
    UNIQUE(id_producto, id_empresa_proveedora)
);


-- Tabla CarritoCompraAlmacen
CREATE TABLE CarritoCompraAlmacen (
    id_producto_buscado INT AUTO_INCREMENT PRIMARY KEY,
    direccion VARCHAR(255) NOT NULL,
    cantidad_buscada INT NOT NULL,
    precio_unidad_estimado DECIMAL(10,2) NOT NULL,
    peso_unidad INT NOT NULL,
    volumen_unidad INT NOT NULL
);

-- Tabla PaqueteCompra
CREATE TABLE PaqueteCompra (
    id_paquete_compra INT AUTO_INCREMENT PRIMARY KEY,
    id_producto_buscado INT NOT NULL UNIQUE,
    FOREIGN KEY (id_producto_buscado) REFERENCES CarritoCompraAlmacen(id_producto_buscado)
);

-- Tabla RutaCompraNoAsignada
CREATE TABLE RutaCompraNoAsignada (
    id_ruta_compra INT AUTO_INCREMENT PRIMARY KEY,
    id_paquete_compra INT NOT NULL UNIQUE,
    fecha DATE,
    FOREIGN KEY (id_paquete_compra) REFERENCES PaqueteCompra(id_paquete_compra)
);

-- Tabla RutaCompraAsignada
CREATE TABLE RutaCompraAsignada (
    id_ruta_compra INT PRIMARY KEY,
    id_administrador INT NOT NULL UNIQUE,
    FOREIGN KEY (id_ruta_compra) REFERENCES RutaCompraNoAsignada(id_ruta_compra),
    FOREIGN KEY (id_administrador) REFERENCES Administradores(id_administrador)
);

CREATE TABLE ProductosAlmacenados (
    id_producto_almacenado INT AUTO_INCREMENT PRIMARY KEY,
    nombre_producto VARCHAR(255) NOT NULL,
    marca VARCHAR(100),
    id_empresa_proveedora INT,
    palabra_clave TEXT,
    cantidad_total INT NOT NULL,
    precio_unidad DECIMAL(10,2) NOT NULL,
    peso_unidad INT NOT NULL,
    volumen_unidad INT NOT NULL,
    tipo VARCHAR(100),
    descripcion TEXT,
    notas TEXT,
    UNIQUE(nombre_producto, marca),  -- Restricción única sobre nombre_producto y marca
    FOREIGN KEY (id_empresa_proveedora) REFERENCES EmpresasProveedora(id_empresa_proveedora)
);

CREATE TABLE CompraFinal (
    id_compra_final INT AUTO_INCREMENT PRIMARY KEY,
    id_producto_almacenado INT NOT NULL,
    id_ruta_compra INT NOT NULL,
    nombre_producto VARCHAR(255) NOT NULL,
    marca VARCHAR(100),
    id_empresa_proveedora INT,
    palabra_clave TEXT,
    cantidad_total INT NOT NULL,
    precio_unidad DECIMAL(10,2) NOT NULL,
    peso_unidad INT NOT NULL,
    volumen_unidad INT NOT NULL,
    tipo VARCHAR(100),
    descripcion TEXT,
    notas TEXT,
    UNIQUE(nombre_producto, marca),  -- Restricción única sobre nombre_producto y marca
    FOREIGN KEY (id_producto_almacenado) REFERENCES ProductosAlmacenados(id_producto_almacenado),
    FOREIGN KEY (id_ruta_compra) REFERENCES RutaCompraAsignada(id_ruta_compra),
    FOREIGN KEY (id_empresa_proveedora) REFERENCES EmpresasProveedora(id_empresa_proveedora)
);

-- Recuperar el último ID insertado
SET @id_usuario := LAST_INSERT_ID();

-- Insertamos valores

INSERT INTO Usuarios (nick, contrasenia, telefono, email, tipo) VALUES
('aa', 'a', '238745678', 'aa@example.com', 'Administrador'),
('rr', 'r', '790456789', 'cc@example.com', 'Rider'),
('cc', 'c', '979567890', 'pp@example.com', 'Comprador'),
('ec', 'ec', NULL, 'ec@example.com', 'Empresa Cliente');



INSERT INTO Administradores (numero_documento_administrador, nss, nombre, apellido_principal, apellido_secundario, id_usuario)
VALUES 
('284123456A', 'NSSADM7890', 'Ann', 'Smith', '', 1);

INSERT INTO EmpleadosRider (numero_documento_empleado_rider, nss, nombre, apellido_principal, apellido_secundario, id_usuario)
VALUES 
('286254321J', 'NSSRIDER4567', 'Jon', 'Fernández', 'Gómez', 2);

INSERT INTO Compradores (numero_documento_comprador, nss, nombre, apellido_principal, apellido_secundario, id_usuario)
VALUES 
('289987654C', 'NSSCOM1234', 'Carlos', 'Martínez', 'Santos', 3);

-- TiposProducto
INSERT INTO TiposProducto (nombre_tipo) VALUES 
('Frutas y Verduras'),
('Carnicería y Charcutería'),
('Pescadería'),
('Lácteos y Huevos'),
('Panadería y Bollería'),
('Bebidas'),
('Alimentos Secos'),
('Congelados'),
('Productos de Limpieza');

-- Productos
INSERT INTO Productos (nombre_producto, marca, peso, volumen, descripcion, ruta_imagen, id_tipo_producto) 
VALUES 
('Manzana Golden', 'Fruta Selecta', 1000, 2000, 'Manzanas golden deliciosas y jugosas', 'imagenes/manzana_golden.jpg', 1),
('Pechuga de Pollo', 'CampoReal', 500, 1000, 'Pechuga de pollo fresca sin hormonas', 'imagenes/pechuga_pollo.jpg', 2),
('Salmón Fresco', 'Pescados del Norte', 300, 1500, 'Filetes de salmón fresco del Atlántico', 'imagenes/salmon.jpg', 3),
('Leche Entera', 'Central Lechera', 1000, 1000, 'Leche entera pasteurizada', 'imagenes/leche_entera.jpg', 4),
('Pan Integral', 'Horno Artesano', 500, 3000, 'Pan integral de masa madre', 'imagenes/pan_integral.jpg', 5),
('Agua Mineral', 'FontVella', 1500, 1500, 'Agua mineral natural', 'imagenes/agua_mineral.jpg', 6),
('Arroz Blanco', 'Sos', 1000, 1200, 'Arroz blanco de grano largo', 'imagenes/arroz_blanco.jpg', 7),
('Helado de Vainilla', 'La Menorquina', 500, 2000, 'Helado cremoso de vainilla', 'imagenes/helado_vainilla.jpg', 8),
('Detergente Líquido', 'Ariel', 1500, 1500, 'Detergente para ropa color', 'imagenes/detergente.jpg', 9);

-- EmpresasProveedora
INSERT INTO EmpresasProveedora (nombre_empresa_proveedora, cif, direccion, especialidad, telefono, email) 
VALUES 
('Distribuciones Alimentarias SA', 'A12345678', 'Calle Mayor 10, Madrid', 'Distribución alimentaria', '912345678', 'info@distalim.com'),
('Frutas y Verduras Frescas SL', 'B87654321', 'Avenida del Puerto 45, Valencia', 'Productos frescos', '963215487', 'contacto@frutver.com'),
('Carnicerías Premium', 'C56789123', 'Calle Comercio 22, Sevilla', 'Productos cárnicos', '954123654', 'ventas@carnprem.es'),
('Lácteos del Norte', 'D32165498', 'Polígono Industrial Norte, Burgos', 'Productos lácteos', '947852369', 'info@lactnorte.com'),
('Bebidas Selectas', 'E78945612', 'Calle Rioja 15, Logroño', 'Bebidas y licores', '941753951', 'pedidos@bebselect.es');

-- ProductosFrecuentes
INSERT INTO ProductosFrecuentes (id_producto, id_empresa_proveedora, precio) 
VALUES 
(1, 2, 1.99),
(2, 3, 5.99),
(3, 1, 12.50),
(4, 4, 0.99),
(5, 1, 2.50),
(6, 5, 0.75),
(7, 1, 1.20),
(8, 1, 3.95),
(9, 1, 4.50);