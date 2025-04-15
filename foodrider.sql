/*
mysql -u root -p

CREATE USER 'proyecto_food_rider'@'localhost' IDENTIFIED BY 'proyecto_food_rider';
GRANT ALL PRIVILEGES ON proyecto_food_rider.* TO 'proyecto_food_rider'@'localhost' WITH GRANT OPTION;
Flush privileges
*/

-- Tabla Usuarios
CREATE TABLE Usuarios (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nick VARCHAR(100) NOT NULL UNIQUE,
    contrasenia VARCHAR(100) NOT NULL,
    telefono VARCHAR(20) UNIQUE,
    email VARCHAR(100) UNIQUE
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
    id_administrador INT AUTO_INCREMENT PRIMARY KEY,
    numero_documento_empleado_rider VARCHAR(100) NOT NULL UNIQUE,
    nss VARCHAR(100) NOT NULL UNIQUE,
    nombre VARCHAR(100) NOT NULL,
    apellido_principal VARCHAR(100) NOT NULL,
    apellido_secundario VARCHAR(100),
    id_usuario INT NOT NULL UNIQUE,
    FOREIGN KEY (id_usuario) REFERENCES Usuarios(id_usuario)
);

CREATE TABLE EmpresasClienteNoAceptada (
    id_empresa_cliente_no_aceptada INT AUTO_INCREMENT PRIMARY KEY,
    nombre_empresa_cliente VARCHAR(255) NOT NULL UNIQUE,
    cif VARCHAR(100) UNIQUE,
    direccion VARCHAR(255) NOT NULL UNIQUE,
    id_usuario INT NOT NULL UNIQUE
);

-- Tabla ZonaGeografica
CREATE TABLE ZonaGeografica (
    id_zona_geografica INT AUTO_INCREMENT PRIMARY KEY,
    zona_geografica INT NOT NULL UNIQUE
);

CREATE TABLE EmpresasClienteAceptada (
    id_empresa_cliente_aceptada INT AUTO_INCREMENT PRIMARY KEY,
    nombre_empresa_cliente VARCHAR(255) NOT NULL UNIQUE,
    cif VARCHAR(100) UNIQUE,
    direccion VARCHAR(255) NOT NULL UNIQUE,
    id_usuario INT NOT NULL UNIQUE,
    coordenadas VARCHAR(255) NOT NULL,
    zona_geografica INT NOT NULL,
    notas TEXT,
    FOREIGN KEY (zona_geografica) REFERENCES ZonaGeografica(id_zona_geografica)
);

-- Tabla EmpresasProveedora
CREATE TABLE EmpresasProveedora (
    id_empresa_cliente INT AUTO_INCREMENT PRIMARY KEY,
    nombre_empresa_proveedora VARCHAR(255) NOT NULL UNIQUE,
    cif VARCHAR(100) UNIQUE,
    direccion VARCHAR(255) NOT NULL UNIQUE,
    id_usuario VARCHAR(100) NOT NULL UNIQUE,
    coordenadas VARCHAR(255) NOT NULL,
    zona_geografica INT NOT NULL,
    notas TEXT,
    especialidad VARCHAR(255) NOT NULL,
    telefono VARCHAR(20) NOT NULL UNIQUE,
    email VARCHAR(100) UNIQUE,
    FOREIGN KEY (zona_geografica) REFERENCES ZonaGeografica(id_zona_geografica)
);

CREATE TABLE ProductosFrecuentes (
    id_producto_frecuente INT AUTO_INCREMENT PRIMARY KEY,
    nombre_producto VARCHAR(255) NOT NULL,
    marca VARCHAR(100),
    id_empresa_proveedora INT,
    nombre_proveedor VARCHAR(255),
    direccion VARCHAR(255) NOT NULL,
    coordenadas VARCHAR(255),
    palabra_clave VARCHAR(100),
    precio DECIMAL(10,2),
    peso INT,
    volumen INT,
    descripcion TEXT,
    notas TEXT,
    UNIQUE(nombre_producto, marca),
    FOREIGN KEY (id_empresa_proveedora) REFERENCES EmpresasProveedora(id_empresa_cliente)
);








-- Tabla CarritoCompraAlmacen
CREATE TABLE CarritoCompraAlmacen (
    id_producto_buscado INT AUTO_INCREMENT PRIMARY KEY,
    direccion VARCHAR(255) NOT NULL,
    coordenadas VARCHAR(255) NOT NULL,
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
