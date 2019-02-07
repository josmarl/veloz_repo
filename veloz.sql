-- phpMyAdmin SQL Dump
-- version 4.3.11
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 07-02-2019 a las 19:22:38
-- Versión del servidor: 5.6.24
-- Versión de PHP: 5.6.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `veloz`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `almacen`
--

CREATE TABLE IF NOT EXISTS `almacen` (
  `id` int(11) NOT NULL,
  `nro_doc` varchar(60) DEFAULT NULL,
  `usuario` int(11) DEFAULT NULL,
  `cliente` int(11) DEFAULT NULL,
  `fecha_reg` date DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

--
-- Volcado de datos para la tabla `almacen`
--

INSERT INTO `almacen` (`id`, `nro_doc`, `usuario`, `cliente`, `fecha_reg`) VALUES
(5, '001-3213', 1, 5, '2019-02-07');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `almacen_consolidado`
--

CREATE TABLE IF NOT EXISTS `almacen_consolidado` (
  `id` int(11) NOT NULL,
  `producto` int(60) DEFAULT NULL,
  `disponible` int(60) DEFAULT NULL,
  `vendido` int(60) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `almacen_consolidado`
--

INSERT INTO `almacen_consolidado` (`id`, `producto`, `disponible`, `vendido`) VALUES
(28, 12, 1200, 0),
(29, 13, 1000, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `almacen_detalle`
--

CREATE TABLE IF NOT EXISTS `almacen_detalle` (
  `id` int(11) NOT NULL,
  `producto` int(11) DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `almacen` int(11) DEFAULT NULL,
  `importe` double DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

--
-- Volcado de datos para la tabla `almacen_detalle`
--

INSERT INTO `almacen_detalle` (`id`, `producto`, `cantidad`, `almacen`, `importe`) VALUES
(7, 12, 1200, 5, 1800),
(8, 13, 1000, 5, 3000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE IF NOT EXISTS `cliente` (
  `id` int(11) NOT NULL,
  `razon_social` varchar(200) DEFAULT NULL,
  `ruc` bigint(11) DEFAULT NULL,
  `dni` int(11) DEFAULT NULL,
  `direccion` varchar(100) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`id`, `razon_social`, `ruc`, `dni`, `direccion`) VALUES
(1, 'Loro EIRL', 1045454545, NULL, 'ok'),
(2, 'Artesco EIRL', 12121212, NULL, 'ok'),
(3, 'Jose Limachi', 11111111111, 45454545, 'ok'),
(4, 'Juan perez', 0, 0, ''),
(5, 'Carlos', 0, 23232323, ''),
(6, 'Jorge', 0, 0, '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `correlativo`
--

CREATE TABLE IF NOT EXISTS `correlativo` (
  `id` int(11) NOT NULL,
  `serie` int(11) DEFAULT NULL,
  `correlativo` int(11) DEFAULT NULL,
  `empresa` int(11) DEFAULT NULL,
  `estado` varchar(1) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `correlativo`
--

INSERT INTO `correlativo` (`id`, `serie`, `correlativo`, `empresa`, `estado`) VALUES
(1, 1, 259, 1, '1'),
(2, 1, 2, 1, '0');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_venta`
--

CREATE TABLE IF NOT EXISTS `detalle_venta` (
  `id` int(11) NOT NULL,
  `producto` int(11) DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `importe` double DEFAULT NULL,
  `venta` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empresa`
--

CREATE TABLE IF NOT EXISTS `empresa` (
  `id` int(11) NOT NULL,
  `razon_social` varchar(100) DEFAULT NULL,
  `ruc` int(11) DEFAULT NULL,
  `direccion` varchar(200) DEFAULT NULL,
  `owner` varchar(200) DEFAULT NULL COMMENT 'Nombres del dueño de la empresa',
  `tipo` int(11) DEFAULT NULL COMMENT 'tipo : (1)principal (2) sucursal',
  `estado` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `empresa`
--

INSERT INTO `empresa` (`id`, `razon_social`, `ruc`, `direccion`, `owner`, `tipo`, `estado`) VALUES
(1, 'Libreria Veloz SAC', 2043434343, 'Azangaro Mz Y Lte 44', 'Juan Quispe', 2, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE IF NOT EXISTS `persona` (
  `id` int(11) NOT NULL,
  `nombres` varchar(60) DEFAULT NULL,
  `apellidos` varchar(60) DEFAULT NULL,
  `dni` varchar(60) DEFAULT NULL,
  `celular` int(11) DEFAULT NULL,
  `direccion` varchar(100) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`id`, `nombres`, `apellidos`, `dni`, `celular`, `direccion`) VALUES
(1, 'Jose', 'Limachi', '11111111', 989292987, 'Tacna'),
(2, 'Juan', 'Perez', '22222222', 989999990, 'Lima');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE IF NOT EXISTS `producto` (
  `id` int(11) NOT NULL,
  `nombre` varchar(60) DEFAULT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  `estado` int(1) DEFAULT NULL,
  `marca` varchar(60) DEFAULT NULL,
  `code` varchar(60) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`id`, `nombre`, `descripcion`, `estado`, `marca`, `code`) VALUES
(12, 'lapicero', 'oksss', 1, 'faber', '001'),
(13, 'cuaderno', 'ok', 1, 'loro', '002');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto_unidad_medida`
--

CREATE TABLE IF NOT EXISTS `producto_unidad_medida` (
  `producto` int(11) NOT NULL DEFAULT '0',
  `unidad_medida` int(11) NOT NULL DEFAULT '0',
  `precio` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `producto_unidad_medida`
--

INSERT INTO `producto_unidad_medida` (`producto`, `unidad_medida`, `precio`) VALUES
(13, 1, 1.5),
(13, 3, 15),
(13, 5, 120),
(12, 1, 0.5),
(12, 3, 5),
(12, 4, 20);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `role`
--

CREATE TABLE IF NOT EXISTS `role` (
  `id` int(11) NOT NULL,
  `name` varchar(60) DEFAULT NULL,
  `estado` varchar(1) DEFAULT NULL,
  `usuario` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

--
-- Volcado de datos para la tabla `role`
--

INSERT INTO `role` (`id`, `name`, `estado`, `usuario`) VALUES
(1, 'ROLE_ADMIN', '1', 1),
(2, 'ROLE_USER', '1', 1),
(3, 'ROLE_USER', '1', 2),
(4, 'ROLE_ADMIN', '1', 3),
(5, 'ROLE_USER', '1', 3),
(6, 'ROLE_USER', '1', 3),
(7, 'ROLE_ADMIN', '1', 3),
(8, 'ROLE_USER', '1', 3),
(9, 'ROLE_ADMIN', '1', 3),
(10, 'ROLE_ADMIN', '1', 3),
(11, 'ROLE_USER', '1', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `unidad_medida`
--

CREATE TABLE IF NOT EXISTS `unidad_medida` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL DEFAULT '0',
  `cantidad` int(11) NOT NULL DEFAULT '0',
  `descripcion` varchar(200) NOT NULL DEFAULT '0',
  `estado` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `unidad_medida`
--

INSERT INTO `unidad_medida` (`id`, `nombre`, `cantidad`, `descripcion`, `estado`) VALUES
(1, 'unidad', 1, 'unidad', 1),
(3, 'docena', 12, 'docena', 1),
(4, 'cajax50', 50, 'docenax50', 1),
(5, 'ciento', 100, 'ciento', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `id` int(11) NOT NULL,
  `username` varchar(60) NOT NULL,
  `password` varchar(60) NOT NULL,
  `estado` varchar(1) NOT NULL,
  `persona` int(11) DEFAULT NULL,
  `empresa` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `username`, `password`, `estado`, `persona`, `empresa`) VALUES
(1, 'admin', 'admin', '1', 1, 1),
(2, 'user', 'user', '1', 2, 1),
(3, 'juan', '123', '1', NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta`
--

CREATE TABLE IF NOT EXISTS `venta` (
  `id` int(11) NOT NULL,
  `cliente` int(11) DEFAULT NULL,
  `usuario` int(11) DEFAULT NULL,
  `base_imponible` double DEFAULT NULL,
  `igv` double DEFAULT NULL,
  `total` double DEFAULT NULL,
  `fecha_reg` date DEFAULT NULL,
  `nro_doc` varchar(60) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `almacen`
--
ALTER TABLE `almacen`
  ADD PRIMARY KEY (`id`), ADD KEY `ALMACEN_USER_FK` (`usuario`) USING BTREE, ADD KEY `ALMACEN_CLI` (`cliente`);

--
-- Indices de la tabla `almacen_consolidado`
--
ALTER TABLE `almacen_consolidado`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `almacen_detalle`
--
ALTER TABLE `almacen_detalle`
  ADD PRIMARY KEY (`id`), ADD KEY `AL_DET_ALMACEN` (`almacen`) USING BTREE;

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `correlativo`
--
ALTER TABLE `correlativo`
  ADD PRIMARY KEY (`id`), ADD KEY `corr_empresa_fk` (`empresa`);

--
-- Indices de la tabla `detalle_venta`
--
ALTER TABLE `detalle_venta`
  ADD PRIMARY KEY (`id`), ADD KEY `DET_PROD_FK` (`producto`) USING BTREE, ADD KEY `DET_VENT_FK` (`venta`) USING BTREE;

--
-- Indices de la tabla `empresa`
--
ALTER TABLE `empresa`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `producto_unidad_medida`
--
ALTER TABLE `producto_unidad_medida`
  ADD KEY `FK_producto_unidad_medida_producto` (`producto`), ADD KEY `FK_producto_unidad_medida_unidad_medida` (`unidad_medida`);

--
-- Indices de la tabla `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`), ADD KEY `ROLE_USER_FK` (`usuario`) USING BTREE;

--
-- Indices de la tabla `unidad_medida`
--
ALTER TABLE `unidad_medida`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`), ADD KEY `USUARIO_PER_FK` (`persona`) USING BTREE, ADD KEY `USUARIO_EMPRESA_FK` (`empresa`);

--
-- Indices de la tabla `venta`
--
ALTER TABLE `venta`
  ADD PRIMARY KEY (`id`), ADD KEY `VENTA_USER_FK` (`usuario`) USING BTREE, ADD KEY `VENTA_CLIENTE_FK` (`cliente`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `almacen`
--
ALTER TABLE `almacen`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT de la tabla `almacen_consolidado`
--
ALTER TABLE `almacen_consolidado`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=30;
--
-- AUTO_INCREMENT de la tabla `almacen_detalle`
--
ALTER TABLE `almacen_detalle`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT de la tabla `correlativo`
--
ALTER TABLE `correlativo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `detalle_venta`
--
ALTER TABLE `detalle_venta`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `empresa`
--
ALTER TABLE `empresa`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `persona`
--
ALTER TABLE `persona`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT de la tabla `role`
--
ALTER TABLE `role`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT de la tabla `unidad_medida`
--
ALTER TABLE `unidad_medida`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `venta`
--
ALTER TABLE `venta`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `almacen`
--
ALTER TABLE `almacen`
ADD CONSTRAINT `ALMACEN_CLI` FOREIGN KEY (`cliente`) REFERENCES `cliente` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `ALMACEN_USER_FK` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `almacen_detalle`
--
ALTER TABLE `almacen_detalle`
ADD CONSTRAINT `AL_DET_ALMACEN` FOREIGN KEY (`almacen`) REFERENCES `almacen` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `correlativo`
--
ALTER TABLE `correlativo`
ADD CONSTRAINT `corr_empresa_fk` FOREIGN KEY (`empresa`) REFERENCES `empresa` (`id`);

--
-- Filtros para la tabla `detalle_venta`
--
ALTER TABLE `detalle_venta`
ADD CONSTRAINT `DET_PROD_FK` FOREIGN KEY (`producto`) REFERENCES `producto` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT `DET_VENT_FK` FOREIGN KEY (`venta`) REFERENCES `venta` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `producto_unidad_medida`
--
ALTER TABLE `producto_unidad_medida`
ADD CONSTRAINT `FK_producto_unidad_medida_producto` FOREIGN KEY (`producto`) REFERENCES `producto` (`id`),
ADD CONSTRAINT `FK_producto_unidad_medida_unidad_medida` FOREIGN KEY (`unidad_medida`) REFERENCES `unidad_medida` (`id`);

--
-- Filtros para la tabla `role`
--
ALTER TABLE `role`
ADD CONSTRAINT `ROLE_USER_FK` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
ADD CONSTRAINT `USUARIO_EMPRESA_FK` FOREIGN KEY (`empresa`) REFERENCES `empresa` (`id`),
ADD CONSTRAINT `USUARIO_PER_FK` FOREIGN KEY (`persona`) REFERENCES `persona` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `venta`
--
ALTER TABLE `venta`
ADD CONSTRAINT `VENTA_CLIENTE_FK` FOREIGN KEY (`cliente`) REFERENCES `cliente` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT `VENTA_USER_FK` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
