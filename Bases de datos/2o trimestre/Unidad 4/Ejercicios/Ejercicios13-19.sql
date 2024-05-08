/*  13. Realizar una consulta que aplique un incremento del 5% a los precios de las conferencias, una vez aplicado
redondee el precio al número entero menor más cercano y ordene finalmente las filas por el precio obtenido
de forma descendente (de mayor a menor). Hacer que la fecha se muestre en formato “DD/MM/YYYY”.
*/
SELECT FLOOR(precio * 1.05) AS 'Precio incrementado', DATE_FORMAT(fecha, '%d/%m/%Y')
FROM conferencia
ORDER BY 'Precio incrementado' DESC;

/*  14. Realizar una consulta sobre la tabla ponentes que muestre todos los campos alfanuméricos en mayúsculas, se
deben concatenar los apellidos y mostrar una única columna para ambos. El resultado se debe ordenar por la
columna de apellidos resultante de forma ascendente
*/
SELECT UPPER(codigo), UPPER(nombre), CONCAT_WS(' ', UPPER(apellido1), UPPER(apellido2)) AS apellidos, UPPER(especialidad)
FROM ponente
ORDER BY apellidos;

/* 15. Repetir el ejercicio anterior para que en el caso de que el segundo apellido sea NULL muestre la cadena '*****'.
*/
SELECT UPPER(codigo), UPPER(nombre), CONCAT_WS(' ', UPPER(apellido1), UPPER(NVL(apellido2,'*****'))) AS apellidos, UPPER(especialidad)
FROM ponente
ORDER BY apellidos;

/* 16. Repetir el ejercicio anterior completando con * los nombres y apellidos que no lleguen a 10 caracteres
*/
SELECT UPPER(codigo), UPPER(RPAD(nombre,10,'*')), 
    CONCAT_WS(' ', UPPER(RPAD(apellido1,10,'*')), UPPER(RPAD(NVL(apellido2,'*****'),10,'*'))) AS apellidos, UPPER(especialidad)
FROM ponente
ORDER BY apellidos;

/* 17. Realizar una consulta sobre la tabla asistente que muestre el nombre y apellidos de los asistentes, en el
resultado que se muestre la palabra “José” debe ser sustituida por “Pepe”. Además, para cada fila se debe
añadir una nueva columna que muestre la longitud total del nombre y apellidos del asistente sin tener en
cuenta los espacios de separación entre el nombre y los apellidos.
*/
SELECT REPLACE(nombre, 'José', 'Pepe'), CONCAT_WS(' ', apellido1, apellido2) AS apellidos, 
    CHAR_LENGTH(CONCAT(nombre, CONCAT_WS(' ', apellido1, apellido2)))
FROM asistente;

/* 18. Realizar una consulta sobre la tabla asistente que muestre los días que lleva viviendo cada uno de ellos. Además
de los días vividos debe mostrar el nombre y los apellidos.
*/
SELECT DATEDIFF(DATE(SYSDATE()), fechaNac) AS 'Dias vividos', nombre, CONCAT_WS(' ', apellido1, apellido2) AS apellidos
FROM asistente;

/* 19. Realizar una consulta que muestre el nombre y los apellidos junto al día de la semana, el día del año y el número
de la semana de la fecha de nacimiento de cada uno de los asistentes. Asignar un alias a cada uno de los campos
mostrados. 
*/
SELECT nombre, CONCAT_WS(' ', apellido1, apellido2) AS apellidos, DAYOFWEEK(fechaNac) AS 'Día de la semana de nacimiento', DAYOFYEAR(fechaNac) AS 'Día del año de nacimiento',
    WEEKOFYEAR(fechaNac) AS 'Semana del año de nacimiento'
FROM asistente;