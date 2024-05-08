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