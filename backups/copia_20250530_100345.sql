USE carpinteriasistema;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS asignada;
CREATE TABLE `asignada` (
  `asignada_id` int(11) NOT NULL AUTO_INCREMENT,
  `etapa_produccion_idetapa_produccion` int(11) NOT NULL,
  `usuario_id_usuario` int(11) NOT NULL,
  PRIMARY KEY (`asignada_id`),
  KEY `etapa_produccion_idetapa_produccion` (`etapa_produccion_idetapa_produccion`),
  KEY `usuario_id_usuario` (`usuario_id_usuario`),
  CONSTRAINT `asignada_ibfk_1` FOREIGN KEY (`usuario_id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `asignada_ibfk_2` FOREIGN KEY (`etapa_produccion_idetapa_produccion`) REFERENCES `etapa_produccion` (`idetapa_produccion`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;



DROP TABLE IF EXISTS caja;
CREATE TABLE `caja` (
  `id_codigo` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `movimiento` enum('egreso','ingreso') NOT NULL,
  `monto` double NOT NULL,
  `descripcion` varchar(150) NOT NULL,
  `suministra_idSuministra` int(11) NOT NULL,
  `categoria` varchar(150) NOT NULL,
  PRIMARY KEY (`id_codigo`),
  KEY `fk_caja_suministra1_idx` (`suministra_idSuministra`),
  CONSTRAINT `caja_ibfk_1` FOREIGN KEY (`suministra_idSuministra`) REFERENCES `suministra` (`idSuministra`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;



DROP TABLE IF EXISTS catalogo_producto;
CREATE TABLE `catalogo_producto` (
  `idproducto` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `alto` varchar(100) NOT NULL,
  `ancho` varchar(100) NOT NULL,
  `profundidad` varchar(150) NOT NULL,
  `material` varchar(150) NOT NULL,
  `color` varchar(150) NOT NULL,
  `imagen` blob NOT NULL,
  `Categoria_idCategoria` int(11) NOT NULL,
  PRIMARY KEY (`idproducto`),
  KEY `fk_Catalogo_producto_Categoria1_idx` (`Categoria_idCategoria`),
  CONSTRAINT `catalogo_producto_ibfk_2` FOREIGN KEY (`Categoria_idCategoria`) REFERENCES `categoriacatalogo` (`idCategoria`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;



DROP TABLE IF EXISTS categoria;
CREATE TABLE `categoria` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `tipo` enum('material','herramienta') NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO categoria (codigo, nombre, tipo) VALUES (1, 'Madera', 'material');
INSERT INTO categoria (codigo, nombre, tipo) VALUES (2, 'Pintura', 'material');
INSERT INTO categoria (codigo, nombre, tipo) VALUES (3, 'electrica', 'herramienta');
INSERT INTO categoria (codigo, nombre, tipo) VALUES (4, 'Manual', 'herramienta');


DROP TABLE IF EXISTS categoriacatalogo;
CREATE TABLE `categoriacatalogo` (
  `idCategoria` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `imagen` blob NOT NULL,
  PRIMARY KEY (`idCategoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;



DROP TABLE IF EXISTS cliente;
CREATE TABLE `cliente` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `identificacion` enum('CC','CE','TI','RC','NIT') NOT NULL,
  `numero` int(15) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `telefono` varchar(45) NOT NULL,
  `direccion` varchar(45) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO cliente (codigo, identificacion, numero, nombre, apellido, telefono, direccion) VALUES (2, 'CC', 564, 'Maria', 'Rios', '535', 'fre42');
INSERT INTO cliente (codigo, identificacion, numero, nombre, apellido, telefono, direccion) VALUES (3, 'CE', 42424142, 'Yuri', 'Gomez', '4687629491', 'fbj27c');
INSERT INTO cliente (codigo, identificacion, numero, nombre, apellido, telefono, direccion) VALUES (6, 'CC', 535234, 'Juliana', 'Perez', '351575', 'cra 17 3-4');
INSERT INTO cliente (codigo, identificacion, numero, nombre, apellido, telefono, direccion) VALUES (7, 'CC', 124235, 'Angelita', 'Alarcon', '321436', 'calle 2 4-5');


DROP TABLE IF EXISTS cotizacion;
CREATE TABLE `cotizacion` (
  `id_cotizacion` int(11) NOT NULL AUTO_INCREMENT,
  `detalle` varchar(200) NOT NULL,
  `unidad` varchar(45) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `valor_unitario` double NOT NULL,
  `sub_total` double NOT NULL,
  `total` double NOT NULL,
  `usuario_id_usuario` int(11) NOT NULL,
  `cliente_codigo` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_cotizacion`),
  KEY `fk_Cotizacion_usuario1_idx` (`usuario_id_usuario`),
  KEY `fk_Cotizacion_cliente1_idx` (`cliente_codigo`),
  CONSTRAINT `cotizacion_ibfk_2` FOREIGN KEY (`cliente_codigo`) REFERENCES `cliente` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `cotizacion_ibfk_4` FOREIGN KEY (`usuario_id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `cotizacion_ibfk_5` FOREIGN KEY (`id_cotizacion`) REFERENCES `pedido` (`id_pedido`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;



SET FOREIGN_KEY_CHECKS = 1;
