/*
Navicat MySQL Data Transfer
Source Server         : mysql
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : veloz
Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001
Date: 2017-07-12 20:54:26
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
  `fecha_reg` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `ALMACEN_USER_FK` (`usuario`) USING BTREE,
  KEY `ALMACEN_CLI` (`cliente`),
  CONSTRAINT `ALMACEN_CLI` FOREIGN KEY (`cliente`) REFERENCES `cliente` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `ALMACEN_USER_FK` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of almacen
-- ----------------------------
INSERT INTO `almacen` VALUES ('57', '001', '1', '1', '2017-05-22');
INSERT INTO `almacen` VALUES ('58', '002', '1', '3', '2017-05-22');
INSERT INTO `almacen` VALUES ('59', '003', '1', '2', '2017-05-22');
INSERT INTO `almacen` VALUES ('60', '001-32131', '1', '2', '2017-06-13');
INSERT INTO `almacen` VALUES ('61', '001-3213', '1', '3', '2017-06-15');
INSERT INTO `almacen` VALUES ('62', '001-3213213', '1', '2', '2017-07-05');
INSERT INTO `almacen` VALUES ('63', '0-3213', '1', '4', '2017-07-05');
INSERT INTO `almacen` VALUES ('64', '003-3213', '1', '2', '2017-07-05');
INSERT INTO `almacen` VALUES ('65', '000-132321', '1', '2', '2017-07-07');

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
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of almacen_consolidado
-- ----------------------------
INSERT INTO `almacen_consolidado` VALUES ('23', '5', '349', '281');
INSERT INTO `almacen_consolidado` VALUES ('24', '4', '562', '198');
INSERT INTO `almacen_consolidado` VALUES ('25', '6', '5', '95');

-- ----------------------------
-- Table structure for almacen_detalle
-- ----------------------------
DROP TABLE IF EXISTS `almacen_detalle`;
CREATE TABLE `almacen_detalle` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `producto` int(11) DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `almacen` int(11) DEFAULT NULL,
  `importe` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `AL_DET_ALMACEN` (`almacen`) USING BTREE,
  CONSTRAINT `AL_DET_ALMACEN` FOREIGN KEY (`almacen`) REFERENCES `almacen` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=116 DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of almacen_detalle
-- ----------------------------
INSERT INTO `almacen_detalle` VALUES ('102', '5', '100', '57', '4');
INSERT INTO `almacen_detalle` VALUES ('103', '4', '100', '57', '4');
INSERT INTO `almacen_detalle` VALUES ('104', '5', '100', '58', '4');
INSERT INTO `almacen_detalle` VALUES ('105', '6', '100', '58', '42');
INSERT INTO `almacen_detalle` VALUES ('106', '5', '100', '59', '3');
INSERT INTO `almacen_detalle` VALUES ('107', '5', '10', '60', '300');
INSERT INTO `almacen_detalle` VALUES ('108', '4', '20', '60', '400');
INSERT INTO `almacen_detalle` VALUES ('109', '5', '40', '61', '400');
INSERT INTO `almacen_detalle` VALUES ('110', '5', '60', '62', '600');
INSERT INTO `almacen_detalle` VALUES ('111', '4', '40', '62', '500');
INSERT INTO `almacen_detalle` VALUES ('112', '5', '20', '63', '400');
INSERT INTO `almacen_detalle` VALUES ('113', '4', '100', '64', '60');
INSERT INTO `almacen_detalle` VALUES ('114', '5', '200', '64', '30');
INSERT INTO `almacen_detalle` VALUES ('115', '4', '500', '65', '1000');

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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of cliente
-- ----------------------------
INSERT INTO `cliente` VALUES ('1', 'Loro EIRL', '1045454545', null, 'ok');
INSERT INTO `cliente` VALUES ('2', 'Artesco EIRL', '12121212', null, 'ok');
INSERT INTO `cliente` VALUES ('3', 'Jose Limachi', '11111111111', '45454545', 'ok');
INSERT INTO `cliente` VALUES ('4', 'Juan perez', '0', '0', '');
INSERT INTO `cliente` VALUES ('5', 'Carlos', '0', '23232323', '');
INSERT INTO `cliente` VALUES ('6', 'Jorge', '0', '0', '');

-- ----------------------------
-- Table structure for correlativo
-- ----------------------------
DROP TABLE IF EXISTS `correlativo`;
CREATE TABLE `correlativo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `serie` int(11) DEFAULT NULL,
  `correlativo` int(11) DEFAULT NULL,
  `empresa` int(11) DEFAULT NULL,
  `estado` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `corr_empresa_fk` (`empresa`),
  CONSTRAINT `corr_empresa_fk` FOREIGN KEY (`empresa`) REFERENCES `empresa` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of correlativo
-- ----------------------------
INSERT INTO `correlativo` VALUES ('1', '1', '257', '1', '1');
INSERT INTO `correlativo` VALUES ('2', '1', '2', '1', '0');

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
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of detalle_venta
-- ----------------------------
INSERT INTO `detalle_venta` VALUES ('42', '5', '12', '24', '24');
INSERT INTO `detalle_venta` VALUES ('43', '4', '12', '12', '24');
INSERT INTO `detalle_venta` VALUES ('44', '5', '10', '20', '25');
INSERT INTO `detalle_venta` VALUES ('45', '5', '30', '60', '26');
INSERT INTO `detalle_venta` VALUES ('46', '4', '3', '3', '26');
INSERT INTO `detalle_venta` VALUES ('47', '6', '5', '5', '27');
INSERT INTO `detalle_venta` VALUES ('48', '5', '5', '10', '27');
INSERT INTO `detalle_venta` VALUES ('49', '5', '60', '120', '28');
INSERT INTO `detalle_venta` VALUES ('50', '5', '10', '20', '29');
INSERT INTO `detalle_venta` VALUES ('51', '4', '10', '10', '29');
INSERT INTO `detalle_venta` VALUES ('52', '5', '30', '60', '30');
INSERT INTO `detalle_venta` VALUES ('53', '4', '10', '10', '30');
INSERT INTO `detalle_venta` VALUES ('54', '5', '10', '20', '31');
INSERT INTO `detalle_venta` VALUES ('55', '5', '10', '20', '32');
INSERT INTO `detalle_venta` VALUES ('56', '5', '14', '28', '33');
INSERT INTO `detalle_venta` VALUES ('57', '4', '4', '4', '33');
INSERT INTO `detalle_venta` VALUES ('58', '4', '20', '20', '34');
INSERT INTO `detalle_venta` VALUES ('59', '5', '50', '100', '34');
INSERT INTO `detalle_venta` VALUES ('60', '4', '30', '30', '35');
INSERT INTO `detalle_venta` VALUES ('61', '6', '5', '5', '35');
INSERT INTO `detalle_venta` VALUES ('62', '6', '30', '30', '36');
INSERT INTO `detalle_venta` VALUES ('63', '4', '28', '28', '36');
INSERT INTO `detalle_venta` VALUES ('64', '4', '5', '5', '37');
INSERT INTO `detalle_venta` VALUES ('65', '5', '5', '10', '37');
INSERT INTO `detalle_venta` VALUES ('66', '5', '10', '20', '38');
INSERT INTO `detalle_venta` VALUES ('67', '4', '30', '30', '39');
INSERT INTO `detalle_venta` VALUES ('68', '5', '5', '10', '39');
INSERT INTO `detalle_venta` VALUES ('69', '5', '20', '40', '40');
INSERT INTO `detalle_venta` VALUES ('70', '4', '10', '10', '40');
INSERT INTO `detalle_venta` VALUES ('71', '6', '20', '20', '41');
INSERT INTO `detalle_venta` VALUES ('72', '6', '35', '35', '42');
INSERT INTO `detalle_venta` VALUES ('73', '4', '16', '16', '42');
INSERT INTO `detalle_venta` VALUES ('74', '4', '10', '10', '43');
INSERT INTO `detalle_venta` VALUES ('75', '4', '10', '10', '44');

-- ----------------------------
-- Table structure for empresa
-- ----------------------------
DROP TABLE IF EXISTS `empresa`;
CREATE TABLE `empresa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `razon_social` varchar(100) DEFAULT NULL,
  `ruc` int(11) DEFAULT NULL,
  `direccion` varchar(200) DEFAULT NULL,
  `owner` varchar(200) DEFAULT NULL COMMENT 'Nombres del dueño de la empresa',
  `tipo` int(11) DEFAULT NULL COMMENT 'tipo : (1)principal (2) sucursal',
  `estado` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of empresa
-- ----------------------------
INSERT INTO `empresa` VALUES ('1', 'Libreria Veloz SAC', '2043434343', 'Azangaro Mz Y Lte 44', 'Juan Quispe', '2', '1');

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
INSERT INTO `producto` VALUES ('4', 'cuaderno', 'ok', '1', '0.5', '0.3', '0.4', '1', '1', '1', 'loro', '001');
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
  `fecha_reg` date DEFAULT NULL,
  `nro_doc` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `VENTA_USER_FK` (`usuario`) USING BTREE,
  KEY `VENTA_CLIENTE_FK` (`cliente`),
  CONSTRAINT `VENTA_CLIENTE_FK` FOREIGN KEY (`cliente`) REFERENCES `cliente` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `VENTA_USER_FK` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of venta
-- ----------------------------
INSERT INTO `venta` VALUES ('24', '3', '1', '0', '0', '36', '2017-05-22', '1-237');
INSERT INTO `venta` VALUES ('25', '3', '1', '16.4', '3.6', '20', '2017-06-13', '1-238');
INSERT INTO `venta` VALUES ('26', '2', '1', '0', '0', '63', '2017-06-13', '1-239');
INSERT INTO `venta` VALUES ('27', '4', '1', '0', '0', '15', '2017-06-13', '1-240');
INSERT INTO `venta` VALUES ('28', '3', '1', '0', '0', '120', '2017-06-14', '1-241');
INSERT INTO `venta` VALUES ('29', '3', '1', '0', '0', '30', '2017-06-15', '1-242');
INSERT INTO `venta` VALUES ('30', '4', '1', '0', '0', '70', '2017-07-05', '1-243');
INSERT INTO `venta` VALUES ('31', '3', '1', '0', '0', '20', '2017-07-05', '1-244');
INSERT INTO `venta` VALUES ('32', '3', '1', '0', '0', '20', '2017-07-05', '1-245');
INSERT INTO `venta` VALUES ('33', '3', '1', '0', '0', '32', '2017-07-05', '1-246');
INSERT INTO `venta` VALUES ('34', '4', '1', '0', '0', '120', '2017-07-05', '1-247');
INSERT INTO `venta` VALUES ('35', '3', '1', '0', '0', '35', '2017-07-05', '1-248');
INSERT INTO `venta` VALUES ('36', '4', '1', '0', '0', '58', '2017-07-05', '1-249');
INSERT INTO `venta` VALUES ('37', '3', '1', '12.3', '2.7', '15', '2017-07-05', '1-250');
INSERT INTO `venta` VALUES ('38', '4', '1', '16.4', '3.6', '20', '2017-07-05', '1-251');
INSERT INTO `venta` VALUES ('39', '3', '1', '0', '0', '40', '2017-07-05', '1-252');
INSERT INTO `venta` VALUES ('40', '4', '1', '0', '0', '50', '2017-07-07', '1-253');
INSERT INTO `venta` VALUES ('41', '3', '1', '0', '0', '20', '2017-07-07', '1-254');
INSERT INTO `venta` VALUES ('42', '5', '1', '0', '0', '51', '2017-07-07', '1-255');
INSERT INTO `venta` VALUES ('43', '6', '1', '8.2', '1.8', '10', '2017-07-07', '1-256');
INSERT INTO `venta` VALUES ('44', '3', '1', '0', '0', '10', '2017-07-07', '1-257');