/*34. Realizar una consulta que seleccione los ponentes (nombre, apellido1 y apellido2) cuyo primer apellido sea igual al 
primer apellido del asistente de menor edad. */
SELECT nombre, apellido1, apellido2
FROM ponente
WHERE apellido1 IN (SELECT apellido1
		    FROM asistente
		    WHERE fechaNac = (SELECT MAX(fechaNac)
				      FROM asistente));
                      

/*35. Realizar una consulta (utilizando subconsultas) que obtenga los distintos ponentes 
(nombre, apellido1 y apellido2) que han usado la sala “Afrodita” para dar una conferencia.*/
SELECT DISTINCT nombre, apellido1, apellido2
FROM ponente
WHERE codigo IN (SELECT codPonente
		 FROM participar
		 WHERE refConferencia IN (SELECT referencia
					  FROM conferencia
					  WHERE sala= 'Afrodita'))
ORDER BY 2, 3, 1;


/*36. Realizar una consulta que muestre los asistentes (nombre, apellido1 y apellido2) de la empresa 
“BigSoft” que asisten a algunas de las sesiones de la conferencia sobre “Programación Web”.*/
SELECT nombre, apellido1, apellido2
FROM asistente
WHERE empresa = 'BigSoft' AND
      codigo IN (SELECT codAsistente
		 FROM asistir
		 WHERE refConferencia IN (SELECT referencia
					  FROM conferencia
					  WHERE tema = 'Programación Web'));


/*37. Realizar una consulta que muestre los asistentes (nombre, apellido1 y apellido2) que sean hombres 
y hayan nacido antes del “01/01/1985”, y además hayan asistido a una conferencia sobre “Programación Web”.*/
SELECT nombre, apellido1, apellido2
FROM asistente
WHERE sexo ='H' AND fechaNac < '1985-01-01' AND
      codigo IN (SELECT codAsistente 
		 FROM asistir
		 WHERE refConferencia IN (SELECT referencia
					  FROM conferencia
					  WHERE tema = 'Programacion Web'));


/*38. Realizar una consulta que muestre el total de gratificaciones recibidas por cada uno de los ponentes.*/
SELECT nombre, CONCAT_WS (' ', apellido1, apellido2) AS apellidos, gratificacion_total
FROM ponente JOIN (SELECT codPonente, SUM(gratificacion) AS gratificacion_total
FROM participar
GROUP BY codPonente) AS sub ON p.codigo = sub.codPonente;


/*39. Realizar una consulta que muestre los asistentes (nombre, apellido1 y apellido2) a cada una de las conferencias que se celebran el día “02/10/2013” (tema). El resultado debe mostrarse ordenado por el tema de la conferencia, así como por los apellidos y nombre de los asistentes*/
SELECT DISTINCT nombre, CONCAT(apellidol,' ', NVL(apellido2, "")) AS apellidos, tema
FROM asistente JOIN asistir ON asistente.codigo = asistir.codAsistente
	       JOIN conferencia ON asistir.refConferencia = conferencia.referencia
WHERE fecha = '2013-10-02'
ORDER BY tema, apellidos, nombre;


/*40. Obtener el nombre de las salas que únicamente se utilizan en el turno de tarde y no en el de mañana. Proponer dos sentencias, una que haga uso de EXCEPT y otra con subconsultas.*/
SELECT sala
FROM conferencia
EXCEPT
SELECT sala
FROM conferencia
WHERE turno = "M";


/*41. Obtener el nombre de las salas que se utilizan en el turno de mañana y tarde. Proponer tres sentencias distintas, una que haga uso de INTERSECT, otra multitabla con JOIN y otra con subconsultas.*/
SELECT sala
FROM conferencia
WHERE turno = "M" AND sala IN (SELECT sala
			       FROM conferencia
			       WHERE turno = "T");


/*42. Obtener el nombre y apellidos (apellido1 y apellido2) del ponente o ponentes que cobra(n) la mayor gratificación. Hacer uso únicamente de subconsultas.*/
SELECT nombre, CONCAT(apellidol,' ', NVL(apellido2, "")) AS apellidos
FROM ponente
WHERE codigo IN (SELECT codPonente
		 FROM participar
		 WHERE gratificacion = (SELECT MAX(gratificacion) 
					FROM participar));


/*43. Obtener el nombre y apellidos (apellido1 y apellido2) del asistente de mayor edad que asiste a la conferencia más cara. Hacer uso únicamente de subconsultas.*/
SELECT nombre, CONCAT(apellidol,' ', apellido2) AS apellidos
FROM asistente
WHERE fechaNac = (SELECT MIN(fechaNac) 
		  FROM asistente)
AND codigo IN (SELECT codAsistente 
		FROM asistir
		WHERE refConferencia IN (SELECT referencia
					FROM conferencia
					WHERE precio = (SELECT MAX(precio) 
						        FROM conferencia)));


/*44. Obtener el nombre, apellidos y gratificación de aquellos ponentes cuya gratificación sea mayor a la de todos los ponentes que hayan realizado la conferencia en la sala “Afrodita”. Mezclar el uso de JOIN y subconsultas.*/
SELECT DISTINCT nombre, CONCAT_WS(" ", apellidol, apellido2) AS apellidos, gratificacion
FROM ponente AS pon JOIN participar AS par ON pon.codigo = par.codPonente
WHERE gratificacion > (SELECT MAX(gratificacion)
			FROM participar
			WHERE refConferencia IN (SELECT referencia
						FROM conferencia
						WHERE sala = "Afrodita"));


/*45. Obtener el nombre o nombres de las salas y su capacidad donde participa el ponente de la especialidad “Seguridad Informática” que recibe la mayor gratificación. Mezclar el uso de JOIN y subconsultas*/
SELECT DISTINCT s.nombre, capacidad
FROM sala AS s JOIN conferencia AS c ON s.nombre = c.sala
	JOIN participar AS pa ON c.referencia = pa.refConferencia
WHERE gratificacion = (SELECT MAX(gratificacion)
		     FROM participar
		     WHERE codPonente IN (SELECT codigo
					  FROM ponente
					  WHERE especialidad = 'Seguridad Informática'));


/*46. Obtener los ponentes de la especialidad “Bases de Datos” que tienen una gratificación mayor a la de alguno de los ponentes de “Programación Orientada a Objetos”. Mezclar el uso de JOIN y subconsultas.*/
SELECT DISTINCT nombre, apellido1, apellido2
FROM ponente AS p JOIN participar AS pa ON p.codigo = pa.codPonente
WHERE p.especialidad = 'Bases de Datos'
	AND pa.gratificacion > ANY (SELECT pa2.gratificacion
			FROM ponente AS p2 JOIN participar AS pa2 ON p2.codigo = pa2.codPonente
			WHERE p2.especialidad = 'Programacion');


/*47. Seleccionar la sala o salas donde no se han celebrado conferencias. Utilizar subconsultas que usen NOT EXISTS. */
SELECT nombre
FROM sala
WHERE nombre NOT IN (SELECT sala 
                      FROM conferencia);


/*48. Seleccionar los ponentes que han utilizado la sala “Zeus”. Utilizar subconsultas que hagan uso de EXISTS*/
SELECT nombre, CONCAT_WS(" ", apellido1, apellido2) AS apellidos
FROM ponente AS po
WHERE EXISTS (SELECT *
    		FROM participar AS pa
    		WHERE po.codigo = pa.codPonente
 AND EXISTS (SELECT *
        		FROM conferencia AS c
          		WHERE pa.refConferencia = c.referencia
        		 AND sala = 'Zeus'));