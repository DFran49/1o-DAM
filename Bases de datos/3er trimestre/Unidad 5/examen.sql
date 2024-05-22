-- 1
INSERT puestos VALUES (107, 'Prácticas');

INSERT empleados VALUES (500000, '1970-02-11', 'María', 'Ruiz Ruiz', 'F', CURDATE());

INSERT puestos_emp VALUES(500000, 107, '1970-02-11', NULL);

INSERT salarios VALUES(500000, 25000, '1970-02-11', NULL);

INSERT emp_dep VALUES(500000, 'D007', '1970-02-11', NULL);

-- 2
DELETE FROM empleados WHERE idEmp NOT IN (SELECT idEmp FROM puestos_emp)
    AND idEmp NOT IN (SELECT idEmp FROM salarios)
    AND idEmp NOT IN (SELECT idEmp FROM emp_dep);

-- 3
ALTER TABLE puestos_emp
	DROP FOREIGN KEY puestos_emp_ibfk_1;
ALTER TABLE puestos_emp
	ADD CONSTRAINT puestos_emp_ibfk_1 FOREIGN KEY (idEmp) REFERENCES empleados (idEmp) ON UPDATE CASCADE;

ALTER TABLE salarios
	DROP FOREIGN KEY salarios_ibfk_1;
ALTER TABLE salarios
	ADD CONSTRAINT salarios_ibfk_1 FOREIGN KEY (idEmp) REFERENCES empleados (idEmp) ON UPDATE CASCADE;

ALTER TABLE emp_dep
	DROP FOREIGN KEY emp_dep_ibfk_1;
ALTER TABLE emp_dep
	ADD CONSTRAINT emp_dep_ibfk_1 FOREIGN KEY (idEmp) REFERENCES empleados (idEmp) ON UPDATE CASCADE;

UPDATE empleados SET idEmp = 500001 WHERE idEmp = 500000;
-- No se puede, se debe actualizar la actualización en cascada para las cláves foráneas que usan este id.

-- 4
UPDATE departamentos SET nombreDep = CONCAT(nombreDep, '*') WHERE idDep IN (SELECT DISTINCT idDep FROM emp_dep WHERE idDep IN 
	                                                                            (SELECT idDep AS cuenta FROM emp_dep GROUP BY idDep HAVING COUNT(*) > 40000));

-- 5 
UPDATE salarios SET salario = salario*1.1 
WHERE fechaHasta IS NULL AND idEmp IN (SELECT idEmp FROM  puestos_emp JOIN empleados USING (idEmp) 
                                    WHERE fechaHasta IS NULL AND sexo = 'F' AND idPues IN 
                                        (SELECT idPues FROM puestos WHERE puesto = 'Ingeniero'));

-- 6
ALTER TABLE departamentos
	ADD COLUMN num_empleados INT UNSIGNED NULL AFTER nombreDep;

UPDATE departamentos SET num_empleados = (SELECT COUNT(*) FROM emp_dep GROUP BY idDep);

--Estas siguientes sentencias serían uno a uno.
-- UPDATE departamentos SET num_empleados = (SELECT COUNT(*) FROM emp_dep WHERE idDep = 'D001' GROUP BY idDep) WHERE idDep = 'D001';
-- UPDATE departamentos SET num_empleados = (SELECT COUNT(*) FROM emp_dep WHERE idDep = 'D002' GROUP BY idDep) WHERE idDep = 'D002';
-- UPDATE departamentos SET num_empleados = (SELECT COUNT(*) FROM emp_dep WHERE idDep = 'D003' GROUP BY idDep) WHERE idDep = 'D003';
-- UPDATE departamentos SET num_empleados = (SELECT COUNT(*) FROM emp_dep WHERE idDep = 'D004' GROUP BY idDep) WHERE idDep = 'D004';
-- UPDATE departamentos SET num_empleados = (SELECT COUNT(*) FROM emp_dep WHERE idDep = 'D005' GROUP BY idDep) WHERE idDep = 'D005';
-- UPDATE departamentos SET num_empleados = (SELECT COUNT(*) FROM emp_dep WHERE idDep = 'D006' GROUP BY idDep) WHERE idDep = 'D006';
-- UPDATE departamentos SET num_empleados = (SELECT COUNT(*) FROM emp_dep WHERE idDep = 'D007' GROUP BY idDep) WHERE idDep = 'D007';
-- UPDATE departamentos SET num_empleados = (SELECT COUNT(*) FROM emp_dep WHERE idDep = 'D008' GROUP BY idDep) WHERE idDep = 'D008';
-- UPDATE departamentos SET num_empleados = (SELECT COUNT(*) FROM emp_dep WHERE idDep = 'D009' GROUP BY idDep) WHERE idDep = 'D009';