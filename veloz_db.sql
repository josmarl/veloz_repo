-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.6.24 - MySQL Community Server (GPL)
-- SO del servidor:              Win32
-- HeidiSQL Versión:             9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para veloz
CREATE DATABASE IF NOT EXISTS `veloz` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `veloz`;

-- Volcando estructura para tabla veloz.almacen
CREATE TABLE IF NOT EXISTS `almacen` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nro_doc` varchar(60) DEFAULT NULL,
  `usuario` int(11) DEFAULT NULL,
  `cliente` int(11) DEFAULT NULL,
  `fecha_reg` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `ALMACEN_USER_FK` (`usuario`) USING BTREE,
  KEY `ALMACEN_CLI` (`cliente`),
  CONSTRAINT `ALMACEN_CLI` FOREIGN KEY (`cliente`) REFERENCES `cliente` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `ALMACEN_USER_FK` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

-- Volcando datos para la tabla veloz.almacen: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `almacen` DISABLE KEYS */;
INSERT INTO `almacen` (`id`, `nro_doc`, `usuario`, `cliente`, `fecha_reg`) VALUES
	(1, '001-212', 1, 3, '2019-01-08');
/*!40000 ALTER TABLE `almacen` ENABLE KEYS */;

-- Volcando estructura para tabla veloz.almacen_consolidado
CREATE TABLE IF NOT EXISTS `almacen_consolidado` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `producto` int(60) DEFAULT NULL,
  `disponible` int(60) DEFAULT NULL,
  `vendido` int(60) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla veloz.almacen_consolidado: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `almacen_consolidado` DISABLE KEYS */;
INSERT INTO `almacen_consolidado` (`id`, `producto`, `disponible`, `vendido`) VALUES
	(26, 7, 2, 0);
/*!40000 ALTER TABLE `almacen_consolidado` ENABLE KEYS */;

-- Volcando estructura para tabla veloz.almacen_detalle
CREATE TABLE IF NOT EXISTS `almacen_detalle` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `producto` int(11) DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `almacen` int(11) DEFAULT NULL,
  `importe` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `AL_DET_ALMACEN` (`almacen`) USING BTREE,
  CONSTRAINT `AL_DET_ALMACEN` FOREIGN KEY (`almacen`) REFERENCES `almacen` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

-- Volcando datos para la tabla veloz.almacen_detalle: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `almacen_detalle` DISABLE KEYS */;
INSERT INTO `almacen_detalle` (`id`, `producto`, `cantidad`, `almacen`, `importe`) VALUES
	(1, 7, 2, 1, 100);
/*!40000 ALTER TABLE `almacen_detalle` ENABLE KEYS */;

-- Volcando estructura para tabla veloz.cliente
CREATE TABLE IF NOT EXISTS `cliente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `razon_social` varchar(200) DEFAULT NULL,
  `ruc` bigint(11) DEFAULT NULL,
  `dni` int(11) DEFAULT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla veloz.cliente: ~6 rows (aproximadamente)
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` (`id`, `razon_social`, `ruc`, `dni`, `direccion`) VALUES
	(1, 'Loro EIRL', 1045454545, NULL, 'ok'),
	(2, 'Artesco EIRL', 12121212, NULL, 'ok'),
	(3, 'Jose Limachi', 11111111111, 45454545, 'ok'),
	(4, 'Juan perez', 0, 0, ''),
	(5, 'Carlos', 0, 23232323, ''),
	(6, 'Jorge', 0, 0, '');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;

-- Volcando estructura para tabla veloz.correlativo
CREATE TABLE IF NOT EXISTS `correlativo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `serie` int(11) DEFAULT NULL,
  `correlativo` int(11) DEFAULT NULL,
  `empresa` int(11) DEFAULT NULL,
  `estado` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `corr_empresa_fk` (`empresa`),
  CONSTRAINT `corr_empresa_fk` FOREIGN KEY (`empresa`) REFERENCES `empresa` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla veloz.correlativo: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `correlativo` DISABLE KEYS */;
INSERT INTO `correlativo` (`id`, `serie`, `correlativo`, `empresa`, `estado`) VALUES
	(1, 1, 258, 1, '1'),
	(2, 1, 2, 1, '0');
/*!40000 ALTER TABLE `correlativo` ENABLE KEYS */;

-- Volcando estructura para tabla veloz.detalle_venta
CREATE TABLE IF NOT EXISTS `detalle_venta` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `producto` int(11) DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `importe` double DEFAULT NULL,
  `venta` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `DET_PROD_FK` (`producto`) USING BTREE,
  KEY `DET_VENT_FK` (`venta`) USING BTREE,
  CONSTRAINT `DET_PROD_FK` FOREIGN KEY (`producto`) REFERENCES `producto` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `DET_VENT_FK` FOREIGN KEY (`venta`) REFERENCES `venta` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

-- Volcando datos para la tabla veloz.detalle_venta: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `detalle_venta` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalle_venta` ENABLE KEYS */;

-- Volcando estructura para tabla veloz.empresa
CREATE TABLE IF NOT EXISTS `empresa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `razon_social` varchar(100) DEFAULT NULL,
  `ruc` int(11) DEFAULT NULL,
  `direccion` varchar(200) DEFAULT NULL,
  `owner` varchar(200) DEFAULT NULL COMMENT 'Nombres del dueño de la empresa',
  `tipo` int(11) DEFAULT NULL COMMENT 'tipo : (1)principal (2) sucursal',
  `estado` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla veloz.empresa: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `empresa` DISABLE KEYS */;
INSERT INTO `empresa` (`id`, `razon_social`, `ruc`, `direccion`, `owner`, `tipo`, `estado`) VALUES
	(1, 'Libreria Veloz SAC', 2043434343, 'Azangaro Mz Y Lte 44', 'Juan Quispe', 2, 1);
/*!40000 ALTER TABLE `empresa` ENABLE KEYS */;

-- Volcando estructura para tabla veloz.persona
CREATE TABLE IF NOT EXISTS `persona` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombres` varchar(60) DEFAULT NULL,
  `apellidos` varchar(60) DEFAULT NULL,
  `dni` varchar(60) DEFAULT NULL,
  `celular` int(11) DEFAULT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

-- Volcando datos para la tabla veloz.persona: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` (`id`, `nombres`, `apellidos`, `dni`, `celular`, `direccion`) VALUES
	(1, 'Jose', 'Limachi', '11111111', 989292987, 'Tacna'),
	(2, 'Juan', 'Perez', '22222222', 989999990, 'Lima');
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;

-- Volcando estructura para tabla veloz.producto
CREATE TABLE IF NOT EXISTS `producto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(60) DEFAULT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  `precio_compra` double DEFAULT NULL,
  `precio_venta` double DEFAULT NULL,
  `estado` int(1) DEFAULT NULL,
  `marca` varchar(60) DEFAULT NULL,
  `code` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

-- Volcando datos para la tabla veloz.producto: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` (`id`, `nombre`, `descripcion`, `precio_compra`, `precio_venta`, `estado`, `marca`, `code`) VALUES
	(12, 'lapicero', 'oksss', NULL, NULL, 1, 'faber', '001');
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;

-- Volcando estructura para tabla veloz.producto_unidad_medida
CREATE TABLE IF NOT EXISTS `producto_unidad_medida` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `producto` int(11) NOT NULL DEFAULT '0',
  `unidad_medida` int(11) NOT NULL DEFAULT '0',
  `precio` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_producto_unidad_medida_producto` (`producto`),
  KEY `FK_producto_unidad_medida_unidad_medida` (`unidad_medida`),
  CONSTRAINT `FK_producto_unidad_medida_producto` FOREIGN KEY (`producto`) REFERENCES `producto` (`id`),
  CONSTRAINT `FK_producto_unidad_medida_unidad_medida` FOREIGN KEY (`unidad_medida`) REFERENCES `unidad_medida` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla veloz.producto_unidad_medida: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `producto_unidad_medida` DISABLE KEYS */;
INSERT INTO `producto_unidad_medida` (`id`, `producto`, `unidad_medida`, `precio`) VALUES
	(5, 12, 1, 0.5),
	(6, 12, 3, 5),
	(7, 12, 4, 20);
/*!40000 ALTER TABLE `producto_unidad_medida` ENABLE KEYS */;

-- Volcando estructura para tabla veloz.role
CREATE TABLE IF NOT EXISTS `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(60) DEFAULT NULL,
  `estado` varchar(1) DEFAULT NULL,
  `usuario` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `ROLE_USER_FK` (`usuario`) USING BTREE,
  CONSTRAINT `ROLE_USER_FK` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

-- Volcando datos para la tabla veloz.role: ~11 rows (aproximadamente)
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
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
/*!40000 ALTER TABLE `role` ENABLE KEYS */;

-- Volcando estructura para tabla veloz.unidad_medida
CREATE TABLE IF NOT EXISTS `unidad_medida` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL DEFAULT '0',
  `cantidad` int(11) NOT NULL DEFAULT '0',
  `descripcion` varchar(200) NOT NULL DEFAULT '0',
  `estado` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla veloz.unidad_medida: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `unidad_medida` DISABLE KEYS */;
INSERT INTO `unidad_medida` (`id`, `nombre`, `cantidad`, `descripcion`, `estado`) VALUES
	(1, 'unidad', 1, 'unidad', 1),
	(3, 'docena', 12, 'docena', 1),
	(4, 'cajax50', 50, 'docenax50', 1),
	(5, 'ciento', 100, 'ciento', 1);
/*!40000 ALTER TABLE `unidad_medida` ENABLE KEYS */;

-- Volcando estructura para tabla veloz.usuario
CREATE TABLE IF NOT EXISTS `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(60) NOT NULL,
  `password` varchar(60) NOT NULL,
  `estado` varchar(1) NOT NULL,
  `persona` int(11) DEFAULT NULL,
  `empresa` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `USUARIO_PER_FK` (`persona`) USING BTREE,
  KEY `USUARIO_EMPRESA_FK` (`empresa`),
  CONSTRAINT `USUARIO_EMPRESA_FK` FOREIGN KEY (`empresa`) REFERENCES `empresa` (`id`),
  CONSTRAINT `USUARIO_PER_FK` FOREIGN KEY (`persona`) REFERENCES `persona` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

-- Volcando datos para la tabla veloz.usuario: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`id`, `username`, `password`, `estado`, `persona`, `empresa`) VALUES
	(1, 'admin', 'admin', '1', 1, 1),
	(2, 'user', 'user', '1', 2, 1),
	(3, 'juan', '123', '1', NULL, NULL);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;

-- Volcando estructura para tabla veloz.venta
CREATE TABLE IF NOT EXISTS `venta` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cliente` int(11) DEFAULT NULL,
  `usuario` int(11) DEFAULT NULL,
  `base_imponible` double DEFAULT NULL,
  `igv` double DEFAULT NULL,
  `total` double DEFAULT NULL,
  `fecha_reg` date DEFAULT NULL,
  `nro_doc` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `VENTA_USER_FK` (`usuario`) USING BTREE,
  KEY `VENTA_CLIENTE_FK` (`cliente`),
  CONSTRAINT `VENTA_CLIENTE_FK` FOREIGN KEY (`cliente`) REFERENCES `cliente` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `VENTA_USER_FK` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

-- Volcando datos para la tabla veloz.venta: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `venta` DISABLE KEYS */;
/*!40000 ALTER TABLE `venta` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
