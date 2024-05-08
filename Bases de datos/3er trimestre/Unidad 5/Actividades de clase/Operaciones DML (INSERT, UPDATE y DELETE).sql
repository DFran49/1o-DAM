/*1. Insertar una oficina con sede en Granada y tres empleados que sean representantes de
ventas y dependan del empleado Alberto Soria Carrasco.*/
INSERT INTO oficina VALUES ('GND-ES', 'Granada', 'España', 'Granada', '18014', '+34 96 6666666', 'Camino de Ronda, 14', NULL);
INSERT INTO empleado VALUES (32, 'Rodrigo', 'Juarez', NULL, '8175', 'rodjuar@gmail.com', 'GND-ES', 3, 'Representante Ventas'),
    (33, 'Alba', 'Ramirez', NULL, '3471', 'albram@gmail.com', 'GND-ES', 3, 'Representante Ventas'),
    (34, 'Julián', 'Lozano', NULL, '9146', 'julloz@gmail.com', 'GND-ES', 3, 'Representante Ventas');


/*2. Insertar tres clientes que tengan como representantes de ventas los empleados que se han
creado en el ejercicio anterior (cada uno de los clientes dependerá de uno de los
empleados).*/
INSERT INTO cliente VALUES (39, "Pierres's",NULL, NULL, '666666666', '999999999', 'Av. de la Libertad, 53', NULL, 'Cuenca', NULL, NULL, NULL, 32, NULL),
    (40, "Manolo's flowers",NULL, NULL, '444444444', '333333333', 'Calle simple, 12', NULL, 'Burgos', NULL, NULL, NULL, 33, NULL),
    (41, "Flowers Flores",NULL, NULL, '777777777', '888888888', 'Av de Cristo, 98', NULL, 'Zaragoza', NULL, NULL, NULL, 34, NULL);


/*3. Insertar un pedido para cada uno de los clientes creados en el ejercicio anterior. Cada
pedido debe incluir al menos dos productos distintos (detalle_pedido).*/
INSERT INTO pedido VALUES (129, '2024-04-18', '2024-04-23', NULL, 'Pendiente', NULL, 39),
                        (130, '2024-04-15', '2024-04-16', '2024-04-16', 'Entregado', NULL, 40),
                        (131, '2024-04-21', '2024-04-27', NULL, 'Pendiente', NULL, 41);

INSERT INTO detalle_pedido VALUES (129, '30310', 5, 10.5, 1),
                                    (129, 'OR-001', 2, 90.5, 2),
                                    (130, 'OR-212', 7, 22.5, 1),
                                    (130, 'OR-160', 9, 83.7, 2),
                                    (131, 'OR-217', 52, 6.5, 1),
                                    (131, 'FR-15', 31, 67.2, 2);


/*4. Intentar actualizar el código (id_cliente en la tabla cliente) de uno de los clientes creados y
comprobar si se puede. Si la actualización de su código de identificación falló, modificar las
tablas necesarias estableciendo la clave foránea con la cláusula ON UPDATE CASCADE para
que se permita la actualización en cascada (puede ser necesario realizar cambios en varias
tablas). Volver a intentar la actualización.*/
ALTER TABLE pago
	DROP FOREIGN KEY pago_ibfk_1;
ALTER TABLE pago
	ADD CONSTRAINT pago_ibfk_1 FOREIGN KEY (id_cliente) REFERENCES cliente (id_cliente) ON UPDATE CASCADE;
ALTER TABLE pedido
	DROP FOREIGN KEY pedido_ibfk_1;
ALTER TABLE pedido
	ADD CONSTRAINT pedido_ibfk_1 FOREIGN KEY (id_cliente) REFERENCES cliente (id_cliente) ON UPDATE CASCADE;
UPDATE cliente SET id_cliente = 45 WHERE id_cliente = 40;


/*5. Intentar borrar uno de los clientes creados y comprobar si se puede. Si no fuese posible,
modificar las tablas necesarias estableciendo la clave foránea con la cláusula ON DELETE
CASCADE. Volver a intentar el borrado.*/
ALTER TABLE pago
	DROP FOREIGN KEY pago_ibfk_1;
ALTER TABLE pago
	ADD CONSTRAINT pago_ibfk_1 FOREIGN KEY (id_cliente) REFERENCES cliente (id_cliente) ON DELETE CASCADE;
ALTER TABLE pedido
	DROP FOREIGN KEY pedido_ibfk_1;
ALTER TABLE pedido
	ADD CONSTRAINT pedido_ibfk_1 FOREIGN KEY (id_cliente) REFERENCES cliente (id_cliente) ON DELETE CASCADE;
ALTER TABLE detalle_pedido
	DROP FOREIGN KEY detalle_pedido_ibfk_1;
ALTER TABLE detalle_pedido
	ADD CONSTRAINT detalle_pedido_ibfk_1 FOREIGN KEY (codigo_pedido) REFERENCES pedido (codigo_pedido) ON DELETE CASCADE;
DELETE FROM cliente WHERE id_cliente = 45;


/*6. Realizar los pagos de los pedidos que han realizado los clientes creados que no hayan sido
borrados (los insertados en el ejercicio 3 y no se hayan eliminado en el ejercicio 5).*/
INSERT INTO pago VALUES (39, 'PayPal', 'ak-std-000026', '2024-04-18', (SELECT SUM(total)
                                                                FROM (SELECT cantidad*precio_unidad AS total
                                                                    FROM pedido JOIN detalle_pedido USING (codigo_pedido)
                                                                    WHERE id_cliente = 39) AS c));
INSERT INTO pago VALUES (41, 'Transferencia', 'ak-std-000027', '2024-04-21', (SELECT SUM(total)
                                                                FROM (SELECT cantidad*precio_unidad AS total
                                                                    FROM pedido JOIN detalle_pedido USING (codigo_pedido)
                                                                    WHERE id_cliente = 41) AS c));


/*7. Eliminar los clientes que no hayan realizado ningún pedido. ¿Se puede? ¿Por qué?*/
DELETE FROM cliente WHERE id_cliente IN (SELECT id_cliente
                                            FROM cliente
                                            WHERE id_cliente NOT IN (SELECT id_cliente
                                                                        FROM pedido));


/*8. Reducir en un 20% el precio de venta de los productos que no tengan pedidos.*/
UPDATE producto SET precio_venta = precio_venta*0.80 WHERE codigo_producto IN (SELECT codigo_producto
                                                                                FROM producto
                                                                                WHERE codigo_producto NOT IN (SELECT codigo_producto
                                                                                                                FROM detalle_pedido));

/*9. Borrar los pagos del cliente con menor límite de crédito. ¿Se puede?*/
DELETE FROM pago WHERE id_cliente = (SELECT id_cliente
                                        FROM cliente
                                        WHERE limite_credito = (SELECT  MIN(limite_credito)
                                                                            FROM cliente));
-- Si se puede porque no hay ninguna FK que use campos de la tabla pago


/*10. Borrar el cliente que menor límite de crédito tenga. ¿Es posible borrarlo? ¿Por qué́?*/
DELETE FROM cliente WHERE id_cliente = (SELECT id_cliente
                                        FROM cliente
                                        WHERE limite_credito = (SELECT  MAX(limite_credito)
                                                                            FROM cliente));
-- Si se puede porque anteriormente se ha modificado para que al borrar de la tabla 
-- cliente se borre en las tablas que tienen FKs de la tabla cliente


/*11. Añadir un campo numérico llamado IVA a la tabla detalle_pedido. Establecer el valor de ese
campo a 18 para aquellos registros cuyo pedido tenga una fecha de pedido anterior al 1 de
septiembre de 2012. A continuación actualizar el resto de pedidos estableciendo el IVA al
21 (proponer y ejecutar la sentencia aunque no haya registros que cumplan la condición).*/
ALTER TABLE detalle_pedido
	ADD COLUMN IVA INT UNSIGNED NULL AFTER numero_linea;
UPDATE detalle_pedido SET IVA = 18 WHERE codigo_pedido IN (SELECT codigo_pedido
                                                            FROM pedido
                                                            WHERE fecha_pedido < '2012-09-01');
UPDATE detalle_pedido SET IVA = 21 WHERE IVA IS NULL;


/*12. Añadir a la tabla detalle_pedido un nuevo campo numérico (que permita guardar dos
decimales) llamado total_linea y actualizar todos sus registros para calcular su valor con la
fórmula:
total_linea = precio_unidad * cantidad * (1 + (IVA / 100));*/
ALTER TABLE detalle_pedido
	ADD COLUMN total_linea DECIMAL(10,2) DEFAULT NULL AFTER IVA;
UPDATE detalle_pedido SET total_linea = ROUND(precio_unidad * cantidad * (1 + (IVA / 100)));


/*13. Establecer a 0 el límite de crédito del cliente que menos unidades pedidas tenga (en total
de todos sus pedidos) del producto 11679.*/
UPDATE cliente SET limite_credito = 0 WHERE id_cliente = (SELECT id_cliente
                                                            FROM (SELECT id_cliente, SUM(cantidad) AS totalPedidos
                                                                    FROM cliente JOIN pedido USING (id_cliente) JOIN detalle_pedido USING (codigo_pedido)
                                                                    WHERE codigo_producto = '11679'
                                                                    GROUP BY id_cliente) AS a
                                                            WHERE totalPedidos = (SELECT MIN(totalPedidos)
                                                                                            FROM (SELECT id_cliente, SUM(cantidad) AS totalPedidos
                                                                                                    FROM cliente JOIN pedido USING (id_cliente) JOIN detalle_pedido USING (codigo_pedido)
                                                                                                    WHERE codigo_producto = '11679'
                                                                                                    GROUP BY id_cliente) AS a));