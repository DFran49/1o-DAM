DROP USER IF EXISTS conferencias3;

CREATE USER conferencias3 IDENTIFIED BY "conferencias3";

DROP DATABASE IF EXISTS conferencias3;

CREATE DATABASE conferencias3 COLLATE utf8mb4_spanish_ci;

GRANT ALL PRIVILEGES ON conferencias3.* TO conferencias3;

USE conferencias3;

CREATE TABLE provincia (
	id_provincia 	TINYINT UNSIGNED PRIMARY KEY,
	nombre 		VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE recurso (
	id_recurso 	SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	nombre 		VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE sala (
	id_sala 	TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	nombre 		VARCHAR(50) NOT NULL UNIQUE,
	capacidad 	SMALLINT UNSIGNED NOT NULL
);

CREATE TABLE dispone (
	id_sala 	TINYINT UNSIGNED,
	id_rec 		SMALLINT UNSIGNED,
	cantidad 	SMALLINT UNSIGNED,
	estado 		ENUM('BUENO', 'REGULAR', 'MALO') DEFAULT 'BUENO',
	PRIMARY KEY (id_sala, id_rec),
	FOREIGN KEY (id_sala) REFERENCES sala(id_sala),
	FOREIGN KEY (id_rec) REFERENCES recurso(id_recurso)
);

CREATE TABLE conferencia (
	id_conferencia	CHAR(7) PRIMARY KEY,
	tema 			VARCHAR(60),
	precio 			DECIMAL(5,2),
	fecha 			DATE NOT NULL,
	turno 			ENUM('T', 'M'),
	id_sala 		TINYINT UNSIGNED,
	FOREIGN KEY (id_sala) REFERENCES sala(id_sala)
);

CREATE TABLE ponente (
	id_ponente 		CHAR(6) PRIMARY KEY,
	nombre 			VARCHAR(50) NOT NULL,
	apellido1 		VARCHAR(50) NOT NULL,
	apellido2 		VARCHAR(50),
	especialidad 	VARCHAR(50)
);

CREATE TABLE datos_contacto (
	id_pon 			CHAR(6),
	tipo 			ENUM('TELÉFONO', 'MÓVIL', 'E-MAIL') ,
	contacto 		VARCHAR(150),
	PRIMARY KEY (id_pon, tipo, contacto),
	FOREIGN KEY (id_pon) REFERENCES ponente(id_ponente)
);

CREATE TABLE participa (
	id_pon 			CHAR(6),
	id_conf 		CHAR(7),
	num_orden 		TINYINT UNSIGNED,
	gratificacion 	DECIMAL(6,2),
	PRIMARY KEY (id_pon, id_conf),
	FOREIGN KEY (id_pon) REFERENCES ponente(id_ponente),
	FOREIGN KEY (id_conf) REFERENCES conferencia(id_conferencia)
);

CREATE TABLE asistente (
	id_asist 		CHAR(6) PRIMARY KEY,
	nombre 			VARCHAR(50) NOT NULL,
	apellido1 		VARCHAR(50) NOT NULL,
	apellido2 		VARCHAR(50),
	sexo 			VARCHAR(1) CHECK (sexo IN ('H', 'M')),
	fecha_nac 		DATE NOT NULL,
	empresa 		VARCHAR(50),
	id_provincia 	TINYINT UNSIGNED,
	FOREIGN KEY (id_provincia) REFERENCES provincia(id_provincia)
);

CREATE TABLE asiste (
	id_asist 	CHAR(6),
	id_conf 	CHAR(7),
	PRIMARY KEY (id_asist, id_conf),
	FOREIGN KEY (id_asist) REFERENCES asistente(id_asist),
	FOREIGN KEY (id_conf) REFERENCES conferencia(id_conferencia)
);

INSERT INTO provincia VALUES (4, 'Almería'),
								(11, 'Cádiz'),
								(14, 'Córdoba'),
								(18, 'Granada'),
								(21, 'Huelva'),
								(23, 'Jaén'),
								(29, 'Málaga'),
								(41, 'Sevilla');

INSERT INTO recurso VALUES (1, 'Proyector'),
							(2, 'Ordenador'),
							(3, 'Altavoces'),
							(4, 'Pizarra'),
							(5, 'Mesa'),
							(6, 'Silla');

INSERT INTO sala (nombre, capacidad) VALUES ('Zeus', 250),
											('Afrodita', 80),
											('Apolo', 200),
											('Hermes', 150);

INSERT INTO dispone VALUES (1, 1, 1, 'BUENO'),
							(1, 2, 2, 'BUENO'),
							(1, 3, 2, 'REGULAR'),
							(1, 5, 2, 'BUENO'),
							(1, 6, 240, 'BUENO'),
							(2, 1, 1, 'BUENO'),
							(2, 2, 1, 'BUENO'),
							(2, 3, 1, 'BUENO'),
							(2, 4, 1, 'BUENO'),
							(2, 5, 1, 'BUENO'),
							(2, 6, 100, 'BUENO'),
							(3, 1, 1, 'BUENO'),
							(3, 2, 1, 'REGULAR'),
							(3, 3, 1, 'MALO'),
							(3, 4, 1, 'BUENO'),
							(3, 6, 210, 'BUENO'),
							(4, 1, 1, 'MALO'),
							(4, 2, 1, 'MALO'),
							(4, 3, 1, 'MALO'),
							(4, 5, 3, 'MALO'),
							(4, 6, 160, 'MALO');

INSERT INTO conferencia VALUES ('BDO2324', 'Bases de Datos Orientadas a Objetos', 10.50, '2023-10-02', 'T', 2),
								('POO2324', 'Programación Orientada a Objetos', 20.00, '2023-10-03', 'M', 1),
								('PWB2324', 'Programación Web', 18.50, '2023-10-03', 'T', 3),
								('ADS2324', 'Accediendo a datos de forma segura', 12.50, '2023-10-04', 'M', 2),
								('SEG2324', 'Seguridad Informática en la Empresa', 15.00, '2023-10-04', 'T', 3),
								('ENS2324', 'Desarrollo en Entorno Servidor', 14.50, '2023-10-05', 'T', 3),
								('BDN2324', 'Bases de Datos noSQL', 16.00, '2023-10-06', 'M', 3);

INSERT INTO ponente VALUES ('ESP001', 'Juan', 'Llobregat', 'García', 'Bases de Datos'),
							('USA001', 'Stephen', 'Gary', NULL, 'Programación'),
							('FRA001', 'Piere', 'Gaul', 'More', 'Seguridad Informática'),
							('ESP002', 'Silvia', 'Durán', 'Céspedes', 'Bases de Datos'),
							('ESP003', 'Julián', 'Amor', 'Pérez', 'Seguridad Informática'),
							('USA002', 'Robert', 'Craig', NULL, 'Bases de Datos'),
							('ESP004', 'Luisa', 'Soriano', 'López', 'Seguridad Informática'),
							('USA003', 'Kevin', 'Shull', NULL, 'Programación'),
							('ESP005', 'Juan', 'Moreno', 'Moreno', 'Bases de Datos'),
							('ESP006', 'María', 'Ruiz', NULL, 'Programación');

INSERT INTO datos_contacto VALUES ('ESP001', 'TELÉFONO', '999999999'), ('ESP001', 'MÓVIL', '666666666'), ('ESP001', 'E-MAIL', 'jllobregat@yahoo.es'),
									('USA001', 'TELÉFONO', '958999999'), ('USA001', 'E-MAIL', 'sgary@gmail.com'),
									('FRA001', 'MÓVIL', '654654654'), ('FRA001', 'MÓVIL', '655655655'),
									('ESP002', 'E-MAIL', 'silviad@gmail.es'), ('ESP002', 'E-MAIL', 'sduran@gmail.com'),
									('ESP004', 'TELÉFONO', '955955955'), ('ESP004', 'MÓVIL', '655456456'), ('ESP004', 'MÓVIL', '653345345'),
									('USA003', 'MÓVIL', '601601601'), ('USA003', 'E-MAIL', 'kshull@gmail.com'),
									('ESP005', 'TELÉFONO', '933933933'), ('ESP005', 'MÓVIL', '655555555'), ('ESP005', 'E-MAIL', 'jmoreno@yahoo.es'),
									('ESP006', 'MÓVIL', '689689689'), ('ESP006', 'E-MAIL', 'mruiz@gmail.es');

INSERT INTO participa VALUES ('ESP001', 'BDO2324', 1, 450.00),
								('USA002', 'BDO2324', 2, 350.00),
								('ESP002', 'BDO2324', 3, 550.00),
								('USA003', 'POO2324', 1, 600.00),
								('USA001', 'POO2324', 2, 520.00),
								('USA001', 'PWB2324', 1, 370.00),
								('ESP003', 'PWB2324', 2, 250.00),
								('FRA001', 'PWB2324', 3, 375.00),
								('USA003', 'PWB2324', 4, 350.00),
								('ESP002', 'ADS2324', 1, 420.00),
								('FRA001', 'ADS2324', 2, 330.00),
								('USA001', 'ADS2324', 3, 560.00),
								('USA002', 'ADS2324', 4, 150.00),
								('ESP004', 'ADS2324', 5, 480.00),
								('ESP003', 'SEG2324', 1, 350.00),
								('ESP004', 'SEG2324', 2, 290.00),
								('USA001', 'SEG2324', 3, 600.00),
								('FRA001', 'SEG2324', 4, 570.00);

INSERT INTO asistente VALUES ('AS0001', 'Mario', 'Céspedes', 'Hermida', 'H', '1980-11-16', 'BK Programación', 4),
								('AS0002', 'Carmen', 'Gutiérrez', 'Sevilla', 'M', '1978-02-20', 'BK Programación', 18),
								('AS0003', 'Felipe', 'Martín', 'Comillas', 'H', '1985-11-06', 'ProgConsulting', 29),
								('AS0004', 'Lourdes', 'Soriano', 'López', 'M', '1992-07-30', NULL, 41),
								('AS0005', 'Inmaculada', 'Herrero', 'Puig', 'M', '1988-09-13', 'BigSoft', 41),
								('AS0006', 'Lucía', 'Díaz', 'Martínez', 'M', '1983-08-25', 'BigSoft', NULL),
								('AS0007', 'Fermín', 'Gutiérrez', 'Pérez', 'H', '1979-03-03', 'ProgConsulting', 29),
								('AS0008', 'José Enrique', 'Martos', 'Martos', 'H', '1992-10-20', 'BK Programación', 29),
								('AS0009', 'José Ramón', 'Gómez', 'Pérez', 'H', '1983-01-21', 'ProgConsulting', NULL),
								('AS0010', 'Mercedes', 'Bosh', 'Toral', 'M', '1990-05-05', 'BK Programación', 23),
								('AS0011', 'María José', 'Vázquez', 'Soriano', 'M', '2000-03-19', NULL, 23),
								('AS0012', 'José Luis', 'Jiménez', 'Molina', 'H', '2001-10-01', 'BigSoft', 18),
								('AS0013', 'Manuel', 'Pérez', 'Martínez', 'H', '1997-11-30', NULL, 18),
								('AS0014', 'Manuel Jesús', 'López', 'Martínez', 'H', '2002-10-08', NULL, 29),
								('AS0015', 'María', 'Montes', NULL, 'M', '2003-01-30', NULL, 18);

INSERT INTO asiste VALUES ('AS0013', 'BDO2324'),
							('AS0009', 'BDO2324'),
							('AS0006', 'BDO2324'),
							('AS0007', 'BDO2324'),
							('AS0012', 'BDO2324'),
							('AS0003', 'BDO2324'),
							('AS0008', 'POO2324'),
							('AS0003', 'POO2324'),
							('AS0005', 'POO2324'),
							('AS0013', 'POO2324'),
							('AS0002', 'POO2324'),
							('AS0001', 'POO2324'),
							('AS0012', 'POO2324'),
							('AS0010', 'POO2324'),
							('AS0004', 'POO2324'),
							('AS0007', 'POO2324'),
							('AS0011', 'POO2324'),
							('AS0012', 'PWB2324'),
							('AS0007', 'PWB2324'),
							('AS0009', 'PWB2324'),
							('AS0013', 'PWB2324'),
							('AS0008', 'PWB2324'),
							('AS0004', 'PWB2324'),
							('AS0011', 'PWB2324'),
							('AS0003', 'PWB2324'),
							('AS0010', 'PWB2324'),
							('AS0001', 'PWB2324'),
							('AS0006', 'PWB2324'),
							('AS0005', 'PWB2324'),
							('AS0002', 'PWB2324'),
							('AS0012', 'ADS2324'),
							('AS0008', 'ADS2324'),
							('AS0010', 'ADS2324'),
							('AS0001', 'ADS2324'),
							('AS0007', 'ADS2324'),
							('AS0009', 'SEG2324'),
							('AS0008', 'SEG2324'),
							('AS0003', 'SEG2324'),
							('AS0004', 'SEG2324'),
							('AS0010', 'SEG2324'),
							('AS0006', 'SEG2324');
