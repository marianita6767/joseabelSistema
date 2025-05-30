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



DROP TABLE IF EXISTS detalle_catalogo;
CREATE TABLE `detalle_catalogo` (
  `detalle_catalogo_id` int(11) NOT NULL AUTO_INCREMENT,
  `pedido_id_pedido` int(11) NOT NULL,
  `Catalogo_producto_idproducto` int(11) NOT NULL,
  PRIMARY KEY (`detalle_catalogo_id`),
  KEY `pedido_id_pedido` (`pedido_id_pedido`,`Catalogo_producto_idproducto`),
  KEY `Catalogo_producto_idproducto` (`Catalogo_producto_idproducto`),
  CONSTRAINT `detalle_catalogo_ibfk_1` FOREIGN KEY (`Catalogo_producto_idproducto`) REFERENCES `catalogo_producto` (`idproducto`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `detalle_catalogo_ibfk_2` FOREIGN KEY (`pedido_id_pedido`) REFERENCES `pedido` (`id_pedido`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;



DROP TABLE IF EXISTS detalle_pedido;
CREATE TABLE `detalle_pedido` (
  `iddetalle_pedido` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) NOT NULL,
  `cantidad` int(45) NOT NULL,
  `dimension` varchar(100) NOT NULL,
  `precio_unitario` double NOT NULL,
  `subtotal` double NOT NULL,
  `total` double NOT NULL,
  `pedido_id_pedido` int(11) NOT NULL,
  `factura_id_factura` int(11) DEFAULT NULL,
  PRIMARY KEY (`iddetalle_pedido`),
  KEY `fk_detalle_pedido_pedido1_idx` (`pedido_id_pedido`),
  KEY `factura_id_factura` (`factura_id_factura`),
  CONSTRAINT `detalle_pedido_ibfk_1` FOREIGN KEY (`pedido_id_pedido`) REFERENCES `pedido` (`id_pedido`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `detalle_pedido_ibfk_2` FOREIGN KEY (`factura_id_factura`) REFERENCES `factura` (`id_factura`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO detalle_pedido (iddetalle_pedido, descripcion, cantidad, dimension, precio_unitario, subtotal, total, pedido_id_pedido, factura_id_factura) VALUES (4, 'puertas de closed', 2, '2m*50cm', 100000.0, 200000.0, 200000.0, 8, NULL);
INSERT INTO detalle_pedido (iddetalle_pedido, descripcion, cantidad, dimension, precio_unitario, subtotal, total, pedido_id_pedido, factura_id_factura) VALUES (5, 'puertas de cocina', 3, '50cm*20cm', 50000.0, 150000.0, 150000.0, 8, NULL);
INSERT INTO detalle_pedido (iddetalle_pedido, descripcion, cantidad, dimension, precio_unitario, subtotal, total, pedido_id_pedido, factura_id_factura) VALUES (6, 'puertas de alcoba', 3, '2m*1m', 700000.0, 2100000.0, 2100000.0, 8, NULL);
INSERT INTO detalle_pedido (iddetalle_pedido, descripcion, cantidad, dimension, precio_unitario, subtotal, total, pedido_id_pedido, factura_id_factura) VALUES (7, 'entrepaños', 2, '50cm*20cm', 50000.0, 100000.0, 100000.0, 8, NULL);
INSERT INTO detalle_pedido (iddetalle_pedido, descripcion, cantidad, dimension, precio_unitario, subtotal, total, pedido_id_pedido, factura_id_factura) VALUES (13, 'puertas de closed', 2, '2m*1m', 100000.0, 200000.0, 200000.0, 9, NULL);
INSERT INTO detalle_pedido (iddetalle_pedido, descripcion, cantidad, dimension, precio_unitario, subtotal, total, pedido_id_pedido, factura_id_factura) VALUES (14, 'entrepaños', 3, '1*1m', 500000.0, 1500000.0, 1500000.0, 9, NULL);


DROP TABLE IF EXISTS detalle_produccion;
CREATE TABLE `detalle_produccion` (
  `idetalle_produccion` int(11) NOT NULL AUTO_INCREMENT,
  `cantidad` int(11) NOT NULL,
  `dimension` varchar(120) NOT NULL,
  `produccion_codigo` int(11) NOT NULL,
  PRIMARY KEY (`idetalle_produccion`),
  KEY `produccion_codigo` (`produccion_codigo`),
  CONSTRAINT `detalle_produccion_ibfk_1` FOREIGN KEY (`produccion_codigo`) REFERENCES `produccion` (`id_produccion`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;



DROP TABLE IF EXISTS etapa_produccion;
CREATE TABLE `etapa_produccion` (
  `idetapa_produccion` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_etapa` varchar(60) NOT NULL,
  `estado` enum('pendiente','proceso','completado') NOT NULL,
  `fecha_inicio` date NOT NULL,
  `fecha_fin` date NOT NULL,
  `cantidad` int(11) NOT NULL,
  `detalle_produccion_idetalle_produccion` int(11) DEFAULT NULL,
  `produccion_id_produccion` int(11) NOT NULL,
  PRIMARY KEY (`idetapa_produccion`),
  KEY `fk_etapa_produccion_produccion1_idx` (`detalle_produccion_idetalle_produccion`),
  KEY `detalle_produccion_idetalle_produccion` (`detalle_produccion_idetalle_produccion`),
  KEY `produccion_id_produccion` (`produccion_id_produccion`),
  CONSTRAINT `etapa_produccion_ibfk_1` FOREIGN KEY (`detalle_produccion_idetalle_produccion`) REFERENCES `detalle_produccion` (`idetalle_produccion`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `etapa_produccion_ibfk_2` FOREIGN KEY (`produccion_id_produccion`) REFERENCES `produccion` (`id_produccion`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;



DROP TABLE IF EXISTS factura;
CREATE TABLE `factura` (
  `id_factura` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` enum('cliente','proveedor') NOT NULL,
  `fecha_emision` date NOT NULL,
  `total` double NOT NULL,
  PRIMARY KEY (`id_factura`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;



DROP TABLE IF EXISTS inventario;
CREATE TABLE `inventario` (
  `id_inventario` int(11) NOT NULL AUTO_INCREMENT,
  `imagen` blob DEFAULT NULL,
  `nombre` varchar(45) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  `tipo` enum('material','herramienta') NOT NULL,
  `estado` enum('disponible','no disponible') NOT NULL,
  `stock` enum('bajo','medio','alto') NOT NULL,
  `cantidad` int(11) NOT NULL,
  `unidad_medida_idunidad_medida` int(11) NOT NULL,
  `marca_idmarca` int(11) NOT NULL,
  `categoria_codigo` int(11) NOT NULL,
  `Cotizacion_id_cotizacion` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_inventario`),
  KEY `fk_inventario_unidad_medida1_idx` (`unidad_medida_idunidad_medida`),
  KEY `fk_inventario_marca1_idx` (`marca_idmarca`),
  KEY `fk_inventario_categoria1_idx` (`categoria_codigo`),
  KEY `fk_inventario_Cotizacion1_idx` (`Cotizacion_id_cotizacion`),
  CONSTRAINT `inventario_ibfk_1` FOREIGN KEY (`Cotizacion_id_cotizacion`) REFERENCES `cotizacion` (`id_cotizacion`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `inventario_ibfk_2` FOREIGN KEY (`marca_idmarca`) REFERENCES `marca` (`idmarca`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `inventario_ibfk_3` FOREIGN KEY (`unidad_medida_idunidad_medida`) REFERENCES `unidad_medida` (`idunidad_medida`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `inventario_ibfk_4` FOREIGN KEY (`categoria_codigo`) REFERENCES `categoria` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO inventario (id_inventario, imagen, nombre, descripcion, tipo, estado, stock, cantidad, unidad_medida_idunidad_medida, marca_idmarca, categoria_codigo, Cotizacion_id_cotizacion) VALUES (1, null, 'rjbj3', 'r34', 'material', 'disponible', 'bajo', 4, 1, 1, 1, NULL);
INSERT INTO inventario (id_inventario, imagen, nombre, descripcion, tipo, estado, stock, cantidad, unidad_medida_idunidad_medida, marca_idmarca, categoria_codigo, Cotizacion_id_cotizacion) VALUES (5, null, 'dewf', 'few', 'material', 'disponible', 'bajo', 1, 1, 1, 1, NULL);
INSERT INTO inventario (id_inventario, imagen, nombre, descripcion, tipo, estado, stock, cantidad, unidad_medida_idunidad_medida, marca_idmarca, categoria_codigo, Cotizacion_id_cotizacion) VALUES (6, null, 'martillo', 'nvhgv', 'herramienta', 'disponible', 'bajo', 2, 4, 3, 4, NULL);


DROP TABLE IF EXISTS marca;
CREATE TABLE `marca` (
  `idmarca` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `tipo` enum('material','herramienta') NOT NULL,
  PRIMARY KEY (`idmarca`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO marca (idmarca, nombre, tipo) VALUES (1, 'Bosh', 'material');
INSERT INTO marca (idmarca, nombre, tipo) VALUES (2, 'Bauker', 'material');
INSERT INTO marca (idmarca, nombre, tipo) VALUES (3, 'Kreg', 'herramienta');
INSERT INTO marca (idmarca, nombre, tipo) VALUES (4, 'Karson', 'herramienta');
INSERT INTO marca (idmarca, nombre, tipo) VALUES (5, 'Lenox', 'herramienta');


DROP TABLE IF EXISTS pago_abono;
CREATE TABLE `pago_abono` (
  `id_abono` int(11) NOT NULL AUTO_INCREMENT,
  `montoTotal` double NOT NULL,
  `metodo_pago` enum('efectivo','trasnferencia','tarjeta') NOT NULL,
  `fecha_pago` date NOT NULL,
  `pagado` double NOT NULL,
  `debido` double NOT NULL,
  `caja_id_codigo` int(11) DEFAULT NULL,
  `cliente_codigo` int(11) NOT NULL,
  `ticket_idticket` int(11) DEFAULT NULL,
  `detalle_pedido_iddetalle_pedido` int(11) NOT NULL,
  PRIMARY KEY (`id_abono`),
  KEY `fk_pago_abono_caja1_idx` (`caja_id_codigo`),
  KEY `fk_pago_abono_cliente1_idx` (`cliente_codigo`),
  KEY `ticket_idticket` (`ticket_idticket`,`detalle_pedido_iddetalle_pedido`),
  KEY `detalle_pedido_iddetalle_pedido` (`detalle_pedido_iddetalle_pedido`),
  CONSTRAINT `pago_abono_ibfk_2` FOREIGN KEY (`cliente_codigo`) REFERENCES `cliente` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `pago_abono_ibfk_5` FOREIGN KEY (`ticket_idticket`) REFERENCES `ticket` (`idticket`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `pago_abono_ibfk_6` FOREIGN KEY (`caja_id_codigo`) REFERENCES `caja` (`id_codigo`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `pago_abono_ibfk_7` FOREIGN KEY (`detalle_pedido_iddetalle_pedido`) REFERENCES `detalle_pedido` (`iddetalle_pedido`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO pago_abono (id_abono, montoTotal, metodo_pago, fecha_pago, pagado, debido, caja_id_codigo, cliente_codigo, ticket_idticket, detalle_pedido_iddetalle_pedido) VALUES (2, 1700000.0, 'efectivo', '2025-05-23', 1000.0, 1600000.0, NULL, 2, NULL, 4);


DROP TABLE IF EXISTS pedido;
CREATE TABLE `pedido` (
  `id_pedido` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `estado` enum('pendiente','proceso','finalizado') NOT NULL,
  `fecha_inicio` date NOT NULL,
  `fecha_fin` date NOT NULL,
  `cliente_codigo` int(11) NOT NULL,
  `usuario_id_usuario` int(11) DEFAULT NULL,
  `Cotizacion_id_cotizacion` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_pedido`),
  KEY `fk_pedido_cliente1_idx` (`cliente_codigo`),
  KEY `fk_pedido_usuario1_idx` (`usuario_id_usuario`),
  KEY `cotizacion_id_cotizacion` (`Cotizacion_id_cotizacion`),
  KEY `Cotizacion_id_cotizacion_2` (`Cotizacion_id_cotizacion`),
  CONSTRAINT `pedido_ibfk_1` FOREIGN KEY (`cliente_codigo`) REFERENCES `cliente` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO pedido (id_pedido, nombre, estado, fecha_inicio, fecha_fin, cliente_codigo, usuario_id_usuario, Cotizacion_id_cotizacion) VALUES (8, 'dtm de mario', 'proceso', '2025-05-01', '2025-05-02', 2, NULL, 0);
INSERT INTO pedido (id_pedido, nombre, estado, fecha_inicio, fecha_fin, cliente_codigo, usuario_id_usuario, Cotizacion_id_cotizacion) VALUES (9, 'fghg', 'pendiente', '2025-05-03', '2025-05-17', 3, NULL, 0);


DROP TABLE IF EXISTS produccion;
CREATE TABLE `produccion` (
  `id_produccion` int(11) NOT NULL AUTO_INCREMENT,
  `fecha_inicio` date NOT NULL,
  `fecha_fin` date NOT NULL,
  `estado` enum('pendiente','proceso','finalizado') NOT NULL,
  `detalle_pedido_iddetalle_pedido` int(11) NOT NULL,
  PRIMARY KEY (`id_produccion`),
  KEY `fk_produccion_detalle_pedido1_idx` (`detalle_pedido_iddetalle_pedido`),
  CONSTRAINT `produccion_ibfk_1` FOREIGN KEY (`detalle_pedido_iddetalle_pedido`) REFERENCES `detalle_pedido` (`iddetalle_pedido`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO produccion (id_produccion, fecha_inicio, fecha_fin, estado, detalle_pedido_iddetalle_pedido) VALUES (1, '2025-05-01', '2025-05-02', 'pendiente', 4);
INSERT INTO produccion (id_produccion, fecha_inicio, fecha_fin, estado, detalle_pedido_iddetalle_pedido) VALUES (2, '2025-05-01', '2025-05-02', 'proceso', 4);


DROP TABLE IF EXISTS proveedor;
CREATE TABLE `proveedor` (
    `id_proveedor` INT(11) NOT NULL AUTO_INCREMENT,
    `nombre` VARCHAR(45) NOT NULL,
    `correo_electronico` VARCHAR(45) NOT NULL,
    `telefono` VARCHAR(12) NOT NULL,
    `direccion` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id_proveedor`)
)  ENGINE=INNODB AUTO_INCREMENT=2 DEFAULT CHARSET=UTF8MB4 COLLATE = UTF8MB4_GENERAL_CI;



DROP TABLE IF EXISTS recuperacion;
CREATE TABLE `recuperacion` (
  `codigo` int(11) NOT NULL,
  `correo_electronico` varchar(45) NOT NULL,

  `usuario_id_usuario` int(11) NOT NULL,
  PRIMARY KEY (`codigo`),
  KEY `fk_Recuperacion_usuario1_idx` (`usuario_id_usuario`),
  CONSTRAINT `recuperacion_ibfk_1` FOREIGN KEY (`usuario_id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO recuperacion (codigo, correo_electronico, fecha_generacion, usuario_id_usuario) VALUES (120971, 'karenmariana174@gmail.com', '2025-05-27 10:48:57.0', 1);
INSERT INTO recuperacion (codigo, correo_electronico, fecha_generacion, usuario_id_usuario) VALUES (736802, 'karenmariana174@gmail.com', '2025-05-27 10:48:57.0', 1);


DROP TABLE IF EXISTS suministra;
CREATE TABLE `suministra` (
  `idSuministra` int(11) NOT NULL AUTO_INCREMENT,
  `inventario_id_inventario` int(11) NOT NULL,
  `proveedor_id_proveedor` int(11) NOT NULL,
  PRIMARY KEY (`idSuministra`),
  KEY `inventario_id_inventario` (`inventario_id_inventario`),
  KEY `proveedor_id_proveedor` (`proveedor_id_proveedor`),
  CONSTRAINT `suministra_ibfk_1` FOREIGN KEY (`inventario_id_inventario`) REFERENCES `inventario` (`id_inventario`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `suministra_ibfk_2` FOREIGN KEY (`proveedor_id_proveedor`) REFERENCES `proveedor` (`id_proveedor`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;



DROP TABLE IF EXISTS ticket;
CREATE TABLE `ticket` (
  `idticket` int(11) NOT NULL AUTO_INCREMENT,
  `factura_id_factura` int(11) NOT NULL,
  PRIMARY KEY (`idticket`),
  KEY `factura_id_factura` (`factura_id_factura`),
  CONSTRAINT `ticket_ibfk_1` FOREIGN KEY (`factura_id_factura`) REFERENCES `factura` (`id_factura`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;



DROP TABLE IF EXISTS unidad_medida;
CREATE TABLE `unidad_medida` (
  `idunidad_medida` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `tipo` enum('material','herramienta') NOT NULL,
  PRIMARY KEY (`idunidad_medida`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO unidad_medida (idunidad_medida, nombre, tipo) VALUES (1, 'metro', 'material');
INSERT INTO unidad_medida (idunidad_medida, nombre, tipo) VALUES (2, 'unidad', 'material');
INSERT INTO unidad_medida (idunidad_medida, nombre, tipo) VALUES (3, 'centimetros', 'material');
INSERT INTO unidad_medida (idunidad_medida, nombre, tipo) VALUES (4, 'unidad', 'herramienta');


DROP TABLE IF EXISTS usuario;
CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `imagen` blob DEFAULT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `usuario` varchar(50) NOT NULL,
  `contrasena` varchar(250) NOT NULL,
  `correo_electronico` varchar(45) NOT NULL,
  `telefono` varchar(100) NOT NULL,
  `rol` enum('Administrador','Contador','Trabajador') NOT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO usuario (id_usuario, imagen, nombre, apellido, usuario, contrasena, correo_electronico, telefono, rol) VALUES (1,null, 'Yuri', 'Gomez', 'yurigomez123', 'yuriii1.A', 'karenmariana174@gmail.com', '312677849', 'Trabajador');


DROP TABLE IF EXISTS utilizado;
CREATE TABLE `utilizado` (
  `utilizado_id` int(11) NOT NULL AUTO_INCREMENT,
  `etapa_produccion_idetapa_produccion` int(11) NOT NULL,
  `inventario_id_inventario` int(11) NOT NULL,
  PRIMARY KEY (`utilizado_id`),
  KEY `etapa_produccion_idetapa_produccion` (`etapa_produccion_idetapa_produccion`),
  KEY `inventario_id_inventario` (`inventario_id_inventario`),
  CONSTRAINT `utilizado_ibfk_1` FOREIGN KEY (`inventario_id_inventario`) REFERENCES `inventario` (`id_inventario`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `utilizado_ibfk_2` FOREIGN KEY (`etapa_produccion_idetapa_produccion`) REFERENCES `etapa_produccion` (`idetapa_produccion`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;



SET FOREIGN_KEY_CHECKS = 1;
