#crear base de datos/;
create database bd_sistema_ventas_general;

drop database bd_sistema_ventas_general;


use bd_sistema_ventas_general;



CREATE TABLE Configuracion (
    id INT PRIMARY KEY AUTO_INCREMENT,
    ruc VARCHAR(30),
    nombre VARCHAR(100),
    telefono VARCHAR(30),
    direccion VARCHAR(100),
    razon VARCHAR(100)
);

use bd_sistema_ventas_general;	
select * from Configuracion;




#crear tabla usuarios/;

create table tb_usuario(

idUsuario INT PRIMARY KEY AUTO_INCREMENT,
nombre VARCHAR(30) NOT NULL,
apellido VARCHAR(30) NOT NULL,
identificacion VARCHAR(30) NOT NULL unique,
direccion VARCHAR(100),
telefono VARCHAR(30) ,
correo VARCHAR(100) ,
usuario VARCHAR(30)  NOT NULL,
password VARCHAR(30) NOT NULL,
rol VARCHAR(15) NOT NULL,
estado INT(1) NOT NULL

);

select * from tb_usuario;
use bd_sistema_ventas_general;	
show tables;


#crear tabla cliente/;

create table tb_cliente(

idCliente INT PRIMARY KEY AUTO_INCREMENT,
nombre VARCHAR(30) NOT NULL,
apellido VARCHAR(30) NOT NULL,
identificacion VARCHAR(30) UNIQUE NOT NULL,
direccion VARCHAR(100),
telefono VARCHAR(30),
correo VARCHAR(100),
estado INT(1) NOT NULL

);

select * from tb_cliente;
use bd_sistema_ventas_general;	
show tables;



#crear tabla proveedor/;



CREATE TABLE tb_proveedor (

    idProveedor INT PRIMARY KEY AUTO_INCREMENT,
    razonSocial VARCHAR(100) NOT NULL,
    identificacion VARCHAR(100) UNIQUE NOT NULL,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    direccion VARCHAR(200),		
    telefono VARCHAR(20),
    correo VARCHAR(100),
    estado INT(1) NOT NULL
    
);


drop table tb_proveedor;

select * from tb_proveedor;

use bd_sistema_ventas_general;	




#crear tabla categoria/////////////////;

create table tb_categoria(

idCategoria int PRIMARY KEY AUTO_INCREMENT,
nombreCategoria VARCHAR(200) UNIQUE NOT NULL,
estado INT(1) NOT NULL

);

drop table tb_categoria;

ALTER TABLE tb_categoria auto_increment = 0;

select * from tb_categoria;

use bd_sistema_ventas_general;	

show tables;






show tables;

#crear tabla producto////////////////////;

select * from tb_producto;

CREATE TABLE tb_producto (

    idProducto INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) UNIQUE NOT NULL,
    descripcion VARCHAR(200) NOT NULL,
    idCategoria INT NOT NULL,
    idProveedor INT NOT NULL,
    ubicacion VARCHAR(100),
    cantidad_actual INT NOT NULL CHECK (cantidad_actual>=0),
    stock_min INT ,
    stock_max INT ,
    precioCosto DOUBLE(10,2) NOT NULL,
    precioVenta DOUBLE(10,2) NOT NULL,
    porcentajeIgv INT(2) NOT NULL,
    precio_total DOUBLE(10,2) NOT NULL,
    idImagen VARCHAR (300) ,
    estado INT(1) NOT NULL,
    FOREIGN KEY (idCategoria) REFERENCES tb_categoria(idCategoria),  
    FOREIGN KEY (idProveedor) REFERENCES tb_proveedor(idProveedor) 
    
);


create table Imagenes (
idImagen int not null auto_increment primary key,
imagen blob,
nombre varchar(100)
)engine=Innodb;

use bd_sistema_ventas_general;	

select * from Imagenes;

show tables;


CREATE TABLE tb_entradas (
	
    idEntradas INT AUTO_INCREMENT PRIMARY KEY,
    motivo VARCHAR(30) NOT NULL,
    documento VARCHAR(100) NOT NULL,
    idProducto INT NOT NULL,
    idCategoria INT NOT NULL,
    idProveedor INT NOT NULL,
    fecha DATE NOT NULL,
    cantidad INT NOT NULL,
    precioCosto DOUBLE NOT NULL CHECK (precioCosto >= 0),
    total DOUBLE NOT NULL,
    obs VARCHAR (300),
    estado INT(1),
    FOREIGN KEY (idProducto) REFERENCES tb_producto(idProducto),
    FOREIGN KEY (idCategoria) REFERENCES tb_categoria(idCategoria),
    FOREIGN KEY (idProveedor) REFERENCES tb_proveedor(idProveedor)
    
);

use bd_sistema_ventas_general;	

select * from tb_entradas_pendientes;
select * from tb_entradas;
select * from tb_producto;
select * from tb_inventario;


CREATE TABLE tb_entradas_pendientes (
    idPendienteEntrada INT AUTO_INCREMENT PRIMARY KEY,
    motivo VARCHAR(30) NOT NULL,  -- Motivo de la entrada
    documento VARCHAR(100) NOT NULL,  -- Documento de respaldo
    idProducto INT NOT NULL,  -- Producto
    idCategoria INT NOT NULL,  -- Categoría
    idProveedor INT NOT NULL,  -- Proveedor
    fecha DATE NOT NULL,  -- Fecha de la entrada
    cantidad INT NOT NULL,  -- Cantidad
    precioCosto DOUBLE NOT NULL CHECK (precioCosto >= 0),  -- Precio costo del producto
    total DOUBLE NOT NULL,  -- Total (cantidad * precioCosto)
    obs VARCHAR(300),  -- Observaciones
    estado INT(1),  -- Estado: 0 - Pendiente, 1 - Confirmado
    confirmado TINYINT(1) DEFAULT 0,  -- Nuevo campo: 0 - No recibido, 1 - Recibido
    FOREIGN KEY (idProducto) REFERENCES tb_producto(idProducto),
    FOREIGN KEY (idCategoria) REFERENCES tb_categoria(idCategoria),
    FOREIGN KEY (idProveedor) REFERENCES tb_proveedor(idProveedor)
);



CREATE TABLE tb_salidas (
    idSalidas INT AUTO_INCREMENT PRIMARY KEY,
    motivo VARCHAR(30) NOT NULL,  -- Motivo de la salida (Donación, Devolución, Uso Interno, etc.)
    documento VARCHAR(100) NOT NULL,  -- Documento de respaldo
    destinatario VARCHAR(100) NOT NULL,  -- Destinatario libre (nombre o descripción general)
    idProducto INT NOT NULL,  -- Producto
    idCategoria INT NOT NULL,  -- Categoría
    idProveedor INT NOT NULL,  -- Proveedor
    fecha DATE NOT NULL,  -- Fecha de la salida
    cantidad INT NOT NULL,  -- Cantidad
    precio_unitario DOUBLE NOT NULL CHECK (precio_unitario >= 0),  -- Precio unitario del producto
    total DOUBLE NOT NULL,  -- Total (cantidad * precio_unitario)
    obs VARCHAR(300),  -- Observaciones
    estado INT(1) DEFAULT 1,  -- Estado: 0 - Pendiente, 1 - Confirmado
    confirmado TINYINT(1) DEFAULT 1,  -- Confirmación: 0 - No confirmado, 1 - Confirmado
    FOREIGN KEY (idProducto) REFERENCES tb_producto(idProducto),
    FOREIGN KEY (idCategoria) REFERENCES tb_categoria(idCategoria),
    FOREIGN KEY (idProveedor) REFERENCES tb_proveedor(idProveedor)
);

select * from tb_salidas_pendientes;
-- Tabla para salidas pendientes (no relacionadas con ventas)
CREATE TABLE tb_salidas_pendientes (
    idPendienteSalida INT AUTO_INCREMENT PRIMARY KEY,
    motivo VARCHAR(30) NOT NULL,  -- Motivo de la salida pendiente
    documento VARCHAR(100) NOT NULL,  -- Documento de respaldo
    destinatario VARCHAR(100) NOT NULL,  -- Destinatario libre (nombre o descripción general)
    idProducto INT NOT NULL,  -- Producto
    idCategoria INT NOT NULL,  -- Categoría
    idProveedor INT NOT NULL,  -- Proveedor
    fecha DATE NOT NULL,  -- Fecha de la salida
    cantidad INT NOT NULL,  -- Cantidad
    precio_unitario DOUBLE NOT NULL CHECK (precio_unitario >= 0),  -- Precio unitario del producto
    total DOUBLE NOT NULL,  -- Total (cantidad * precio_unitario)
    obs VARCHAR(300),  -- Observaciones
    estado INT(1) DEFAULT 0,  -- Estado: 0 - Pendiente, 1 - Confirmado
    confirmado TINYINT(1) DEFAULT 0,  -- Confirmación: 0 - No confirmado, 1 - Confirmado
    FOREIGN KEY (idProducto) REFERENCES tb_producto(idProducto),
    FOREIGN KEY (idCategoria) REFERENCES tb_categoria(idCategoria),
    FOREIGN KEY (idProveedor) REFERENCES tb_proveedor(idProveedor)
);



select * from tb_inventario;

CREATE TABLE tb_inventario (

    idInventario INT AUTO_INCREMENT PRIMARY KEY,
    idProducto INT NOT NULL,
    idCategoria INT NOT NULL,
    idProveedor INT NOT NULL,  -- Proveedor
    entradas INT NOT NULL DEFAULT 0,
    salidas INT NOT NULL DEFAULT 0,
    stock_disponible INT NOT NULL DEFAULT 0,
    obs VARCHAR(300),
    estado INT(1) NOT NULL,
    FOREIGN KEY (idProducto) REFERENCES tb_producto(idProducto),
    FOREIGN KEY (idCategoria) REFERENCES tb_categoria(idCategoria)

);


#crear tabla cabecera de venta/;

create table tb_cabecera_venta(
idCabeceraVenta INT(11) AUTO_INCREMENT PRIMARY KEY,
idCliente INT(11) NOT NULL,
valorPagar DOUBLE(10,2) NOT NULL,
fechaVenta DATE NOT NULL,
estado INT(1) NOT NULL

);

select * from tb_cabecera_venta;


show tables;

#crear tabla detalle de venta/;

create table tb_detalle_venta(
idDetalleVenta INT AUTO_INCREMENT PRIMARY KEY,
idCabeceraVenta INT NOT NULL,
idProducto INT NOT NULL,
cantidad INT NOT NULL,
precioUnitario DOUBLE(10,2) NOT NULL,
subtotal DOUBLE(10,2) NOT NULL,
descuento DOUBLE(10,2) NOT NULL,
igv DOUBLE(10,2) NOT NULL,
totalPagatb_productor DOUBLE(10,2) NOT NULL,
estado INT(1) NOT NULL
);

## 14 TABLAS EN TOTAL
show tables;



use bd_sistema_ventas_general;	

DELIMITER //


CREATE TRIGGER trg_after_ingreso_insert_inventario
AFTER INSERT ON tb_entradas
FOR EACH ROW
BEGIN
    -- Verificar si el producto existe en el inventario
    IF NOT EXISTS (SELECT 1 FROM tb_inventario WHERE idProducto = NEW.idProducto) THEN
        -- Insertar nueva entrada en inventario con stock inicial de esta transacción
        INSERT INTO tb_inventario (idProducto, idCategoria, idProveedor, entradas, stock_disponible, estado)
        VALUES (NEW.idProducto, NEW.idCategoria, NEW.idProveedor, NEW.cantidad, NEW.cantidad, 1);
    ELSE
        -- Actualizar el inventario existente
        UPDATE tb_inventario
        SET  
            entradas = entradas + NEW.cantidad,
            stock_disponible = stock_disponible + NEW.cantidad
        WHERE idProducto = NEW.idProducto;
    END IF;

    -- Actualizar la cantidad actual en tb_producto solo si es necesario
    IF EXISTS (SELECT 1 FROM tb_producto WHERE idProducto = NEW.idProducto) THEN
        UPDATE tb_producto
        SET cantidad_actual = cantidad_actual + NEW.cantidad  -- Asegúrate de que no esté duplicando la cantidad.
        WHERE idProducto = NEW.idProducto;
    END IF;
END;
//

DELIMITER //

CREATE TRIGGER after_insert_salidas
AFTER INSERT ON tb_salidas
FOR EACH ROW
BEGIN
    DECLARE v_stock_disponible INT;

    -- Verificar que la cantidad sea válida
    IF NEW.cantidad <= 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'La cantidad debe ser mayor que cero';
    END IF;

    -- Actualizar o insertar en tb_inventario
    IF NOT EXISTS (SELECT 1 FROM tb_inventario WHERE idProducto = NEW.idProducto) THEN
        -- Si el producto no está en inventario, insertarlo
        INSERT INTO tb_inventario (idProducto, idCategoria, idProveedor, entradas, salidas, stock_disponible, estado)
        VALUES (NEW.idProducto, NEW.idCategoria, NEW.idProveedor, 0, NEW.cantidad, 0 - NEW.cantidad, 1);
    ELSE
        -- Actualizar inventario existente
        UPDATE tb_inventario
        SET 
            salidas = salidas + NEW.cantidad,
            stock_disponible = stock_disponible - NEW.cantidad
        WHERE idProducto = NEW.idProducto;
    END IF;

    -- Actualizar tb_producto para reducir el stock
    IF EXISTS (SELECT 1 FROM tb_producto WHERE idProducto = NEW.idProducto) THEN
        UPDATE tb_producto
        SET cantidad_actual = cantidad_actual - NEW.cantidad  -- Resta la cantidad registrada
        WHERE idProducto = NEW.idProducto;
    END IF;
    
END;
//

CREATE TRIGGER after_insert_detalle_venta
AFTER INSERT ON tb_detalle_venta
FOR EACH ROW
BEGIN
    DECLARE v_idCliente INT;
    DECLARE v_precioVenta DOUBLE;
    DECLARE v_total DOUBLE;
    DECLARE v_idCategoria INT;
    DECLARE v_idProveedor INT;
    DECLARE v_nombre VARCHAR(100);
    DECLARE v_apellido VARCHAR(100);

    -- Obtener idCliente de la cabecera de venta
    SELECT idCliente INTO v_idCliente
    FROM tb_cabecera_venta
    WHERE idCabeceraVenta = NEW.idCabeceraVenta;

    IF v_idCliente IS NULL THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Cliente no encontrado';
    END IF;

    -- Obtener precio de venta, idCategoria y idProveedor del producto
    SELECT precioVenta, idCategoria, idProveedor INTO v_precioVenta, v_idCategoria, v_idProveedor
    FROM tb_producto
    WHERE idProducto = NEW.idProducto;

    IF v_precioVenta IS NULL THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Precio de venta no encontrado';
    END IF;

    -- Obtener nombre y apellido del cliente
    SELECT nombre, apellido INTO v_nombre, v_apellido
    FROM tb_cliente
    WHERE idCliente = v_idCliente;

    -- Calcular total
    SET v_total = NEW.cantidad * v_precioVenta;

    -- Insertar en tb_salidas
    INSERT INTO tb_salidas (motivo, documento, destinatario, idProducto, idCategoria, idProveedor, fecha, cantidad, precio_unitario, total, obs, estado, confirmado)
    VALUES ('Venta', 
            (SELECT CONCAT('001-', LPAD(MAX(idCabeceraVenta), 5, '0')) FROM tb_cabecera_venta),  -- Generación de documento
            CONCAT(v_nombre, ' ', v_apellido),  -- Nombre completo del cliente
            NEW.idProducto, 
            v_idCategoria, 
            v_idProveedor, 
            CURDATE(),  -- Fecha automática
            NEW.cantidad, 
            v_precioVenta, 
            v_total, 
            'Salida por venta', 
            1,  -- Estado
            1);  -- Confirmado

    -- No actualizamos el inventario aquí para evitar doble descuento
    -- El manejo del inventario se hace en el trigger after_insert_salidas

END;
//



-- Trigger para actualizar el inventario después de eliminar una entrada (tb_entradas)
CREATE TRIGGER trg_after_ingreso_delete_inventario
AFTER DELETE ON tb_entradas
FOR EACH ROW
BEGIN
  -- Verificar si el producto existe en el inventario
  IF EXISTS (SELECT 1 FROM tb_inventario WHERE idProducto = OLD.idProducto) THEN
    -- Actualizar el inventario restando la cantidad de la entrada eliminada
    UPDATE tb_inventario
    SET  
      entradas = entradas - OLD.cantidad,
      stock_disponible = stock_disponible - OLD.cantidad
    WHERE idProducto = OLD.idProducto;
  END IF;
END;
//

-- Trigger para actualizar el inventario después de eliminar una salida (tb_salidas)
CREATE TRIGGER trg_after_salida_delete_inventario
AFTER DELETE ON tb_salidas
FOR EACH ROW
BEGIN
  -- Verificar si el producto existe en el inventario
  IF EXISTS (SELECT 1 FROM tb_inventario WHERE idProducto = OLD.idProducto) THEN
    -- Actualizar el inventario añadiendo la cantidad de la salida eliminada
    UPDATE tb_inventario
    SET  
      salidas = salidas - OLD.cantidad,
      stock_disponible = stock_disponible + OLD.cantidad
    WHERE idProducto = OLD.idProducto;
  END IF;
END;
//

DELIMITER ;

use bd_sistema_ventas_general;



INSERT INTO Configuracion (ruc, nombre, telefono, direccion, razon)
VALUES ('123456789', 'Farmacia Inteligente', '987654321', 'Av. Innovación 456, Local 3', 'Farmacia Inteligente S.A.C.');


INSERT INTO tb_usuario VALUES (1, 'jeferson', 'Ramos', '74548291','Olivos',' 942542132','jeferson.ramos.rivera@gmail.com', 'admin', '123', 'Admin', 1);
INSERT INTO tb_usuario VALUES ('2', 'Jose', 'Altamirano', '12345678', 'Calle Ejemplo 123', '987654321', 'juan.perez@example.com', 'Empleado', '123', 'Usuario', 1);

INSERT INTO tb_cliente (nombre, apellido, identificacion, direccion, telefono, correo, estado) VALUES
('Ana', 'Martínez', 'CLI123456', 'Calle del Cliente 123', '111222333', 'ana.martinez@example.com', 1),
('Luis', 'González', 'CLI789012', 'Avenida del Cliente 456', '444555666', 'luis.gonzalez@example.com', 1),
('Carla', 'López', 'CLI345678', 'Boulevard del Cliente 789', '777888999', 'carla.lopez@example.com', 1);

INSERT INTO tb_categoria (nombreCategoria, estado) VALUES
('Medicamentos de Prescripción', 1),  -- Incluye jarabes y pastillas que requieren receta
('Antiinflamatorios', 1),               -- Incluye pastillas antiinflamatorias
('Analgésicos', 1),                     -- Incluye pastillas analgésicas
('Productos Naturales', 1),             -- Incluye jarabes y pastillas naturales
('Cuidado Infantil', 1),                 -- Productos relacionados con la salud infantil, incluidos jarabes
('Cuidado Oral', 1),                    -- Incluye productos para la salud dental
('Dermatología', 1),                    -- Incluye tratamientos para la piel
('Aparatos Médicos', 1),                -- Equipos y dispositivos médicos
('Terapias Alternativas', 1),           -- Suplementos y tratamientos alternativos
('Primeros Auxilios', 1);               -- Productos de emergencia

-- Insertar datos en tb_proveedor

INSERT INTO tb_proveedor (razonSocial, nombre, identificacion, telefono, direccion, correo, estado) VALUES
('Farmacéutica Saludable S.A.', 'Proveedora 1', 'RUC12345678', '555123456', 'Calle de la Salud 123', 'contacto@saludable.com', 1),
('Distribuciones Medicinas Ltda.', 'Proveedora 2', 'RUC87654321', '555987654', 'Avenida Medicinal 456', 'info@medicinasltda.com', 1),
('Suministros Farmacéuticos S.A.C.', 'Proveedora 3', 'RUC45678912', '555654321', 'Boulevard de los Medicamentos 789', 'ventas@suministros.com', 1),
('Productos Naturales Co. Ltd.', 'Proveedora 4', 'RUC32165498', '555321654', 'Calle Verde 101', 'info@productosnaturales.com', 1),
('Medicamentos Rápidos S.A.', 'Proveedora 5', 'RUC65412379', '555456789', 'Avenida Rápida 202', 'atencion@rapidos.com', 1);



use bd_sistema_ventas_general;

select * from tb_usuario;

select * from tb_cliente;

SELECT * FROM tb_producto;

SELECT * FROM imagenes;

SELECT * FROM tb_proveedor;

SELECT * FROM tb_categoria;

SELECT * FROM tb_entradas	;

delete from tb_entradas where idEntradas =6;

SELECT * FROM tb_salidas;

SELECT * FROM tb_inventario;

select * from tb_detalle_venta;

select * from tb_cabecera_venta;


use bd_sistema_ventas_general;


SELECT p.idProducto, p.nombre, p.cantidad_actual, p.descripcion, c.nombreCategoria, p.ubicacion, p.precioCosto, p.precioVenta, p.porcentajeIgv,p.precio_total, p.estado 
                 FROM tb_producto p JOIN tb_categoria c 
                 ON p.idCategoria = c.idCategoria;




show tables;

use bd_sistema_ventas_general;





select * from tb_usuario;














