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
    tipo VARCHAR(20) NOT NULL,
    activo BOOLEAN NOT NULL
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
    tipo VARCHAR(20) NOT NULL,
    activo BOOLEAN NOT NULL
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
    id_usuario INT NOT NULL UNIQUE,
    FOREIGN KEY (id_usuario) REFERENCES Usuarios(id_usuario)
);

-- Tabla EmpleadosRider
CREATE TABLE EmpleadosRider (
    id_empleado_rider INT AUTO_INCREMENT PRIMARY KEY,
    numero_documento_empleado_rider VARCHAR(100) NOT NULL UNIQUE,
    nss VARCHAR(100) NOT NULL UNIQUE,
    nombre VARCHAR(100) NOT NULL,
    apellido_principal VARCHAR(100) NOT NULL,
    apellido_secundario VARCHAR(100),
    id_usuario INT NOT NULL UNIQUE,
    FOREIGN KEY (id_usuario) REFERENCES Usuarios(id_usuario)
);

-- Tabla Comprador
CREATE TABLE Comprador (
    id_comprador INT AUTO_INCREMENT PRIMARY KEY,
    numero_documento_empleado_rider VARCHAR(100) NOT NULL UNIQUE,
    nss VARCHAR(100) NOT NULL UNIQUE,
    nombre VARCHAR(100) NOT NULL,
    apellido_principal VARCHAR(100) NOT NULL,
    apellido_secundario VARCHAR(100),
    id_usuario INT NOT NULL UNIQUE,
    FOREIGN KEY (id_usuario) REFERENCES Usuarios(id_usuario)
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
    id_tipo_producto INT,
    UNIQUE(nombre_producto, marca),
    FOREIGN KEY (id_tipo_producto) REFERENCES TiposProducto(id_tipo_producto)
);

-- Tabla de empresas proveedoras
CREATE TABLE EmpresasProveedora (
    id_empresa_cliente INT AUTO_INCREMENT PRIMARY KEY,
    nombre_empresa_proveedora VARCHAR(255) NOT NULL UNIQUE,
    cif VARCHAR(100) UNIQUE,
    direccion VARCHAR(255) NOT NULL UNIQUE,
    id_usuario VARCHAR(100) NOT NULL UNIQUE,
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
    FOREIGN KEY (id_empresa_proveedora) REFERENCES EmpresasProveedora(id_empresa_cliente),
    
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
    FOREIGN KEY (id_empresa_proveedora) REFERENCES EmpresasProveedora(id_empresa_cliente)
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
    FOREIGN KEY (id_empresa_proveedora) REFERENCES EmpresasProveedora(id_empresa_cliente)
);

-- Recuperar el último ID insertado
SET @id_usuario := LAST_INSERT_ID();

INSERT INTO Usuarios (nick, contrasenia, telefono, email, tipo, activo)
VALUES 
('ann', 'a', '5559876543', 'ann@example.com', 'Administrador', FALSE),
('jon', 'j', '7827439136', 'jon@example.com', 'Rider', FALSE),
('car', 'c', '5637478467', 'carlos@example.com', 'Comprador', FALSE);

INSERT INTO Administradores (numero_documento_administrador, nss, nombre, apellido_principal, apellido_secundario, id_usuario)
VALUES 
('284123456A', 'NSSADM7890', 'Ann', 'Smith', '', 1);

INSERT INTO EmpleadosRider (numero_documento_empleado_rider, nss, nombre, apellido_principal, apellido_secundario, id_usuario)
VALUES 
('286254321J', 'NSSRIDER4567', 'Jon', 'Fernández', 'Gómez', 2);

INSERT INTO Comprador (numero_documento_empleado_rider, nss, nombre, apellido_principal, apellido_secundario, id_usuario)
VALUES 
('289987654C', 'NSSCOM1234', 'Carlos', 'Martínez', 'Santos', 3);
