/* 1 - Crear una única sentencia de consulta que calcule la suma, resta, producto y división de los números 10 y 5
respectivamente. Asignar un alias a cada una de las operaciones.*/
SELECT 10+5 AS 'suma', 10-5 AS 'resta', 10*5 AS 'producto', 10/5 AS 'division';

/* 2 - Realizar una consulta que muestre el nombre y los apellidos de los asistentes cuya empresa sea “BK
Programación”.*/
SELECT nombre, apellido1, apellido2 
FROM asistente 
WHERE empresa='BK Programación';

/* 3 - Realizar una consulta que muestre el nombre y capacidad de las salas, ordenada de mayor a menor capacidad. */
SELECT nombre, capacidad 
FROM sala 
ORDER BY capacidad DESC;

/* 4 - Realizar una consulta donde se obtenga toda la información de los asistentes de la empresa “BigSoft”
ordenados por la fecha de nacimiento de forma descendente. */
SELECT *
FROM asistente
WHERE empresa = 'BigSoft'
ORDER BY fechaNac DESC;

/* 5 - Realizar una consulta que muestre el total de asistentes por empresa (ver ejemplo punto 2.4) */
SELECT empresa, COUNT(*) AS total_asistentes
FROM asistente
GROUP BY empresa;

/* 6 - Realizar una consulta que muestre el nombre y los apellidos de los primeros cinco asistentes, el resultado debe
mostrarse ordenado por el primer apellido de forma ascendente. */
SELECT nombre, apellido1, apellido2
FROM asistente
ORDER BY apellido1
LIMIT 5;

/* 7 - Realizar una consulta donde se obtenga el tema y la fecha de las conferencias que tengan turno de tarde y se
celebren en las salas “Apolo” y/o “Zeus”. */
SELECT tema, fecha 
FROM conferencia
WHERE turno = 'T' AND (sala = 'Apolo' OR sala = 'Zeus');
-- WHERE turno = 'T' AND sala IN ()'Apolo', 'Zeus');

/* 8 - Realizar una consulta donde se obtengan aquellos asistentes cuyo apellido1 comienza por la letra “M” y
contienen la letra “R”. */
SELECT *
FROM asistente
WHERE apellido1 LIKE 'M%R%';

/* 9 - Realizar una consulta que seleccione las conferencias cuyo precio esté comprendido entre 12 y 19 euros, y cuyo
tema no sea “Programación Web”. */
SELECT *
FROM conferencia
WHERE (precio BETWEEN 12 AND 19) AND tema != 'Programación Web';
-- WHERE precio BETWEEN 12 AND 19 AND tema NOT IN ()'Programación Web');

/* 10 - Realizar una consulta que seleccione los asistentes cuyas fechas de nacimiento estén comprendidas entre el
01/01/1974 y el 01/01/1985, ordenando los resultados por la fecha de nacimiento y concatenando las columnas
apellido1 y apellido2 en una sola a la que se le asigne el alias “Apellidos” */
SELECT CONCAT(apellido1, ' ', apellido2) AS Apellidos
FROM asistente
WHERE fechaNac BETWEEN '1974-01-01' AND '1985-01-01'
ORDER BY fechaNac;

/* 11 - . Realizar una consulta que seleccione las conferencias cuyo tema comience por “Programación”, ordenando los
resultados por su precio de forma descendente (de mayor a menor precio). */
SELECT *
FROM conferencia
WHERE tema LIKE 'Programación%'
ORDER BY precio DESC;

/* 12 - Realizar una consulta que calcule los precios de las distintas conferencias teniendo en cuenta que se van a
aplicar los siguientes descuentos: 0%, 5%, 10%, 15% y 20%. Asignar un alias a cada una de las nuevas columnas
calculadas (“Descuento 0%”, “Descuento 5%”, ... respectivamente). */
SELECT precio AS 'Descuento 0%', precio*0.95 AS 'Descuento 5%', precio*0.90 AS 'Descuento 10%', precio*0.85 AS 'Descuento 15%', precio*0.80 AS 'Descuento 20%'
FROM conferencia;

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

/* 20. Realizar una consulta donde se obtenga el número total de salas cuya capacidad sea igual o superior a 200.
*/
SELECT COUNT(nombre) AS 'Número de salas'
FROM sala
WHERE capacidad >= 200;

/* 21. Realizar una consulta donde se obtenga la media de las gratificaciones de cada uno de los ponentes.
*/
SELECT codPonente, AVG(gratificacion) AS 'Media de las gratificaciones'
FROM participar
GROUP BY codPonente;

/* 22. Realizar una consulta que muestre el total de salas distintas en función del turno: de mañana (M) o tarde (T).
*/
SELECT COUNT(sala) AS 'Salas distintas por turno', turno
FROM conferencia
GROUP BY turno;

/* 23. Repetir el ejercicio anterior teniendo en cuanta que la sala “Apolo” no debe salir en el resultado final.
*/
SELECT COUNT(sala) AS 'Salas distintas por turno', turno
FROM conferencia
WHERE sala != 'Apolo'
GROUP BY turno;

/* 24. Repetir el ejercicio anterior de forma que se muestre el total del turno de mañana (M).
*/
SELECT COUNT(sala) AS 'Salas distintas por turno', turno
FROM conferencia
WHERE sala != 'Apolo' AND turno = 'M'
GROUP BY turno;

/* 25. Realizar una consulta que muestre el total de asistentes hombres (H) y mujeres (M) por cada empresa.
*/
SELECT empresa, COUNT(nombre) AS 'Numero de asistentes', sexo
FROM asistente
GROUP BY empresa, sexo;

/* 26. Repetir el ejercicio anterior de forma que para los asistentes que tenga como valor de empresa NULL se agrupen
en una categoría llamada "Sin empresa asignada".
*/
SELECT NVL(empresa, 'Sin empresa'), COUNT(nombre) AS 'Numero de asistentes', sexo
FROM asistente
GROUP BY empresa, sexo;

/* 27. Repetir el ejercicio anterior y hacer que solo se muestren los totales de hombres por cada una de las empresas.
*/
SELECT NVL(empresa, 'Sin empresa'), COUNT(nombre) AS 'Numero de asistentes', sexo
FROM asistente
WHERE sexo = 'H'
GROUP BY empresa, sexo;

/*Utilizando las tablas y datos de las BD “conferencias” y “conferencias2” (una sentencia para cada BD y ejercicio):
28. Realizar una consulta donde se obtenga el nombre de los ponentes junto a la referencia y el tema de las
conferencias en las que han participado.
*/
SELECT CONCAT_WS(' ', nombre, apellido1, apellido2) AS ponente, referencia, tema
FROM conferencia JOIN participar ON participar.refConferencia = conferencia.referencia JOIN ponente ON ponente.codigo = participar.codPonente;

SELECT CONCAT_WS(' ', nombre, apellido1, apellido2) AS ponente, conferencia.idConferencia, tema
FROM conferencia JOIN participa USING (idConferencia) JOIN ponente USING (idPonente);

/*29. Realizar una consulta que obtenga un listado con el nombre y apellidos de los asistentes que hayan asistido a
la conferencia con referencia “PWB1314”.
*/
SELECT nombre, CONCAT_WS(' ', apellido1, apellido2) AS apellidos
FROM asistente JOIN asistir ON asistir.codAsistente = asistente.codigo JOIN conferencia ON conferencia.referencia = asistir.refConferencia
WHERE referencia = 'PWB1314';

SELECT nombre, CONCAT_WS(' ', apellido1, apellido2) AS apellidos
FROM asistente JOIN asiste USING (idAsistente) JOIN conferencia USING (idConferencia)
WHERE conferencia.idConferencia = 'PWB1314';

/*30. Realizar una consulta que muestre el número de asistentes a cada una de las conferencias.
*/
SELECT COUNT(asistir.codAsistente) AS n_asistentes, tema
FROM asistir JOIN conferencia ON asistir.refConferencia = conferencia.referencia 
GROUP BY tema;

SELECT COUNT(asiste.idAsistente) AS n_asistentes, tema
FROM asiste JOIN conferencia USING (idConferencia) 
GROUP BY tema;

/*31. Realizar una consulta que muestre la sala donde cada ponente realiza su conferencia. La consulta además de
los datos del ponente debe mostrar el nombre de la sala, el tema de la conferencia y el orden de intervención.
Los resultados se deben ordenar por el tema y el orden de intervención.
*/
SELECT conferencia.sala, CONCAT_WS(' ', ponente.nombre, ponente.apellido1, ponente.apellido2) AS 'Info Ponente', 
    conferencia.tema , participar.numOrden AS 'Orden de intervención'
FROM conferencia JOIN participar ON participar.refConferencia = conferencia.referencia JOIN ponente ON ponente.codigo = participar.codPonente
ORDER BY conferencia.tema, participar.numOrden;

SELECT conferencia.nombreSala, CONCAT_WS(' ', ponente.nombre, ponente.apellido1, ponente.apellido2) AS 'Info Ponente', 
    conferencia.tema , participa.numOrden AS 'Orden de intervención'
FROM conferencia JOIN participa USING (idConferencia) JOIN ponente USING (idPonente)
ORDER BY conferencia.tema, participa.numOrden;

/*32. Realizar una consulta que muestre el total de asistentes por conferencia y sala. El resultado se debe ordenar
por el número de asistentes.
*/
SELECT COUNT(asistir.codAsistente) AS 'Total asistentes', conferencia.tema, sala.nombre
FROM asistir JOIN conferencia ON conferencia.referencia = asistir.refConferencia JOIN sala ON sala.nombre = conferencia.sala
GROUP BY conferencia.tema, sala.nombre;

SELECT COUNT(asiste.idAsistente) AS 'Total asistentes', conferencia.tema, sala.nombreSala
FROM asiste JOIN conferencia USING (idConferencia) JOIN sala USING (nombreSala)
GROUP BY conferencia.tema, sala.nombreSala;

/*33. Realizar una consulta que muestre los distintos ponentes que han utilizado la sala “Afrodita”.
*/
SELECT CONCAT_WS(' ', ponente.nombre, ponente.apellido1, ponente.apellido2) AS 'Info ponente', conferencia.sala
FROM ponente JOIN participar ON participar.codPonente = ponente.codigo JOIN conferencia ON conferencia.referencia = participar.refConferencia
WHERE conferencia.sala = 'Afrodita';

SELECT CONCAT_WS(' ', ponente.nombre, ponente.apellido1, ponente.apellido2) AS 'Info ponente', conferencia.nombreSala
FROM ponente JOIN participa USING (idPonente) JOIN conferencia USING (idConferencia)
WHERE conferencia.nombreSala = 'Afrodita';