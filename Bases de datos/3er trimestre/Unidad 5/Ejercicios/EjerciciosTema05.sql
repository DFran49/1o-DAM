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