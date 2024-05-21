/*1. Crear un procedimiento que devuelva las conferencias que da un ponente. Recibirá como parámetros el
nombre, apellido1 y apellido2 del ponente. Suponer que el nombre y los apellidos no se pueden repetir.*/
USE conferencias2;
DELIMITER $$
CREATE OR REPLACE PROCEDURE devolver_conferencias_ponente(p_nombre VARCHAR(50), p_apellido1 VARCHAR(50), p_apellido2 VARCHAR(50))
    COMMENT 'Devuelve las conferencias de ese ponente'
BEGIN
    SELECT tema
    FROM ponente JOIN participa USING (idponente) JOIN conferencia USING (idConferencia)
    WHERE nombre = p_nombre AND apellido1 = p_apellido1 AND apellido2 = p_apellido2;
END$$
DELIMITER ;

SET @p_nombre = 'Juan';
SET @p_apellido1 = 'Llobregat';
SET @p_apellido2 = 'García';
CALL devolver_conferencias_ponente(@p_nombre, @p_apellido1, @p_apellido2);

/*2. Crear un procedimiento que devuelva los datos del/os ponente/s que dan más conferencias de las indicadas
en un parámetro de entrada que se le pasa.*/
USE conferencias2;
DELIMITER $$
CREATE OR REPLACE PROCEDURE devolver_ponente_mas_conferencia(p_numConf SMALLINT)
    COMMENT 'Devuelve los datos del o los ponentes que dan más conferencias de las indicadas'
BEGIN
    SELECT nombre, apellido1, NVL(apellido2, '') AS apellido2
    FROM ponente 
    WHERE idPonente IN (SELECT idPonente
                        	FROM participa
                        	GROUP BY idPonente
                        	HAVING  COUNT(idConferencia) > p_numConf);
        
END$$
DELIMITER ;

SET @p_numConf = 1;
CALL devolver_ponente_mas_conferencia(@p_numConf);

/*3. Crear un procedimiento que inserte una nueva sala. Los parámetros que se le pasen deben ser del mismo tipo
y tamaño que el de columnas de la tabla sala.*/
USE conferencias2;
DELIMITER $$
CREATE OR REPLACE PROCEDURE insertar_sala(p_nombre VARCHAR(50), p_capacidad SMALLINT(5))
    COMMENT 'Inserta una nueva sala'
BEGIN
    INSERT sala VALUES (p_nombre, p_capacidad);
        
END$$
DELIMITER ;

SET @p_nombre = 'Zegreo';
SET @p_capacidad = 200;
CALL insertar_sala(@p_nombre, @p_capacidad);

/*4. Crear un procedimiento que permita modificar los datos de una conferencia (no se permite actualizar su clave
primaria). Los parámetros que se le pasen deben ser de los tipos y tamaños adecuados.*/
USE conferencias2;
DELIMITER $$
CREATE OR REPLACE PROCEDURE insertar_sala(p_id char(7), p_tema VARCHAR(60), p_precio DECIMAL(5,2), p_fecha DATE, p_turno VARCHAR(11), p_sala VARCHAR(50))
    COMMENT 'Modifica una conferencia'
BEGIN
    UPDATE conferencia SET tema = p_tema, precio = p_precio, fecha = p_fecha, turno = p_turno, nombreSala = p_sala;
        
END$$
DELIMITER ;

SET @p_id = 'BDO1314';
SET @p_tema = 'Machine Learning';
SET @p_precio = 8.7;
SET @p_fecha = '2013-10-01';
SET @p_turno = 'M';
SET @p_sala = 'Apolo';
CALL insertar_sala(@p_id, @p_tema, @p_precio, @p_fecha, @p_turno, @p_sala);

/*5. Crear un procedimiento que borre una sala dado su nombre. La sala se debe eliminar haciendo uso del patrón
nombre% empleando para ello el operador LIKE.*/
USE conferencias2;
DELIMITER $$
CREATE OR REPLACE PROCEDURE borrar_sala(p_nombre VARCHAR(50))
    COMMENT 'Elimina una sala'
BEGIN
    DELETE FROM sala WHERE nombreSala like CONCAT(p_nombre, '%');
        
END$$
DELIMITER ;

SET @p_nombre = 'Zegreo';
CALL borrar_sala(@p_nombre);

/*6. Crear un procedimiento al que se le pase el idPonente de un ponente y devuelva en forma de parámetro de
salida en cuantas conferencias participa.*/
USE conferencias2;
DROP PROCEDURE IF EXISTS obtener_conferencias_ponente;
DELIMITER $$
CREATE PROCEDURE obtener_conferencias_ponente(p_id CHAR(6), OUT p_numConf SMALLINT)
    COMMENT 'Devuelve en p_numConf la cantidad de conferencias en las que participa el ponente p_id'
BEGIN
    SELECT COUNT(*) INTO p_numConf
    FROM ponente JOIN participa USING (idPonente)
    WHERE idPonente = p_id
    GROUP BY idPonente;

END$$
DELIMITER ;

CALL obtener_conferencias_ponente('ESP002', @p_numConf);
SELECT @p_numConf;

/*7. Crear un procedimiento al que se le pase como parámetro el idPonente y devuelva en el mismo parámetro el
nombre completo del ponente con el formato: “apellido1 apellido2, nombre”.*/
USE conferencias2;
DROP PROCEDURE IF EXISTS info_ponente;
DELIMITER $$
CREATE PROCEDURE info_ponente(p_id CHAR(6), OUT p_info VARCHAR(153))
    COMMENT 'Devuelve en p_info los datos del ponente'
BEGIN
    SELECT CONCAT_WS(' ', apellido1, apellido2, nombre) INTO p_info
    FROM ponente 
    WHERE idPonente = p_id;

END$$
DELIMITER ;

CALL info_ponente('ESP002', @p_info);
SELECT @p_info;