/*1*/
SELECT nombre, CONCAT_WS(' ',apellido1,apellido2) AS apellidos
FROM asistente
WHERE sexo = 'H' AND empresa IN ('BigSoft', 'BK Programación') AND fechaNac BETWEEN '1970/01/01' AND '1990/12/31'
ORDER BY fechaNac DESC;


/*2*/
SELECT CONCAT_WS(' ', nombre, apellido1, apellido2) AS 'Nombre completo', 
    DATE_FORMAT(fechaNac,'%d/%c/%Y') AS 'Fecha de nacimiento', NVL(empresa, 'Sin empresa') AS empresa 
FROM asistente
WHERE nombre LIKE '_a%'
ORDER BY fechaNac DESC;

/*3*/
SELECT idPonente, CONCAT_WS(' ', nombre, apellido1, apellido2) AS 'Nombre completo', especialidad
FROM ponente
ORDER BY apellido1 DESC
LIMIT 5;

/*5*/
SELECT DISTINCT tema, ROUND(precio*1.05,2) AS precio, DATE_FORMAT(fecha,'%d/%c/%Y'), conferencia.nombreSala, capacidad
FROM conferencia JOIN participa ON participa.idConferencia = conferencia.idConferencia JOIN sala ON sala.nombreSala = conferencia.nombreSala
WHERE turno = 'T';

SELECT DISTINCT tema, ROUND(precio*1.05,2) AS precio, DATE_FORMAT(fecha,'%d/%c/%Y'), conferencia.nombreSala, capacidad
FROM conferencia JOIN participa USING (idConferencia) JOIN sala USING (nombreSala)
WHERE turno = 'T';

/*6*/
SELECT tema, COUNT(idPonente) AS 'Número de ponentes', CONCAT('€ ', FLOOR(AVG(gratificacion))) AS 'Gratificación media'
FROM conferencia JOIN participa USING (idConferencia)
GROUP BY tema
ORDER BY FLOOR(AVG(gratificacion)) DESC;

/*7*/
SELECT nombre, CONCAT_WS(' ',apellido1,apellido2) AS apellidos, SUM(precio) AS 'Total gastado'
FROM asistente JOIN asiste USING (idAsistente) JOIN conferencia USING (idConferencia)
GROUP BY nombre, apellidos
HAVING SUM(precio) > 45
ORDER BY SUM(precio) DESC;

/*8*/
SELECT DISTINCT sala.nombreSala, CONCAT_WS(' ', nombre, apellido1, apellido2) AS 'Nombre completo'
FROM sala JOIN conferencia USING (nombreSala) JOIN participa USING (idConferencia) JOIN ponente USING (idPonente)
ORDER BY nombreSala, 'Nombre completo';
/*FALTAN COSAS HERMES*/

/*9*/
SELECT DISTINCT tema
FROM conferencia JOIN asiste USING (idConferencia) JOIN asistente USING (idAsistente)
WHERE asistente.idAsistente = asiste.idAsistente AND fechaNac = (SELECT MIN(fechaNac)
                                                                    FROM asistente)
ORDER BY tema;

/*10*/
SELECT tema
FROM conferencia
WHERE turno = 'T' AND precio < (SELECT MIN(precio)
                                    FROM conferencia
                                    WHERE turno = 'M')
ORDER BY tema;