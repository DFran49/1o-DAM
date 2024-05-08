/* [NOT] IN (Muestra los valores entre paréntesis) */
SELECT tema
FROM conferencia
WHERE sala  IN ('Afrodita','Zeus') -- sala = 'Afrodita' OR sala = 'Zeus';

SELECT tema
FROM conferencia
WHERE sala NOT IN ('Afrodita','Zeus') -- sala != 'Afrodita' OR sala != 'Zeus';

/* Combinación de comparadores */
SELECT *
FROM conferencia
WHERE precio >= 12 AND turno = 'M';

/* [NOT] BETWEEN para rangos*/
SELECT tema
FROM conferencia
WHERE precio BETWEEN 13 AND 19 -- precio >= 13 AND precio <= 19;
SELECT tema
FROM conferencia
WHERE precio NOT BETWEEN 13 AND 19 -- precio <= 13 AND precio >= 19;

/* LIKE entre comillas la cadena. _ es un solo caracter, % es 0 o más */
SELECT *
FROM asistente
WHERE apellido1 LIKE 'M%';

SELECT *
FROM asistente
WHERE apellido1 LIKE '_e%z';

SELECT *
FROM asistente
WHERE apellido2 LIKE '%l__';

SELECT *
FROM asistente
WHERE apellido1 LIKE '%rr%';

/* IS [NOT] NULL Comparar con NULL */
SELECT *
FROM asistente
WHERE empresa IS NULL;

SELECT *
FROM asistente
WHERE empresa IS NOT NULL;

/* Comparar cadenas de texto con 0 convierte el campo con valor de texto a 0 y los muestra */
SELECT *
FROM asistente
WHERE empresa = 0;

/* Concatenar cadenas de texto y/o signos */
SELECT CONCAT(apellido1, ' ', apellido2, ', ', nombre) AS nombre_comp1,
        CONCAT_WS('****',apellido1,apellido2,nombre) AS nombre_comp2,
        CONCAT(sueldo, '€') AS sueldo_en_euro
FROM entrenador;

/* Operadores Booleanos */
SELECT *
FROM entrenador
WHERE sexo = 'masculino' AND fecha_nacimiento < '1990-01-01'
			AND experiencia BETWEEN 30 AND 95;

SELECT *
FROM entrenador
WHERE (sexo = 'masculino' AND fecha_nacimiento < '1990-01-01'
			AND experiencia BETWEEN 30 AND 95) OR sexo = 'femenino';