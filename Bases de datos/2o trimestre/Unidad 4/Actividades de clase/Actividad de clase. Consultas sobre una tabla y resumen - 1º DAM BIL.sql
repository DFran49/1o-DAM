/*1. Devolver un listado con los distintos estados por los que puede pasar un pedido
ordenados de forma descendente.
*/
SELECT DISTINCT estado
FROM pedido
ORDER BY estado DESC;

/*2. Devolver un listado con el nombre, apellidos (concatenar
apellido1 y apellido2 haciendo el tratamiento de valores NULL
para que en caso de no tenerse el apellido2 se muestre
únicamente el apellido1) y email de los empleados que sean
“Director Oficina” y cuya oficina se encuentre en España (el
código oficina debe terminar en "-ES"). Ordenar el listado por los apellidos de forma ascendente.
*/
SELECT nombre, CONCAT_WS(" ", apellido1, apellido2) AS apellidos, email
FROM empleado
WHERE puesto = 'Director Oficina'AND codigo_oficina LIKE '%-ES';

/*3. Devolver un listado con el nombre, gama y cantidad en stock de los productos cuya descripción sea
nula y el precio de venta mayor que 4. Asignar el alias
“Cantidad en stock” a la columna cantidad_en_stock.
Ordenar el resultado de forma ascendente por el
nombre del producto y seguidamente por el stock
disponible de forma descendente. Limitar los
resultados devueltos a 5 comenzando a recuperar los
registros devueltos desde la cuarta fila.
*/
SELECT nombre, gama, cantidad_en_stock AS 'Cantidad en stock'
FROM producto
WHERE descripcion IS NULL
ORDER BY nombre, 'Cantidad en stock' DESC
LIMIT 5 OFFSET 3;

/*4. Devolver un listado con el nombre y el beneficio incrementado en un 21% de
los productos de la gama “Frutales”. El beneficio se puede obtener mediante
precio_venta – precio_proveedor. El beneficio incrementado se debe mostrar
con dos decimales redondeando al alza o la baja según sea necesario seguido
del símbolo “ €”. Asignar el alias “Beneficio” a la columna obtenida. Ordenar
el resultado por el campo beneficio de forma descendente (no se debe tener
en cuenta el símbolo €, únicamente el valor numérico resultante). Limitar el
resultado a los cinco primeros resultados obtenidos.
*/
SELECT nombre, CONCAT_WS(" ", ROUND((precio_venta - precio_proveedor) * 1.21, 2), '€') AS Beneficio
FROM producto
WHERE gama = 'Frutales'
ORDER BY (precio_venta - precio_proveedor) * 1.21 DESC
LIMIT 5;

/*5. Devolver un listado con el nombre (completar con # si no llega a 10 caracteres), apellidos (hacer el
tratamiento de valores NULL) y puesto de aquellos empleados que no sean representantes de ventas
ni directores de oficina (no se pueden utilizar los operadores
lógicos AND y OR para esta primera condición) y cuyo
apellido1 su segundo carácter contenga una “o”. Pasar a
mayúsculas todos los valores de las columnas del listado.
Ordenar el listado por puesto de forma ascendente.
*/
SELECT UPPER(RPAD(nombre,10,'#')), CONCAT_WS(' ', UPPER(apellido1), UPPER(apellido2)) AS apellidos, UPPER(puesto)
FROM empleado
WHERE puesto NOT IN ('Representante Ventas', 'Director Oficina') AND apellido1 LIKE '_o%'
ORDER BY puesto;

/*6. Devolver un listado con el código de pedido, id de cliente, nombre del mes de la fecha de entrega en
español, fecha esperada y fecha de entrega de los pedidos cuya fecha de entrega haya sido al menos
dos días antes de la fecha esperada (>2) y tenga
comentarios. Ordenar el listado por la fecha de
entrega de forma descendente. Las fechas se
deben mostrar en el formato “dd-mm-YYYY”.
Asignar alias a las columnas fecha y a la columna
que muestra el nombre del mes.
*/
SET @@lc_time_names = "es_ES";
SELECT codigo_pedido, id_cliente, MONTHNAME(fecha_entrega) AS Mes, DATE_FORMAT(fecha_esperada, '%d-%m-%Y') AS 'Fecha esperada', DATE_FORMAT(fecha_entrega, '%d-%m-%Y') AS 'Fecha entrega'
FROM pedido
WHERE DATEDIFF(fecha_esperada, fecha_entrega) > 2 AND comentarios IS NOT NULL
ORDER BY fecha_entrega DESC;

/*7. Devolver un listado con el id de cliente y el total de pagos (suma de todos los
pagos realizados) de aquellos clientes que realizaron algún pago en 2008. Tener
en cuenta que únicamente se tendrán que mostrar aquellos resultados en los que
el total de pagos realizados en el 2008 sea mayor o igual a 4000. Ordenar el listado
por el total de pagos realizados de forma descendente.
*/
SELECT id_cliente, SUM(total) AS Total
FROM pago
WHERE YEAR(fecha_pago) = 2008
GROUP BY id_cliente
HAVING Total >= 4000
ORDER BY Total DESC;

/*8. Obtener el número de pedidos que fueron realizados en el 2009 y rechazados
por cada cliente. Ordenar el resultado por el número de pedidos rechazados de
forma descendente y seguidamente por el id de cliente de forma ascendente.
Asignar el alias "Pedidos rechazados" al recuento por cliente realizado.
*/
SELECT id_cliente, COUNT(estado) AS 'Pedidos rechazados'
FROM pedido
WHERE estado = 'Rechazado' AND YEAR(fecha_pedido) = 2009
GROUP BY id_cliente
ORDER BY COUNT(estado) DESC, id_cliente;

/*9. Devolver un listado con el número de pedidos que han sido realizados en el
mes de enero de cualquier año, cuyo estado sea entregado y no tengan
comentarios. Ordenar el resultado por el año de forma ascendente.
*/
SELECT YEAR(fecha_pedido) AS Año, COUNT(*) AS Pedidos
FROM pedido
WHERE estado = 'Entregado' AND comentarios IS NULL AND MONTH(fecha_pedido) = 1
GROUP BY Año
ORDER BY Año;

/*10. Devolver un listado con el total de pagos realizados por cliente mediante PayPal
entre el 08/01/2007 y el 16/02/2009 (ambas fechas incluidas) cuyo acumulado se
encuentre comprendido entre 5000 y 15000 (ambos importes incluidos). Ordenar
el resultado de mayor a menor acumulado.
*/
SELECT id_cliente, SUM(total) AS Acumulado
FROM pago
WHERE (fecha_pago BETWEEN '2007-01-08' AND '2009-02-16') AND forma_pago = 'PayPal' 
GROUP BY id_cliente
HAVING Acumulado BETWEEN 5000 AND 15000
ORDER BY Acumulado DESC;

/*11. Calcular la fecha del primer y último pago realizado por cada uno
de los clientes. Las fechas se deben mostrar en el formato “01 de
ene de 2009” (no importa que las iniciales del nombre del mes
salgan en inglés, aunque e puede conseguir que salgan en español
ejecutando antes SET @@lc_time_names = "es_ES";).
*/
SELECT id_cliente, DATE_FORMAT(MAX(fecha_pago), '%d de %b de %Y') AS 'Último pago', DATE_FORMAT(MIN(fecha_pago), '%d de %b de %Y') AS 'Primer pago'
FROM pago
GROUP BY id_cliente;

/*12. La facturación que ha tenido la empresa en toda la historia por producto, teniendo en cuenta que los
productos deben empezar por OR, indicando la base imponible, el IVA y el total facturado. La base
imponible se calcula sumando el coste del producto por el número de unidades vendidas de la
tabla detalle_pedido. El IVA es el 21 % de la base imponible, y el
total la suma de los dos campos anteriores. Redondear los
importes a dos decimales y asignarles alias a los campos
calculados. Hacer que únicamente se muestren aquellos
productos cuya facturación total en toda la historia sea superior
a 200. Ordenar de mayor a menor por el total facturado. Limitar
las filas mostradas a las 5 primeras.
*/
SELECT codigo_producto, ROUND(SUM(cantidad * precio_unidad), 2) AS 'Base imponible', ROUND(SUM(cantidad * precio_unidad) * 0.21,2) AS '21% IVA', 
    ROUND(SUM(cantidad * precio_unidad) * 1.21, 2) AS Total
FROM detalle_pedido
WHERE codigo_producto LIKE 'OR%'
GROUP BY codigo_producto
HAVING Total > 200
ORDER BY Total DESC
LIMIT 5;