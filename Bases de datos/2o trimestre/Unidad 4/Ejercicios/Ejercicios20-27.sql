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
