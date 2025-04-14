-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 14-04-2025 a las 18:29:16
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.1.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `foodrider`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administradores`
--

CREATE TABLE `administradores` (
  `id_administrador` int(11) NOT NULL,
  `numero_documento_administrador` varchar(100) NOT NULL,
  `nss` varchar(100) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `apellido_principal` varchar(100) NOT NULL,
  `apellido_secundario` varchar(100) DEFAULT NULL,
  `id_usuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `carritocompraalmacen`
--

CREATE TABLE `carritocompraalmacen` (
  `id_producto_buscado` int(11) NOT NULL,
  `direccion` varchar(255) NOT NULL,
  `coordenadas` varchar(255) NOT NULL,
  `cantidad_buscada` int(11) NOT NULL,
  `precio_unidad_estimado` decimal(10,2) NOT NULL,
  `peso_unidad` int(11) NOT NULL,
  `volumen_unidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comprafinal`
--

CREATE TABLE `comprafinal` (
  `id_compra_final` int(11) NOT NULL,
  `id_producto_almacenado` int(11) NOT NULL,
  `id_ruta_compra` int(11) NOT NULL,
  `nombre_producto` varchar(255) NOT NULL,
  `marca` varchar(100) DEFAULT NULL,
  `id_empresa_proveedora` int(11) DEFAULT NULL,
  `palabra_clave` text DEFAULT NULL,
  `cantidad_total` int(11) NOT NULL,
  `precio_unidad` decimal(10,2) NOT NULL,
  `peso_unidad` int(11) NOT NULL,
  `volumen_unidad` int(11) NOT NULL,
  `tipo` varchar(100) DEFAULT NULL,
  `descripcion` text DEFAULT NULL,
  `notas` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleadosrider`
--

CREATE TABLE `empleadosrider` (
  `id_administrador` int(11) NOT NULL,
  `numero_documento_empleado_rider` varchar(100) NOT NULL,
  `nss` varchar(100) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `apellido_principal` varchar(100) NOT NULL,
  `apellido_secundario` varchar(100) DEFAULT NULL,
  `id_usuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empresasclienteaceptada`
--

CREATE TABLE `empresasclienteaceptada` (
  `id_empresa_cliente_aceptada` int(11) NOT NULL,
  `nombre_empresa_cliente` varchar(255) NOT NULL,
  `cif` varchar(100) DEFAULT NULL,
  `direccion` varchar(255) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `coordenadas` varchar(255) NOT NULL,
  `zona_geografica` int(11) NOT NULL,
  `notas` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empresasclientenoaceptada`
--

CREATE TABLE `empresasclientenoaceptada` (
  `id_empresa_cliente_no_aceptada` int(11) NOT NULL,
  `nombre_empresa_cliente` varchar(255) NOT NULL,
  `cif` varchar(100) DEFAULT NULL,
  `direccion` varchar(255) NOT NULL,
  `id_usuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empresasproveedora`
--

CREATE TABLE `empresasproveedora` (
  `id_empresa_cliente` int(11) NOT NULL,
  `nombre_empresa_proveedora` varchar(255) NOT NULL,
  `cif` varchar(100) DEFAULT NULL,
  `direccion` varchar(255) NOT NULL,
  `id_usuario` varchar(100) NOT NULL,
  `coordenadas` varchar(255) NOT NULL,
  `zona_geografica` int(11) NOT NULL,
  `notas` text DEFAULT NULL,
  `especialidad` varchar(255) NOT NULL,
  `telefono` varchar(20) NOT NULL,
  `email` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paquetecompra`
--

CREATE TABLE `paquetecompra` (
  `id_paquete_compra` int(11) NOT NULL,
  `id_producto_buscado` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productosalmacenados`
--

CREATE TABLE `productosalmacenados` (
  `id_producto_almacenado` int(11) NOT NULL,
  `nombre_producto` varchar(255) NOT NULL,
  `marca` varchar(100) DEFAULT NULL,
  `id_empresa_proveedora` int(11) DEFAULT NULL,
  `palabra_clave` text DEFAULT NULL,
  `cantidad_total` int(11) NOT NULL,
  `precio_unidad` decimal(10,2) NOT NULL,
  `peso_unidad` int(11) NOT NULL,
  `volumen_unidad` int(11) NOT NULL,
  `tipo` varchar(100) DEFAULT NULL,
  `descripcion` text DEFAULT NULL,
  `notas` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productosfrecuentes`
--

CREATE TABLE `productosfrecuentes` (
  `id_producto_frecuente` int(11) NOT NULL,
  `nombre_producto` varchar(255) NOT NULL,
  `marca` varchar(100) DEFAULT NULL,
  `id_empresa_proveedora` int(11) DEFAULT NULL,
  `nombre_proveedor` varchar(255) DEFAULT NULL,
  `direccion` varchar(255) NOT NULL,
  `coordenadas` varchar(255) DEFAULT NULL,
  `palabra_clave` varchar(100) DEFAULT NULL,
  `precio` decimal(10,2) DEFAULT NULL,
  `peso` int(11) DEFAULT NULL,
  `volumen` int(11) DEFAULT NULL,
  `descripcion` text DEFAULT NULL,
  `notas` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rutacompraasignada`
--

CREATE TABLE `rutacompraasignada` (
  `id_ruta_compra` int(11) NOT NULL,
  `id_administrador` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rutacompranoasignada`
--

CREATE TABLE `rutacompranoasignada` (
  `id_ruta_compra` int(11) NOT NULL,
  `id_paquete_compra` int(11) NOT NULL,
  `fecha` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id_usuario` int(11) NOT NULL,
  `nick` varchar(100) NOT NULL,
  `contrasenia` varchar(100) NOT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `zonageografica`
--

CREATE TABLE `zonageografica` (
  `id_zona_geografica` int(11) NOT NULL,
  `zona_geografica` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `administradores`
--
ALTER TABLE `administradores`
  ADD PRIMARY KEY (`id_administrador`),
  ADD UNIQUE KEY `numero_documento_administrador` (`numero_documento_administrador`),
  ADD UNIQUE KEY `nss` (`nss`),
  ADD UNIQUE KEY `id_usuario` (`id_usuario`);

--
-- Indices de la tabla `carritocompraalmacen`
--
ALTER TABLE `carritocompraalmacen`
  ADD PRIMARY KEY (`id_producto_buscado`);

--
-- Indices de la tabla `comprafinal`
--
ALTER TABLE `comprafinal`
  ADD PRIMARY KEY (`id_compra_final`),
  ADD UNIQUE KEY `nombre_producto` (`nombre_producto`,`marca`),
  ADD KEY `id_producto_almacenado` (`id_producto_almacenado`),
  ADD KEY `id_ruta_compra` (`id_ruta_compra`),
  ADD KEY `id_empresa_proveedora` (`id_empresa_proveedora`);

--
-- Indices de la tabla `empleadosrider`
--
ALTER TABLE `empleadosrider`
  ADD PRIMARY KEY (`id_administrador`),
  ADD UNIQUE KEY `numero_documento_empleado_rider` (`numero_documento_empleado_rider`),
  ADD UNIQUE KEY `nss` (`nss`),
  ADD UNIQUE KEY `id_usuario` (`id_usuario`);

--
-- Indices de la tabla `empresasclienteaceptada`
--
ALTER TABLE `empresasclienteaceptada`
  ADD PRIMARY KEY (`id_empresa_cliente_aceptada`),
  ADD UNIQUE KEY `nombre_empresa_cliente` (`nombre_empresa_cliente`),
  ADD UNIQUE KEY `direccion` (`direccion`),
  ADD UNIQUE KEY `id_usuario` (`id_usuario`),
  ADD UNIQUE KEY `cif` (`cif`),
  ADD KEY `zona_geografica` (`zona_geografica`);

--
-- Indices de la tabla `empresasclientenoaceptada`
--
ALTER TABLE `empresasclientenoaceptada`
  ADD PRIMARY KEY (`id_empresa_cliente_no_aceptada`),
  ADD UNIQUE KEY `nombre_empresa_cliente` (`nombre_empresa_cliente`),
  ADD UNIQUE KEY `direccion` (`direccion`),
  ADD UNIQUE KEY `id_usuario` (`id_usuario`),
  ADD UNIQUE KEY `cif` (`cif`);

--
-- Indices de la tabla `empresasproveedora`
--
ALTER TABLE `empresasproveedora`
  ADD PRIMARY KEY (`id_empresa_cliente`),
  ADD UNIQUE KEY `nombre_empresa_proveedora` (`nombre_empresa_proveedora`),
  ADD UNIQUE KEY `direccion` (`direccion`),
  ADD UNIQUE KEY `id_usuario` (`id_usuario`),
  ADD UNIQUE KEY `telefono` (`telefono`),
  ADD UNIQUE KEY `cif` (`cif`),
  ADD UNIQUE KEY `email` (`email`),
  ADD KEY `zona_geografica` (`zona_geografica`);

--
-- Indices de la tabla `paquetecompra`
--
ALTER TABLE `paquetecompra`
  ADD PRIMARY KEY (`id_paquete_compra`),
  ADD UNIQUE KEY `id_producto_buscado` (`id_producto_buscado`);

--
-- Indices de la tabla `productosalmacenados`
--
ALTER TABLE `productosalmacenados`
  ADD PRIMARY KEY (`id_producto_almacenado`),
  ADD UNIQUE KEY `nombre_producto` (`nombre_producto`,`marca`),
  ADD KEY `id_empresa_proveedora` (`id_empresa_proveedora`);

--
-- Indices de la tabla `productosfrecuentes`
--
ALTER TABLE `productosfrecuentes`
  ADD PRIMARY KEY (`id_producto_frecuente`),
  ADD UNIQUE KEY `nombre_producto` (`nombre_producto`,`marca`),
  ADD KEY `id_empresa_proveedora` (`id_empresa_proveedora`);

--
-- Indices de la tabla `rutacompraasignada`
--
ALTER TABLE `rutacompraasignada`
  ADD PRIMARY KEY (`id_ruta_compra`),
  ADD UNIQUE KEY `id_administrador` (`id_administrador`);

--
-- Indices de la tabla `rutacompranoasignada`
--
ALTER TABLE `rutacompranoasignada`
  ADD PRIMARY KEY (`id_ruta_compra`),
  ADD UNIQUE KEY `id_paquete_compra` (`id_paquete_compra`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id_usuario`),
  ADD UNIQUE KEY `nick` (`nick`),
  ADD UNIQUE KEY `telefono` (`telefono`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indices de la tabla `zonageografica`
--
ALTER TABLE `zonageografica`
  ADD PRIMARY KEY (`id_zona_geografica`),
  ADD UNIQUE KEY `zona_geografica` (`zona_geografica`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `administradores`
--
ALTER TABLE `administradores`
  MODIFY `id_administrador` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `carritocompraalmacen`
--
ALTER TABLE `carritocompraalmacen`
  MODIFY `id_producto_buscado` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `comprafinal`
--
ALTER TABLE `comprafinal`
  MODIFY `id_compra_final` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `empleadosrider`
--
ALTER TABLE `empleadosrider`
  MODIFY `id_administrador` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `empresasclienteaceptada`
--
ALTER TABLE `empresasclienteaceptada`
  MODIFY `id_empresa_cliente_aceptada` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `empresasclientenoaceptada`
--
ALTER TABLE `empresasclientenoaceptada`
  MODIFY `id_empresa_cliente_no_aceptada` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `empresasproveedora`
--
ALTER TABLE `empresasproveedora`
  MODIFY `id_empresa_cliente` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `paquetecompra`
--
ALTER TABLE `paquetecompra`
  MODIFY `id_paquete_compra` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `productosalmacenados`
--
ALTER TABLE `productosalmacenados`
  MODIFY `id_producto_almacenado` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `productosfrecuentes`
--
ALTER TABLE `productosfrecuentes`
  MODIFY `id_producto_frecuente` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `rutacompranoasignada`
--
ALTER TABLE `rutacompranoasignada`
  MODIFY `id_ruta_compra` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `zonageografica`
--
ALTER TABLE `zonageografica`
  MODIFY `id_zona_geografica` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `administradores`
--
ALTER TABLE `administradores`
  ADD CONSTRAINT `administradores_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`);

--
-- Filtros para la tabla `comprafinal`
--
ALTER TABLE `comprafinal`
  ADD CONSTRAINT `comprafinal_ibfk_1` FOREIGN KEY (`id_producto_almacenado`) REFERENCES `productosalmacenados` (`id_producto_almacenado`),
  ADD CONSTRAINT `comprafinal_ibfk_2` FOREIGN KEY (`id_ruta_compra`) REFERENCES `rutacompraasignada` (`id_ruta_compra`),
  ADD CONSTRAINT `comprafinal_ibfk_3` FOREIGN KEY (`id_empresa_proveedora`) REFERENCES `empresasproveedora` (`id_empresa_cliente`);

--
-- Filtros para la tabla `empleadosrider`
--
ALTER TABLE `empleadosrider`
  ADD CONSTRAINT `empleadosrider_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`);

--
-- Filtros para la tabla `empresasclienteaceptada`
--
ALTER TABLE `empresasclienteaceptada`
  ADD CONSTRAINT `empresasclienteaceptada_ibfk_1` FOREIGN KEY (`zona_geografica`) REFERENCES `zonageografica` (`id_zona_geografica`);

--
-- Filtros para la tabla `empresasproveedora`
--
ALTER TABLE `empresasproveedora`
  ADD CONSTRAINT `empresasproveedora_ibfk_1` FOREIGN KEY (`zona_geografica`) REFERENCES `zonageografica` (`id_zona_geografica`);

--
-- Filtros para la tabla `paquetecompra`
--
ALTER TABLE `paquetecompra`
  ADD CONSTRAINT `paquetecompra_ibfk_1` FOREIGN KEY (`id_producto_buscado`) REFERENCES `carritocompraalmacen` (`id_producto_buscado`);

--
-- Filtros para la tabla `productosalmacenados`
--
ALTER TABLE `productosalmacenados`
  ADD CONSTRAINT `productosalmacenados_ibfk_1` FOREIGN KEY (`id_empresa_proveedora`) REFERENCES `empresasproveedora` (`id_empresa_cliente`);

--
-- Filtros para la tabla `productosfrecuentes`
--
ALTER TABLE `productosfrecuentes`
  ADD CONSTRAINT `productosfrecuentes_ibfk_1` FOREIGN KEY (`id_empresa_proveedora`) REFERENCES `empresasproveedora` (`id_empresa_cliente`);

--
-- Filtros para la tabla `rutacompraasignada`
--
ALTER TABLE `rutacompraasignada`
  ADD CONSTRAINT `rutacompraasignada_ibfk_1` FOREIGN KEY (`id_ruta_compra`) REFERENCES `rutacompranoasignada` (`id_ruta_compra`),
  ADD CONSTRAINT `rutacompraasignada_ibfk_2` FOREIGN KEY (`id_administrador`) REFERENCES `administradores` (`id_administrador`);

--
-- Filtros para la tabla `rutacompranoasignada`
--
ALTER TABLE `rutacompranoasignada`
  ADD CONSTRAINT `rutacompranoasignada_ibfk_1` FOREIGN KEY (`id_paquete_compra`) REFERENCES `paquetecompra` (`id_paquete_compra`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
