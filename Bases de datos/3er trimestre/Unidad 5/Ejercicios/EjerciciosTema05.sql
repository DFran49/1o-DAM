/*Utilizando sentencias SQL, realizar las siguientes
operaciones sobre la BD “tienda” (se dispone del script de
creación de la BD en la unidad 4 o en la misma unidad 5):*/

/*1. Insertar un nuevo fabricante (por ejemplo, Apple) indicando su id y su nombre.*/
INSERT INTO fabricante (id, nombre)
VALUES (NULL,'Apple');

/*2. Insertar dos nuevos fabricantes (por ejemplo, MSI y TP-Link) indicando solamente su nombre haciendo uso
de una única sentencia SQL.*/
INSERT INTO fabricante (id, nombre)
VALUES (NULL, 'MSI'), (NULL, 'TP-Link');


/*3. Insertar un nuevo producto (ver algún producto del fabricante en cuestión) asociado a uno de los nuevos
fabricantes. La sentencia de inserción debe incluir: id, nombre, precio e id_fabricante.*/
INSERT INTO producto (id, nombre, precio, id_fabricante)
VALUES (NULL, 'Portatil Bravo', 759.00, 11);


/*4. Insertar dos nuevos productos (ver productos del fabricante en cuestión) asociado a uno de los nuevos
fabricantes. La sentencia de inserción debe ser única e incluir: nombre, precio e id_fabricante.*/
INSERT INTO producto (nombre, precio, id_fabricante)
VALUES ('WONLINK Repetidor WiFi', 45.88, 12), ('iPhone 15', 809.00, 10);


/*5. Crear una nueva tabla con el nombre fabricante_productos que tenga las siguientes columnas:
nombre_fabricante, nombre_producto y precio. Una vez creada la tabla insertar todos los registros de la BD
“tienda” en esta tabla haciendo uso de una única operación de inserción.*/
CREATE TABLE fabricante_productos (
    nombre_fabricante VARCHAR(30),
    nombre_producto VARCHAR(50),
    precio DECIMAL(5,2)
);
INSERT INTO fabricante_productos (nombre_fabricante, nombre_producto, precio) SELECT fabricante.nombre, producto.nombre, precio 
                                                                            FROM fabricante JOIN producto ON (fabricante.id = producto.id_fabricante);


/*6. Crear una vista con el nombre vista_fabricante_productos que tenga las siguientes columnas:
nombre_fabricante, nombre_producto y precio.*/
CREATE VIEW vista_fabricante_productos AS
SELECT * FROM fabricante_productos;


/*7. Eliminar el fabricante Xiaomi. ¿Es posible eliminarlo? Si no fuese posible, ¿qué cambios se deberían realizar
para que fuese posible borrarlo?*/
DELETE FROM fabricante WHERE nombre = 'Xiaomi';
-- Si es posible eliminarlo, y si no fuese posible habría que activar la supresión en cascada para la clave foranea (id_fabricante)


/*8. Eliminar el fabricante Asus. ¿Es posible eliminarlo? Si no fuese posible, ¿qué cambios se deberían realizar para
que fuese posible borrarlo?*/
DELETE FROM fabricante WHERE nombre = 'Asus';
-- No es posible eliminarlo debido a que se usa en la tabla producto. Para poder cambiarla, hay que activar la supresión en cascada para la clave primaria (id) 
-- con la siguiente cláusula
/* ALTER TABLE producto DROP CONSTRAINT producto_ibfk_1;
ALTER TABLE producto ADD CONSTRAINT producto_ibfk_1 FOREIGN KEY (id_fabricante) REFERENCES fabricante(id) ON DELETE CASCADE;
*/

/*9. Actualizar el código del fabricante Huawei y asignarle el valor 30. ¿Es posible actualizarlo? Si no fuese posible,
¿qué cambios se deberían realizar para que fuese posible actualizarlo?*/
UPDATE fabricante SET id = 30
WHERE nombre = 'Huawei';
-- Si es posible eliminarlo, y si no fuese posible habría que activar la actualización en cascada para la clave primaria (id)


/*10. Actualizar el código del fabricante Lenovo y asignarle el valor 20. ¿Es posible actualizarlo? Si no fuese posible,
¿qué cambios se deberían realizar para que fuese posible actualizarlo?*/
UPDATE fabricante SET id = 20
WHERE nombre = 'Lenovo';
-- No es posible modificarlo debido a que se usa en la tabla producto. Para poder cambiarla, hay que activar la actualización en cascada para la clave primaria (id) 
-- con la siguiente cláusula
/* ALTER TABLE producto DROP CONSTRAINT producto_ibfk_1;
ALTER TABLE producto ADD CONSTRAINT producto_ibfk_1 FOREIGN KEY (id_fabricante) REFERENCES fabricante(id) ON UPDATE CASCADE;
*/


/*11. Actualizar el precio de todos los productos sumándole 5 € al precio actual.*/
UPDATE producto  SET precio = precio+5;

/*12. Eliminar todas las impresoras que tienen un precio menor de 200 €.*/
DELETE FROM producto WHERE nombre LIKE 'Impresora%' AND precio < 200;

/*13. Incrementar en un 5% el precio de los productos que pertenecen a los fabricantes en los que el nombre en su
segundo carácter tiene una “e”.*/
UPDATE producto SET precio = precio*1.05 WHERE id_fabricante IN (SELECT id FROM fabricante WHERE nombre LIKE '_e%');

/*14. (*) Añadir un “*” al final del nombre del fabricante para aquellos en los que el precio medio de sus productos
sea superior a 200.*/
UPDATE fabricante SET nombre = CONCAT(nombre,'*') WHERE id IN (SELECT id_fabricante FROM producto GROUP BY id_fabricante HAVING AVG(precio) > 200);

/*15. Eliminar todos los fabricantes que no tienen productos asignados.*/
DELETE FROM fabricante WHERE id IN (SELECT fabricante.id FROM fabricante LEFT JOIN producto ON fabricante.id=id_fabricante WHERE producto.nombre IS NULL);

/*Utilizando el script SQL proporcionado en la unidad (BD-U5.- Script tarea.sql):
NOTA: el último campo trim_anyo_vip almacenará valores como TRIM1_2014, TRIM2_2014, TRIM3_2014, TRIM4_2014,
etc. con el objetivo de saber qué socio/s han conseguido la condición de VIP en cada uno de los trimestres de cada año.
Para la realización de esta tarea es necesario descargar y ejecutar el script “BD-U5.- Script tarea.sql”, el cual crea
las tablas e inserta los datos necesarios.
Utilizando sentencias SQL y alguna de las interfaces gráficas vistas, realizar las siguientes operaciones adjuntando
capturas de pantalla:*/

/*16. Insertar un nuevo socio con los siguientes datos:
    Núm. Socio: 1007
    Nombre: Francisco
    Apellido 1: Sánchez
    Domicilio: Avda. de las Palmeras, 2
    Población: Armilla
    Fecha de nacimiento: 02/02/1970
NOTA: el resto de campos no deben ser introducidos.*/
INSERT INTO socio (num_socio, nombre, apellido1, domicilio, poblacion, fec_nac)
VALUES (1007, 'Francisco', 'Sánchez', 'Avda. de las Palmeras, 2', 'Armilla', '1970/02/02');
/*PREGUNTAR HASTA CUANDO CAPTURAS*/

/*17. Registrar el primer alquiler del socio 1007 que se lleva la copia 105 (correspondiente a la película "Lo
imposible") en la fecha actual (en la que se está haciendo la tarea).
NOTA: la fecha de devolución no se debe introducir aún.*/
INSERT INTO alquiler (copia_pel, socio, fec_alquila)
VALUES (105, 1007, DATE(SYSDATE()));
/*No coge bien la fecha y hora (2 horas antes)*/

/*18. Modificar el estado de la copia de la película con id 101 a "ESTROPEADA" incluyendo como observación
"Rayado".*/
UPDATE copia_pelicula SET estado = 'ESTROPEADA', observacion = 'RAYADA' WHERE id_copia = 101;

/*19. Eliminar la película cuyo título es "El Orfanato".*/
DELETE FROM pelicula WHERE titulo = 'El Orfanato';

/*Utilizando sentencias SQL, realizar las siguientes operaciones:*/

/*20. Insertar una nueva película (inventando los datos) y después dar de alta dos copias para dicha película con el
estado "FUNCIONA".*/
INSERT INTO pelicula VALUES ('IEP', 'Inazuma Eleven: La Película', 90, '2010', 'Deportes', 2.5);
INSERT INTO copia_pelicula (id_copia, estado, pelicula)
VALUES ('113', 'FUNCIONA', 'IEP'), ('114', 'FUNCIONA', 'IEP');

/*21. Actualizar todas las películas que tengan como género "Animación" y reemplazarlo por "Dibujos".*/
UPDATE pelicula SET genero = 'Diujos' WHERE genero = 'Animación';

/*22. Eliminar aquellos socios cuya última película alquilada sea anterior al 1 de diciembre de 2014.*/
DELETE FROM socio WHERE num_socio IN (SELECT socio FROM alquiler GROUP BY socio HAVING MAX(fec_alquila) < '2014/12/01'); 

/*23. Incrementar en 20 céntimos el precio del alquiler a todas las películas que tengan más de dos copias.*/
UPDATE pelicula SET precio_alquiler = precio_alquiler+0.20 WHERE codigo = (SELECT pelicula FROM copia_pelicula GROUP BY pelicula HAVING COUNT(*) > 2);

/*24. Eliminar todas las copias de las películas que contengan la palabra "FROZEN" y que su estado sea
"ESTROPEADA".*/
DELETE FROM copia_pelicula WHERE estado = 'ESTROPEADA' AND pelicula IN (SELECT codigo FROM pelicula WHERE titulo LIKE '%FROZEN%');

/*25. (** Opcional) Actualizar el precio de alquiler de aquellas películas cuyo número total de alquileres (de todas
sus copias) sea inferior a la media de los alquileres de todas las películas. El precio debe reducirse en un 50%
de su precio original.*/
UPDATE pelicula SET precio_alquiler = precio_alquiler*0.50
 WHERE codigo IN 
 (SELECT pelicula FROM (SELECT pelicula, COUNT(*) FROM alquiler JOIN copia_pelicula ON id_copia = copia_pel GROUP BY pelicula 
 HAVING (SELECT COUNT(*) FROM alquiler)/(SELECT COUNT(*) FROM pelicula) > COUNT(*)) AS a);
 /*Son los alquileres, no las copias de las pelis lo que se usa, la tengo bien*/

/*26. (*** Opcional) Insertar en la tabla socio_vip todos los datos del socio que más número de alquileres tenga en
el último trimestre del año 2014 insertando en el campo trim_anyo_vip el valor "TRIM4_2014".*/
INSERT INTO socio_vip SELECT num_socio, nombre, apellido1, apellido2, telefono, domicilio, poblacion, fec_nac, 'TRIM4_2014' FROM socio 
WHERE num_socio IN (
	SELECT socio
	FROM alquiler
	GROUP BY socio
	HAVING COUNT(*) = (SELECT MAX(cuenta2)
								FROM alquiler JOIN (SELECT socio, COUNT(*) AS cuenta2
															FROM alquiler
                                                            WHERE fec_alquila BETWEEN '2014/10/01' AND '2014/12/31'
															GROUP BY socio) AS tabla1 ON (tabla1.socio = alquiler.socio)));

/*27. ¿Qué son las propiedades ACID?*/
-- Son las transacciones que garantizan que las transacciones se puedan realizar en una base de datos de forma segura.

/*28. ¿Cuáles son los cuatro problemas de concurrencia en el acceso a datos que pueden suceder cuando se realizan
transacciones? Poner un ejemplo para cada uno de ellos.*/
-- 1. Pérdida de actualizaciones. Cuando se lee la misma entrada en 2 transacciones y ambas la modifican.
-- 2. Lecturas sucias. Cuando se actualiza una entrada en una transacción, y en otra se selecciona esa entrada, 
    -- haciendo que la transacción 2 lea datos que pueden ser descartados
-- 3. Lecturas no repetibles. Cuando una transacción consula la misma entrada 2 veces y recibe datos distintos debido a una modificación en otra transacción.
-- 4. Lecturas fantasma. Cuando una transacción consulta un conjunto de entradas 2 veces, y a la segunda encuentra más entradas debido a una inserción en la transacción 2.

/*29. Cuando se trabaja con transacciones, el SGBD puede bloquear conjuntos de datos para evitar o permitir que
sucedan los problemas de concurrencia comentados en el ejercicio anterior. ¿Cuáles son los cuatro niveles de
aislamiento que se pueden solicitar al SGBD?*/
-- Lectura no confirmada, Lectura confirmada, Lectura repetible y Lectura serializable.

/* 30. ¿Cuál es el nivel de aislamiento que se usa por defecto en las tablas InnoDB de MariaDB? ¿Es posible realizar
transacciones sobre tablas MyISAM de MariaDB? */
-- La lectura repetible.

/*31. Basándose en el siguiente esquema:
Reflexionar sobre las siguientes cuestiones:
    a) Cuando un cliente alquila una o varias películas, hay que registrar este hecho en la tabla préstamo
        (PRESTEC), así como crear una nueva factura (FACTURA) con los correspondientes detalles de factura
        en la tabla DETALLFACTURA. ¿Por qué es interesante definir una transacción que haga este conjunto de
        operaciones en una unidad?
        -- Porque si falla la inserción en alguna de las tablas, no se inserta en ninguna.

    b) ¿Cuáles deben ser las operaciones previas a la ejecución de una transacción como la diseñada?
    -- Bloquear las entradas que se va a utilizar con FOR UPDATE y verificar que no existen las que se van a introducir.

    c) ¿Cuáles deben ser las operaciones a ejecutar al finalizar la transacción?
    -- Si todo va bien COMMIT, y si algo falla, ROLLBACK.

    d) ¿Qué otras operaciones se podrían agrupar a través de transacciones para garantizar la consistencia?
    -- 

Crear el esquema de la transacción, e indicar las sentencias SQL que contendría y el orden de ejecución.*/
START TRANSACTION;
INSERT INTO prestec VALUES (...);
INSERT INTO factura VALUES (...);
INSERT INTO detallfactur VALUES (...);
COMMIT;

/* 32. Considerar que se tiene una tabla donde se almacena información sobre cuentas bancarias definida de la
Suponer que se quiere realizar una transferencia de dinero entre dos cuentas bancarias con la siguiente
transacción:
    a) ¿Qué ocurriría si el sistema falla o si se pierde la conexión entre el cliente y el servidor después de
        realizar la primera sentencia UPDATE?
        -- Al ser una transacción, si no se completa, se descartan los cambios.

    b) ¿Qué ocurriría si no existiese alguna de las dos cuentas (id = 20 o id = 30)?
    -- Daría un fallo, y al tener un fallo, la transacción llegaría al ROLLBACK por el try catch.

    c) ¿Qué ocurriría en el caso de que la primera sentencia UPDATE falle porque hay menos de 100 € en la
        cuenta y no se cumpla la restricción del CHECK establecida en la tabla?
        -- Lo mismo de antes, al ser un fallo, se hace ROLLBACK.


Para conocer el número de visitas a ciertas páginas de un sitio web, se
utiliza una tabla en una BD de MariaDB en la que se almacena el identificador
de cada página, un nombre simbólico de la página y el número de visitas que
recibe. Cada vez que un usuario accede a una página, se debe incrementar el
número de visitas correspondiente. El esquema relacional y una posible
extensión inicial son las que pueden ver en la imagen: */

/* 33. Crear una tabla en MariaDB acorde al enunciado y al esquema relacional de la imagen. Utilizar una secuencia
autonumérica para la columna id y usar valores por defecto (0) para la columna contador. */
CREATE TABLE paginas (
    id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(20) NOT NULL,
    contador INT UNSIGNED DEFAULT 0
);

/* 34. Insertar los datos que se muestran en la imagen usando el código más simple posible, aprovechando que el
campo id es autonumérico y que el campo contador puede tomar valores por defecto (insertar filas asignando
valores sólo a la columna nombre). */
INSERT INTO paginas(nombre) VALUES ('Portada'), ('Noticias'), ('Resumen'), ('Comentarios'), ('Eventos');

/* 35. Abrir una terminal y HeidiSQL e iniciar sesión desde ambas aplicaciones. Seleccionar la BD donde se ha creado
la tabla y seguidamente cambiar el nivel de aislamiento a READ COMMITTED mediante la siguiente sentencia:
SET SESSION TRANSACTION ISOLATION LEVEL READ COMMITTED;
START TRANSACTION;
Escoger cualquiera de las páginas insertadas en el ejercicio anterior y ejecutar la siguiente sentencia:
SELECT contador FROM paginas WHERE id = <id_página_seleccionada>;
El objetivo es que desde cada una de las sesiones se sume al valor leído en la consulta anterior un número
distinto (por ejemplo, desde la terminal se suma 100 y desde HeidiSQL se le suma 200). Actualizar desde cada
sesión los datos con la siguiente sentencia:
UPDATE paginas set contador = <nuevo_valor> WHERE id = <id_página_seleccionada>;
COMMIT;
¿Hay pérdida de actualizaciones? ¿es esto un problema? */
-- No, no hay y si podría ser un porblema, aunque los SGBD tienen mecanismos de control que lo evitan.

/* 36. Repetir el ejercicio anterior pero esta vez, cambiar la sentencia SELECT por:
SELECT contador FROM paginas WHERE id = <id_página_seleccionada> FOR UPDATE;
¿Sigue habiendo pérdida de actualizaciones? ¿qué ocurre? ¿por qué? */
-- En la transacción 2 se queda esperando a que se haga el COMMIT de la transacción 1 porque esa entrada está bloqueada por el FOR UPDATE.

/* 37. Volver a hacer el ejercicio 35 pero esta vez sin utilizar la cláusula FOR UPDATE en el SELECT y cambiar la
primera sentencia por la siguiente:
SET SESSION TRANSACTION ISOLATION LEVEL SERIALIZABLE;
¿Sigue habiendo pérdida de actualizaciones? ¿qué ocurre? ¿por qué? */
-- No. Se produce un deadlock porque una transacción intenta acceder a la entrada que tiene bloqueada la otra y viceversa.


/* 38. Cambiar el nivel de aislamiento a READ COMMITTED. Ejecutar las siguientes transacciones (lecturas sucias):
¿Hay lecturas sucias en la transacción 2? ¿y si se cambia el ROLLBACK final de la transacción 1 por un COMMIT? */
-- No hay lectura sucia en el nivel READ COMMITED. Si se cambia el ROLLBACK por un COMMIT, el resultado final es igual porque la transacción 2 se queda
-- bloqueada hasta que la transacción 1 termina.

/* 39. Volver a repetir el ejercicio anterior usando en ambas transacciones SELECT ... FOR UPDATE. ¿Qué ocurre?
¿por qué? */
-- La transacción 2 espera a que la transacción 1 termine porque la entrada está bloqueada a cambios por el FOR UPDATE.

/* 40. Volver a repetir el ejercicio 38 sin utilizar la cláusula SELECT ... FOR UPDATE y cambiar el nivel de aislamiento
a SERIALIZABLE. ¿Qué ocurre? ¿por qué? */
-- Lo mismo, la transacción 2 espera a que se desbloqueen las entradas.

/* 41. Cambiar el nivel de aislamiento a READ COMMITTED. Ejecutar las siguientes transacciones (lectura no
repetible):
¿Son las dos lecturas de la transacción 1 iguales? ¿Por qué? */
-- No, porque al ser lectura confirmada y la transacción 2 haber confirmado su actualización, la transacción 1 lee los datos modificados por la transacción 2.

/* 42. Volver a repetir el ejercicio anterior usando nivel de aislamiento SERIALIZABLE. ¿Qué ocurre? ¿por qué? */
-- Se lee lo mismo en ambas consultas de la transacción 1 porque una vez que se han leido datos, no se pueden mostrar otros datos en esa transacción en el nivel serializable.

/* 43. Cambiar el nivel de aislamiento a READ COMMITTED. Ejecutar cada una de las transacciones siguientes (lectura
fantasma):
¿Son las dos lecturas de la transacción 1 iguales? ¿aparece la fila fantasma? ¿por qué? */
-- No son iguales porque este nivel de aislamiento no controla si se añaden o se eliminan filas mediante otra transacción mientras se ejecuta la primera.

/* 44. Volver a repetir el ejercicio anterior usando el nivel de aislamiento SERIALIZABLE. ¿Qué ocurre? ¿por qué? */
-- No se muestran las filas fantasma porque el nivel serializable evita que se muestren las filas nuevas durante la transacción.