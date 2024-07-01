/* 8. Crear una sentencia preparada que devuelva las conferencias en las que participa un ponente. La sentencia se
ejecutará utilizando como parámetros el nombre y apellidos del ponente. No olvidar liberar la memoria
utilizada por la sentencia preparada. No es necesario crear un procedimiento almacenado. */
USE conferencias2;

SET @v_consulta = 'SELECT tema FROM conferencia WHERE idConferencia = 
                    (SELECT idConferencia FROM participa WHERE idPonente = 
                        (SELECT idPonente FROM ponente WHERE nombre = ? AND apellido1 = ? AND (apellido2 = ? OR apellido2 IS NULL )))';
PREPARE prep_consulta FROM @v_consulta;
SET @v_nombre = 'Juan';
SET @v_apellido1 = 'Llobregat';
SET @v_apellido2 = 'García';
EXECUTE prep_consulta USING @v_nombre, @v_apellido1, @v_apellido2;
DEALLOCATE PREPARE prep_consulta;

/* 9. Crear un procedimiento que devuelva el número de conferencias indicado en un parámetro. También se le
pasará otro parámetro con las columnas que se deben mostrar de la forma 'col1, col3, col5'. Poner varios
ejemplos de llamada al procedimiento. ¿Se podría hacer sin utilizar sentencias preparadas? */
USE conferencias2;
DELIMITER $$
CREATE PROCEDURE devolver_conferencias(p_conferencias INT, p_columnas VARCHAR(255))
    COMMENT 'Devuelve las conferencias pasadas como parámetro y las columnas de estas indicadas.'
BEGIN
    DECLARE v_consulta VARCHAR(200);
    SET v_consulta = CONCAT('SELECT ', p_columnas, ' FROM conferencia LIMIT ' p_conferencias);
    PREPARE prep_consulta FROM v_consulta;
    EXECUTE prep_consulta;
    DEALLOCATE PREPARE prep_consulta;
END$$
DELIMITER ;

CALL devolver_conferencias(5, 'tema, precio, turno');
CALL devolver_conferencias(2, 'idConferencia, precio, fecha');

/* 10. Crear un procedimiento que devuelva las conferencias (tema, precio y turno) que tienen lugar en la sala
indicada como parámetro. En caso de que no haya conferencias deberá devolver “SIN CONFERENCIAS” y en el
caso de que no exista la sala, “LA SALA NO EXISTE”. */
USE conferencias2;
DELIMITER $$
CREATE PROCEDURE devolver_conferencias_en_sala(p_sala VARCHAR(255))
    COMMENT 'Devuelve las conferencias de la sala indicada como parámetro.'
BEGIN
    DECLARE existe INT;
    DECLARE cont_salas INT;
    SELECT COUNT(*) INTO existe FROM sala WHERE nombreSala = p_sala;
    IF (existe = 0) THEN
        SELECT 'LA SALA NO EXISTE' AS 'ALERTA';
    ELSE
        SELECT COUNT(*) INTO cont_salas FROM conferencia WHERE nombreSala = p_sala;
        IF (cont_salas = 0) THEN
            SELECT 'SIN CONFERENCIAS' AS 'ALERTA';
        ELSE
            SELECT tema, precio, turno FROM conferencia WHERE nombreSala = p_sala;
        END IF;
    END IF;
END$$
DELIMITER ;

CALL devolver_conferencias_en_sala('Afrodita');
CALL devolver_conferencias_en_sala('Hermes');

/* 11. Crear un procedimiento que devuelva el número de conferencias que se celebraron en la fecha indicada como
parámetro. En caso de que no hubiera conferencias ese día debe devolver -1. */
USE conferencias2;
DELIMITER $$
CREATE PROCEDURE devolver_num_conferencias_fecha(p_fecha DATE, OUT p_num_conferencias INT)
    COMMENT 'Devuelve el número de conferencias de la fecha indicada como parámetro.'
BEGIN
    SELECT COUNT(*) INTO num_conferencias FROM conferencia WHERE fecha = p_fecha;
    IF (num_conferencias = 0) THEN
        SET num_conferencias = -1;
    END IF;
END$$
DELIMITER ;

CALL devolver_num_conferencias_fecha('2013-10-03', @p_num_conferencias);
SELECT @p_num_conferencias;

CALL devolver_num_conferencias_fecha('2015-10-03', @p_num_conferencias);
SELECT @p_num_conferencias;

/* 12. Crear un procedimiento al que se le pase una capacidad como parámetro y devuelva, empleando el mismo
parámetro, cuantas salas tienen una capacidad superior a la pasada. Al mismo tiempo debe mostrar los
nombres de las salas. En caso de que no se encuentren salas, debe devolver -1 y mostrar el texto “SIN SALAS”. */
USE conferencias2;
DELIMITER $$
CREATE PROCEDURE devolver_num_salas(INOUT p_salas INT)
    COMMENT 'Devuelve el número de salas con la capacidad indicada como parámetro.'
BEGIN
    DECLARE temp INT;
    SELECT COUNT(*) INTO temp FROM sala WHERE capacidad > p_salas;
    IF (temp = 0) THEN
        SET p_salas = -1;
        SELECT 'SIN SALAS' AS resultado;
    ELSE
        SELECT nombreSala FROM sala WHERE capacidad > p_salas;
        SET p_salas = temp;
    END IF;
END$$
DELIMITER ;

SET @p_salas = 151;
CALL devolver_num_salas(@p_salas);
SELECT @p_salas;

SET @p_salas = 300;
CALL devolver_num_salas(@p_salas);
SELECT @p_salas;

/* 13. Crear un procedimiento al que se le pase como parámetros un idPonente y dos fechas, y devuelva en forma de
parámetro de salida en cuantas conferencias participó ese ponente entre las dos fechas indicadas.
o En caso de que el ponente no exista, el parámetro de salida debe devolver -1 y mostrarse la cadena “NO
EXISTE EL PONENTE”.
o En caso de que las fechas no tenga un formato correcto (STR_TO_DATE(str,format) devuelve NULL), el
parámetro de salida debe devolver -1 y mostrarse la cadena “FECHAS CON FORMATO INCORRECTO”.
o Si existe el ponente y hay conferencias, el procedimiento también debe mostrar el nombre de las
conferencias (sin repetirse) ordenadas alfabéticamente. */
USE conferencias2;
DELIMITER $$
CREATE PROCEDURE devolver_num_conf_entre_fechas(p_id CHAR(6), p_fecha1 VARCHAR(10), p_fecha2 VARCHAR(10), OUT p_num_conferencias INT)
    COMMENT 'Devuelve el número de conferencias en las que ha participado un ponente entre dos fechas.'
BEGIN
    DECLARE validarFecha1 DATE;
    DECLARE validarFecha2 DATE;
    SELECT COUNT(*) INTO p_num_conferencias FROM ponente WHERE idPonente = p_id;
    IF (p_num_conferencias = 0) THEN
        SET p_num_conferencias = -1;
        SELECT 'NO EXISTE EL PONENTE' AS resultado;
    ELSE
        SET validarFecha1 = STR_TO_DATE(p_fecha1,'%Y-%m-%d');
        SET validarFecha2 = STR_TO_DATE(p_fecha2,'%Y-%m-%d');
        IF (validarFecha1 IS NULL OR validarFecha2 IS NULL) THEN
            SET p_num_conferencias = -1;
        SELECT 'FECHAS CON FORMATO INCORRECTO' AS resultado;
        ELSE
            SELECT DISTINCT tema FROM conferencia WHERE idConferencia IN (SELECT idConferencia FROM participa WHERE idPonente = p_id) ORDER BY tema;
            SELECT COUNT(*) INTO p_num_conferencias FROM conferencia WHERE idConferencia IN (SELECT idConferencia FROM participa WHERE idPonente = p_id);
        END IF;
    END IF;
END$$
DELIMITER ;

CALL devolver_num_conf_entre_fechas('ESP004', '2013-08-19', '2014-05-10', @p_num_conferencias);
SELECT @p_num_conferencias;

CALL devolver_num_conf_entre_fechas('PMR004', '2013-08-19', '2014-05-10', @p_num_conferencias);
SELECT @p_num_conferencias;

CALL devolver_num_conf_entre_fechas('ESP004', '2013-0853-19', '2014-05-10', @p_num_conferencias);
SELECT @p_num_conferencias;

/* 14. Crear un procedimiento que devuelva en forma de parámetro de salida la suma de las capacidades de las salas
enviadas como parámetro. El formato de la lista de salas es una única cadena: 'sala1, sala2, ...'. Emplear las
funciones SUBSTRING y CHAR_LENGTH para descomponer el dato en cada una de las salas (otras funciones que
pueden resultar útiles son TRIM y LOCATE) y buscar la capacidad de cada una de ellas, devolviendo la suma de
las capacidades de todas. En caso de que alguna sala no exista, se deberá mostrar la cadena 'La sala “XXXXXX”
no existe' por cada sala que no exista. Se debe controlar que al menos siempre se envíe una sala, en caso
contrario debe de enviarse -1 en el parámetro de salida. */
