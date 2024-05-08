/* 1. Realizar una consulta que devuelva el nombre de los clientes, el
código de pedido y los días de retraso de aquellos pedidos que
no han sido entregados a tiempo (fecha de entrega superior a
la fecha estimada y estado igual a entregado). Ordenar el
resultado por el código de pedido de forma ascendente. */
SELECT nombre_cliente, codigo_pedido, DATEDIFF(fecha_entrega,fecha_esperada) AS retraso
FROM cliente JOIN pedido USING (id_cliente)
WHERE fecha_entrega > fecha_esperada AND estado = 'Entregado'
ORDER BY codigo_pedido;


/* 2. Realizar una consulta que muestre el nombre de cada empleado
(aunque no tenga jefe), el nombre de su jefe y el nombre del jefe
de su jefe. En caso de no tener jefe debe mostrar el valor “SIN
JEFE”.*/
SELECT e1.nombre AS 'Nombre empleado', NVL(e2.nombre, 'SIN JEFE') AS 'Nombre jefe', NVL(e3.nombre, 'SIN JEFE') AS 'Nombre jefe del jefe'
FROM empleado AS e1 LEFT JOIN empleado AS e2 ON e2.id_empleado = e1.id_jefe LEFT JOIN empleado AS e3 ON e3.id_empleado = e2.id_jefe;


/* 3. Realizar una consulta que muestre las diferentes gamas de producto que
ha comprado cada cliente (no se deben mostrar las filas duplicadas) cuya
fecha de pedido esté comprendida entre el “10/01/2009” y el
“15/05/2009”, y el estado sea “entregado”. Ordenar los resultados por el
nombre del cliente y la gama de forma ascendente. Limitar el listado a
los 10 primeros resultados.*/
SELECT DISTINCT nombre_cliente, gama
FROM cliente JOIN pedido USING (id_cliente) JOIN detalle_pedido USING (codigo_pedido) JOIN producto USING (codigo_producto)
WHERE estado = 'Entregado' AND fecha_pedido BETWEEN '2009/01/10' AND '2009/05/15'
ORDER BY nombre_cliente, gama
LIMIT 10;


/* 4. Devolver un listado con los 20 productos más vendidos
junto al número total de unidades vendidas de aquellos
pedidos realizados entre el “01/04/2008” y el
“31/01/2009” cuyo estado se encuentre en entregado. El
listado se debe ordenar por el número total de unidades
vendidas de forma descendente.*/
SELECT nombre, SUM(cantidad) AS total_vendidos
FROM producto JOIN detalle_pedido USING (codigo_producto) JOIN pedido USING (codigo_pedido)
WHERE estado = 'Entregado' AND fecha_pedido BETWEEN '2008/04/01' AND '2009/01/31'
GROUP BY nombre
ORDER BY SUM(cantidad) DESC
LIMIT 20;


/*5. Sin hacer uso de subconsultas devolver un listado que muestre solamente
los empleados que no tienen un cliente asociado.*/
SELECT nombre, CONCAT_WS(' ', apellido1, apellido2) AS apellidos
FROM empleado LEFT JOIN cliente ON id_empleado = id_empleado_rep_ventas
WHERE id_empleado_rep_ventas IS NULL;


/*6. Devolver el nombre del cliente con menor límite de crédito de la región de
“Barcelona” (no se puede utilizar LIMIT ni ORDER BY en la sentencia SELECT).*/
SELECT nombre_cliente
FROM cliente
WHERE limite_credito = (SELECT MIN(limite_credito)
                            FROM cliente
                            WHERE region = 'Barcelona');


/*7. Devolver el nombre del producto del que se han vendido más unidades
(tener en cuenta que se tendrá que calcular cuál es el número total de
unidades que se han vendido de cada producto a partir de los datos de la
tabla detalle_pedido).*/
SELECT nombre
FROM producto JOIN (SELECT detalle_pedido.codigo_producto AS nombre1, SUM(detalle_pedido.cantidad) AS suma1
							FROM detalle_pedido
							GROUP BY detalle_pedido.codigo_producto
							HAVING SUM(detalle_pedido.cantidad) = (SELECT MAX(tabla1.suma)
													FROM detalle_pedido JOIN (SELECT codigo_producto, SUM(cantidad) AS suma
													FROM detalle_pedido
													GROUP BY codigo_producto
													ORDER BY suma DESC) AS tabla1 ON (tabla1.codigo_producto = detalle_pedido.codigo_producto))) AS tabla2 ON codigo_producto = nombre1
WHERE producto.codigo_producto = tabla2.nombre1;


/*8. Devolver un listado con los nombres de los clientes que han realizado algún
pedido pero no han realizado ningún pago. Ordenar el resultado por el nombre
de cliente de forma ascendente.*/
SELECT nombre_cliente
FROM cliente
WHERE id_cliente NOT IN (SELECT id_cliente 
							FROM pago) AND id_cliente IN (SELECT id_cliente 
															FROM pedido);


/*9. Obtener el total facturado por producto (únicamente se deben
tener en cuenta los pedidos realizados en el año 2009 y que se
encuentren en estado de entregados para el cálculo) del cliente
que tiene menor límite de crédito.*/
SELECT nombre, Facturado AS 'Total facturado'
FROM producto JOIN (SELECT codigo_producto, SUM(cantidad) * precio_unidad AS Facturado
						FROM detalle_pedido 
							JOIN (SELECT codigo_pedido AS codCorrecto, YEAR(fecha_pedido), estado
									FROM pedido
									WHERE YEAR(fecha_pedido) = 2009 
									AND estado = 'Entregado' 
									AND id_cliente = (SELECT id_cliente
														FROM cliente
														WHERE limite_credito = (SELECT MIN(limite_credito)
																					FROM cliente))) AS tabla1 ON tabla1.codCorrecto = detalle_pedido.codigo_pedido
						GROUP BY codigo_producto, precio_unidad) 
AS tabla2 USING (codigo_producto)
ORDER BY Facturado DESC;


/*10. Obtener los productos de la gama “Ornamentales” que tengan un precio de
venta mayor o igual al de todos los productos de la gama “Frutales” (no se
puede utilizar las funciones MAX y MIN, ni la cláusula ORDER BY).*/
SELECT DISTINCT nombre
FROM (SELECT nombre, precio_venta, '1' AS uno
		FROM producto
		WHERE gama = 'Ornamentales') AS ornamentales 
WHERE precio_venta >= ALL (SELECT precio_venta
							FROM producto
							WHERE gama = 'Frutales');


/*11. Obtener el nombre de los productos con mayor stock que compra un cliente
cuyo representante de ventas trabaje en la oficina de la ciudad de Madrid.*/
SELECT nombre
FROM producto
WHERE codigo_producto IN (SELECT codigo_producto
							FROM detalle_pedido JOIN (SELECT id_cliente, codigo_pedido
														FROM pedido
														WHERE id_cliente IN (SELECT id_cliente
																				FROM cliente
																				WHERE id_empleado_rep_ventas IN (SELECT id_empleado
																													FROM oficina JOIN empleado USING (codigo_oficina)
																													WHERE ciudad = 'Madrid'))) AS clientPed USING (codigo_pedido))
	AND cantidad_en_stock IN (SELECT MAX(cantidad_en_stock)
								FROM producto);


/*12. Devolver las oficinas donde no trabajan ninguno de los empleados que
hayan sido los representantes de ventas de algún cliente que haya realizado
la compra de algún producto de la gama Frutales.*/
SELECT codigo_oficina, ciudad
FROM oficina
WHERE codigo_oficina NOT IN (SELECT codigo_oficina
							FROM empleado
							WHERE id_empleado IN (SELECT id_empleado_rep_ventas
													FROM cliente
													WHERE id_cliente IN (SELECT id_cliente
																		FROM pedido JOIN detalle_pedido USING (codigo_pedido) JOIN producto USING (codigo_producto)
																		WHERE gama = 'Frutales')));