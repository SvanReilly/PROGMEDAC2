DROP DATABASE IF EXISTS pruebashibernate;
CREATE SCHEMA pruebashibernate;

USE pruebashibernate;
CREATE TABLE EMPLEADOS (
Id INT UNIQUE PRIMARY KEY AUTO_INCREMENT,
Nombre VARCHAR(150) NOT NULL DEFAULT "CLIENTE" ,
Salario_Mensual VARCHAR(250) NOT NULL DEFAULT '18000'
);

INSERT INTO EMPLEADOS (NOMBRE, SALARIO_MENSUAL) 
VALUES ('Aaron Rodriguez', '15000$');


select * from empleados;