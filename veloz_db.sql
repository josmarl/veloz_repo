/*
Navicat MySQL Data Transfer

Source Server         : my_pruebas
Source Server Version : 50624
Source Host           : 127.0.0.1:3306
Source Database       : veloz

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2017-05-17 15:40:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for almacen
-- ----------------------------
DROP TABLE IF EXISTS `almacen`;
CREATE TABLE `almacen` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nro_doc` varchar(60) DEFAULT NULL,
  `usuario` int(11) DEFAULT NULL,
  `cliente` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `ALMACEN_USER_FK` (`usuario`) USING BTREE,
  KEY `ALMACEN_CLI` (`cliente`),
  CONSTRAINT `ALMACEN_CLI` FOREIGN KEY (`cliente`) REFERENCES `cliente` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `ALMACEN_USER_FK` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of almacen
-- ----------------------------
INSERT INTO `almacen` VALUES ('10', '001-001', '1', '3');
INSERT INTO `almacen` VALUES ('28', '002-321-321', '1', '2');

-- ----------------------------
-- Table structure for almacen_consolidado
-- ----------------------------
DROP TABLE IF EXISTS `almacen_consolidado`;
CREATE TABLE `almacen_consolidado` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `producto` int(60) DEFAULT NULL,
  `disponible` int(60) DEFAULT NULL,
  `vendido` int(60) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of almacen_consolidado
-- ----------------------------
INSERT INTO `almacen_consolidado` VALUES ('7', '4', '106', '0');
INSERT INTO `almacen_consolidado` VALUES ('8', '5', '107', '0');

-- ----------------------------
-- Table structure for almacen_detalle
-- ----------------------------
DROP TABLE IF EXISTS `almacen_detalle`;
CREATE TABLE `almacen_detalle` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `producto` int(11) DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `almacen` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `AL_DET_ALMACEN` (`almacen`) USING BTREE,
  CONSTRAINT `AL_DET_ALMACEN` FOREIGN KEY (`almacen`) REFERENCES `almacen` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of almacen_detalle
-- ----------------------------
INSERT INTO `almacen_detalle` VALUES ('1', '4', '100', '10');
INSERT INTO `almacen_detalle` VALUES ('2', '5', '100', '10');
INSERT INTO `almacen_detalle` VALUES ('52', '5', '7', '28');
INSERT INTO `almacen_detalle` VALUES ('53', '4', '6', '28');
INSERT INTO `almacen_detalle` VALUES ('54', '6', '2', '28');

-- ----------------------------
-- Table structure for cliente
-- ----------------------------
DROP TABLE IF EXISTS `cliente`;
CREATE TABLE `cliente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `razon_social` varchar(200) DEFAULT NULL,
  `ruc` bigint(11) DEFAULT NULL,
  `dni` int(11) DEFAULT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of cliente
-- ----------------------------
INSERT INTO `cliente` VALUES ('1', 'Loro EIRL', '1045454545', null, 'ok');
INSERT INTO `cliente` VALUES ('2', 'Artesco EIRL', '12121212', null, 'ok');
INSERT INTO `cliente` VALUES ('3', 'Jose Limachi', '11111111111', '45454545', 'ok');
INSERT INTO `cliente` VALUES ('4', 'Juan perez', '0', '0', '');
INSERT INTO `cliente` VALUES ('5', 'juan', '0', '0', '');
INSERT INTO `cliente` VALUES ('6', 'pedro', '0', '0', '');
INSERT INTO `cliente` VALUES ('7', 'jorge2', '0', '0', '');
INSERT INTO `cliente` VALUES ('8', 'Maria', '0', '0', '');

-- ----------------------------
-- Table structure for detalle_venta
-- ----------------------------
DROP TABLE IF EXISTS `detalle_venta`;
CREATE TABLE `detalle_venta` (
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

-- ----------------------------
-- Records of detalle_venta
-- ----------------------------

-- ----------------------------
-- Table structure for empresa
-- ----------------------------
DROP TABLE IF EXISTS `empresa`;
CREATE TABLE `empresa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `razon_social` varchar(100) DEFAULT NULL,
  `ruc` int(11) DEFAULT NULL,
  `serie` int(11) DEFAULT NULL,
  `correlativo` varchar(100) DEFAULT NULL,
  `direccion` varchar(200) DEFAULT NULL,
  `owner` varchar(200) DEFAULT NULL COMMENT 'Nombres del dueño de la empresa',
  `tipo` int(11) DEFAULT NULL COMMENT 'tipo : (1)principal (2) sucursal',
  `estado` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of empresa
-- ----------------------------
INSERT INTO `empresa` VALUES ('1', 'Libreria Veloz SAC', '2043434343', '1', '0002121', 'Azangaro Mz Y Lte 44', 'Juan Quispe', '2', '1');

-- ----------------------------
-- Table structure for persona
-- ----------------------------
DROP TABLE IF EXISTS `persona`;
CREATE TABLE `persona` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombres` varchar(60) DEFAULT NULL,
  `apellidos` varchar(60) DEFAULT NULL,
  `dni` varchar(60) DEFAULT NULL,
  `celular` int(11) DEFAULT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of persona
-- ----------------------------
INSERT INTO `persona` VALUES ('1', 'Jose', 'Limachi', '11111111', '989292987', 'Tacna');
INSERT INTO `persona` VALUES ('2', 'Juan', 'Perez', '22222222', '989999990', 'Lima');

-- ----------------------------
-- Table structure for producto
-- ----------------------------
DROP TABLE IF EXISTS `producto`;
CREATE TABLE `producto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(60) DEFAULT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  `precio_unit` double DEFAULT NULL,
  `precio_docena` double DEFAULT NULL,
  `precio_ciento` double DEFAULT NULL,
  `precio_cincuenta` double DEFAULT NULL,
  `precio_compra` double DEFAULT NULL,
  `precio_venta` double DEFAULT NULL,
  `estado` int(1),
  `marca` varchar(60) DEFAULT NULL,
  `code` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of producto
-- ----------------------------
INSERT INTO `producto` VALUES ('4', 'cuaderno', 'ok', '1', '1', '1', '1', '1', '1', '1', 'loro', '001');
INSERT INTO `producto` VALUES ('5', 'Lapicero', 'ok', '2', '2', '2', '2', '2', '2', '1', 'artesco', '002');
INSERT INTO `producto` VALUES ('6', 'Libro', 'ok', '1', '1', '1', '1', '1', '1', '1', 'Loro', '003');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(60) DEFAULT NULL,
  `estado` varchar(1) DEFAULT NULL,
  `usuario` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `ROLE_USER_FK` (`usuario`) USING BTREE,
  CONSTRAINT `ROLE_USER_FK` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'ROLE_ADMIN', '1', '1');
INSERT INTO `role` VALUES ('2', 'ROLE_USER', '1', '1');
INSERT INTO `role` VALUES ('3', 'ROLE_USER', '1', '2');
INSERT INTO `role` VALUES ('4', 'ROLE_ADMIN', '1', '3');
INSERT INTO `role` VALUES ('5', 'ROLE_USER', '1', '3');
INSERT INTO `role` VALUES ('6', 'ROLE_USER', '1', '3');
INSERT INTO `role` VALUES ('7', 'ROLE_ADMIN', '1', '3');
INSERT INTO `role` VALUES ('8', 'ROLE_USER', '1', '3');
INSERT INTO `role` VALUES ('9', 'ROLE_ADMIN', '1', '3');
INSERT INTO `role` VALUES ('10', 'ROLE_ADMIN', '1', '3');
INSERT INTO `role` VALUES ('11', 'ROLE_USER', '1', '3');

-- ----------------------------
-- Table structure for usuario
-- ----------------------------
DROP TABLE IF EXISTS `usuario`;
CREATE TABLE `usuario` (
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

-- ----------------------------
-- Records of usuario
-- ----------------------------
INSERT INTO `usuario` VALUES ('1', 'admin', 'admin', '1', '1', '1');
INSERT INTO `usuario` VALUES ('2', 'user', 'user', '1', '2', '1');
INSERT INTO `usuario` VALUES ('3', 'juan', '123', '1', null, null);

-- ----------------------------
-- Table structure for venta
-- ----------------------------
DROP TABLE IF EXISTS `venta`;
CREATE TABLE `venta` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cliente` int(11) DEFAULT NULL,
  `usuario` int(11) DEFAULT NULL,
  `base_imponible` double DEFAULT NULL,
  `igv` double DEFAULT NULL,
  `total` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `VENTA_USER_FK` (`usuario`) USING BTREE,
  KEY `VENTA_CLIENTE_FK` (`cliente`),
  CONSTRAINT `VENTA_CLIENTE_FK` FOREIGN KEY (`cliente`) REFERENCES `cliente` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `VENTA_USER_FK` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of venta
-- ----------------------------
