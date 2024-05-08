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