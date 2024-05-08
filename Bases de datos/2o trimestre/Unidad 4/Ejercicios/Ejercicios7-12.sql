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