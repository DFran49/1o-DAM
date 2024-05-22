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
CREATE PROCEDURE devolver_conferencias(p_conferencias VARCHAR(100), p_columnas VARCHAR(100))
    COMMENT 'Devuelve las conferencias pasadas como parámetro y las columnas de estas indicadas.'
BEGIN
    DECLARE v_consulta VARCHAR(200);
    SET v_consulta = CONCAT('SELECT * FROM conferencia WHERE ', p_nom_col, p_oper, '?');
    PREPARE prep_consulta FROM v_consulta;
    EXECUTE prep_consulta USING p_val_par;
    DEALLOCATE PREPARE prep_consulta;
END$$
DELIMITER ;

CALL conferencias_filtro('turno', '=', 'M');

/* 10. Crear un procedimiento que devuelva las conferencias (tema, precio y turno) que tienen lugar en la sala
indicada como parámetro. En caso de que no haya conferencias deberá devolver “SIN CONFERENCIAS” y en el
caso de que no exista la sala, “LA SALA NO EXISTE”. */


/* 11. Crear un procedimiento que devuelva el número de conferencias que se celebraron en la fecha indicada como
parámetro. En caso de que no hubiera conferencias ese día debe devolver -1. */


/* 12. Crear un procedimiento al que se le pase una capacidad como parámetro y devuelva, empleando el mismo
parámetro, cuantas salas tienen una capacidad superior a la pasada. Al mismo tiempo debe mostrar los
nombres de las salas. En caso de que no se encuentren salas, debe devolver -1 y mostrar el texto “SIN SALAS”. */


/* 13. Crear un procedimiento al que se le pase como parámetros un idPonente y dos fechas, y devuelva en forma de
parámetro de salida en cuantas conferencias participó ese ponente entre las dos fechas indicadas.
o En caso de que el ponente no exista, el parámetro de salida debe devolver -1 y mostrarse la cadena “NO
EXISTE EL PONENTE”.
o En caso de que las fechas no tenga un formato correcto (STR_TO_DATE(str,format) devuelve NULL), el
parámetro de salida debe devolver -1 y mostrarse la cadena “FECHAS CON FORMATO INCORRECTO”.
o Si existe el ponente y hay conferencias, el procedimiento también debe mostrar el nombre de las
conferencias (sin repetirse) ordenadas alfabéticamente. */


/* 14. Crear un procedimiento que devuelva en forma de parámetro de salida la suma de las capacidades de las salas
enviadas como parámetro. El formato de la lista de salas es una única cadena: 'sala1, sala2, ...'. Emplear las
funciones SUBSTRING y CHAR_LENGTH para descomponer el dato en cada una de las salas (otras funciones que
pueden resultar útiles son TRIM y LOCATE) y buscar la capacidad de cada una de ellas, devolviendo la suma de
las capacidades de todas. En caso de que alguna sala no exista, se deberá mostrar la cadena 'La sala “XXXXXX”
no existe' por cada sala que no exista. Se debe controlar que al menos siempre se envíe una sala, en caso
contrario debe de enviarse -1 en el parámetro de salida. */
