USE SAKILA;
/* COMENTARIO EN BLOQUE */
# COMENTARIO EN LINEA
-- COMENTARIO EN LINEA

# Ejercicio 1: Muestra el nombre y apellido de todos los actores.
SELECT FIRST_NAME, LAST_NAME FROM ACTOR;
# Ejercicio 2: Actores que tienen de primer nombre ‘Scarlett’.
SELECT * FROM ACTOR WHERE FIRST_NAME="Scarlett";
# Ejercicio 3: Actores que tienen de apellido ‘Johansson’.
SELECT * FROM ACTOR WHERE LAST_NAME="Johansson";
#Ejercicio 4: Muestra el nombre y apellido de cada actor en una sola
-- columna, en mayúscula. Nombra la columna "Nombre del actor".
SELECT UPPER(CONCAT(FIRST_NAME, " ", LAST_NAME)) AS NOMBRE_DEL_ACTOR FROM ACTOR;
# Ejercicio 5: Actores que contengan una ‘O’ en su nombre.
SELECT * FROM ACTOR WHERE FIRST_NAME LIKE "%O%";
# Ejercicio 6: Actores que contengan una ‘O’ en su nombre y en una ‘A’ en su apellido
SELECT * FROM ACTOR WHERE FIRST_NAME LIKE "%O%" AND LAST_NAME LIKE "%A%";
# Ejercicio 7: Ciudades que empiezan por ‘a’.
SELECT * FROM CITY WHERE CITY LIKE "A%";
# Ejercicio 8: Ciudades que acaban por ‘s’.
SELECT * FROM CITY WHERE CITY LIKE "%S";
# Ejercicio 9: Actores que contengan dos ‘O’ en su nombre y en una ‘A’ en su apellido.
SELECT * FROM ACTOR WHERE FIRST_NAME LIKE "%O%O%" AND LAST_NAME LIKE "%A%";
# Ejercicio 10: Muestra el ID, nombre y apellido de un actor, de quien solo tienes el nombre "Joe".
SELECT CONCAT("ID: ", ACTOR_ID, " NOMBRE COMPLETO: " , FIRST_NAME, " ", LAST_NAME) AS ACTORES_JOE FROM ACTOR  WHERE FIRST_NAME LIKE "JOE";
SELECT ACTOR_ID, FIRST_NAME, LAST_NAME FROM ACTOR WHERE FIRST_NAME LIKE "JOE";
# Ejercicio 11: Actores donde la tercera letra de su nombre sea ‘B’.
SELECT CONCAT(FIRST_NAME, " " , LAST_NAME) AS ACTORES_NOMBRE_CON_B FROM ACTOR WHERE FIRST_NAME LIKE "__B%";
# Ejercicio 12: Encuentra los actores cuyo apellido contenga "GEN".
SELECT CONCAT(FIRST_NAME, " ", LAST_NAME) AS ACTORES_APELLIDO_GEN FROM ACTOR WHERE LAST_NAME LIKE "%GEN%";
# Ejercicio 13: Ciudades de ‘Spain’.
SELECT * FROM CITY WHERE COUNTRY_ID= 87;
# Ejercicio 14: Ciudades con nombres compuestos
SELECT * FROM CITY WHERE CITY LIKE "% %";
# Ejercicio 15: Encuentra los actores cuyo apellido contenga "LI". Ordena
-- las filas por apellido y nombre (en ese orden).
SELECT LAST_NAME AS APELLIDO, FIRST_NAME AS NOMBRE FROM ACTOR WHERE LAST_NAME LIKE "%LI%" ORDER BY APELLIDO AND NOMBRE ASC; 
# Ejercicio 16: Usando la función IN, muestra el nombre y apellido de todos los clientes 
-- llamados "Terry", "Jessie" o "Alice".
SELECT FIRST_NAME AS NOMBRE, LAST_NAME AS APELLIDO FROM CUSTOMER WHERE FIRST_NAME IN ('TERRY', 'JESSIE', 'ALICE');
# Ejercicio 17: Muestra el apellido de cada actor y la cantidad de actores que tienen ese apellido.
SELECT LAST_NAME AS APELLIDO, COUNT(LAST_NAME) AS REPETICIONES FROM ACTOR GROUP BY LAST_NAME ORDER BY REPETICIONES DESC;
# Ejercicio 18: Muestra el apellido y la cantidad de actores que tienen ese apellido, 
-- pero solo los apellidos compartidos por dos o más actores.
SELECT LAST_NAME AS APELLIDO, COUNT(LAST_NAME) AS REPETICIONES_COMPARTIDAS FROM ACTOR GROUP BY LAST_NAME HAVING COUNT(LAST_NAME)>=2 ORDER BY REPETICIONES_COMPARTIDAS DESC;
# Ejercicio 19: Usando joins, muestra el nombre, apellido y dirección de cada miembro del staff.
SELECT S.FIRST_NAME, S.LAST_NAME, A.ADDRESS FROM STAFF S 
JOIN ADDRESS A ON S.ADDRESS_ID = A.ADDRESS_ID;
# Ejercicio 20: Muestra el total de dinero recaudado por cada empleado durante agosto del 2005.
SELECT S.STAFF_ID, S.FIRST_NAME, S.LAST_NAME, CONCAT(SUM(P.AMOUNT),"$") AS TOTAL_RECAUDADO FROM PAYMENT P
JOIN STAFF S ON P.STAFF_ID = S.STAFF_ID WHERE P.PAYMENT_DATE >= '2005-08-01' AND P.PAYMENT_DATE < '2005-09-01'
GROUP BY S.STAFF_ID;
# Ejercicio 21: ¿Cuántas copias hay en inventario en el sistema de la película "Hunchback Impossible"?
SELECT COUNT(*) FROM INVENTORY I
JOIN FILM F ON F.FILM_ID=I.FILM_ID WHERE F.TITLE LIKE 'Hunchback Impossible';
# Ejercicio 22: Películas con una duración entre 80 y 100.
SELECT TITLE AS PELICULAS, LENGTH AS DURACION FROM FILM WHERE LENGTH BETWEEN 80 AND 100 ORDER BY LENGTH DESC;
# Ejercicio 23: Películas con un título de más de 12 letras.
SELECT TITLE AS PELICULAS FROM FILM WHERE LENGTH(TITLE)>12 ORDER BY TITLE ASC;
# Ejercicio 24: Peliculas con un rating PG y duracion de más de 120.
SELECT TITLE AS PELICULAS, RATING AS RATING, LENGTH AS DURACION FROM FILM WHERE RATING LIKE "PG" AND LENGTH > 120 ORDER BY TITLE ASC;
# Ejercicio 25: Muestra el total de dinero pagado por cada cliente, solo si ha realizado compras. 
-- Ordena los clientes por apellido de forma ascendente.
SELECT C.FIRST_NAME AS NOMBRE, C.LAST_NAME AS APELLIDO, SUM(P.AMOUNT) AS MONTO_TOTAL FROM CUSTOMER C 
JOIN PAYMENT P ON C.CUSTOMER_ID = P.CUSTOMER_ID GROUP BY C.CUSTOMER_ID ORDER BY C.LAST_NAME ASC;
# Ejercicio 26: Se debe realizar una campaña de marketing en Canadá.
-- Para esto necesitas el nombre y correo electrónico de todos los 
-- clientes canadienses. Despliega esta información.
SELECT CUSTOMER_ID AS ID, FIRST_NAME AS NOMBRE, LAST_NAME AS APELLIDO, EMAIL, CO.COUNTRY AS PAIS FROM CUSTOMER CU 
LEFT JOIN ADDRESS AD ON CU.ADDRESS_ID = AD.ADDRESS_ID
JOIN CITY CY ON AD.CITY_ID = CY.CITY_ID
RIGHT JOIN COUNTRY CO ON CY.COUNTRY_ID = CO.COUNTRY_ID WHERE COUNTRY = "CANADA"
ORDER BY CUSTOMER_ID ASC;

#Ejercicio 27: Identifica todas las películas categorizadas como familiares (categoría "family").
SELECT F.TITLE AS TITULO, CA.NAME AS CATEGORIA FROM FILM F
LEFT JOIN FILM_CATEGORY FC ON F.FILM_ID = FC.FILM_ID
RIGHT JOIN CATEGORY CA ON CA.CATEGORY_ID = FC.CATEGORY_ID
WHERE CA.NAME LIKE "FAMILY";
#Ejercicio 28: Muestra las películas más alquiladas en orden descendente.

#Ejercicio 29: Muestra el dinero recaudado por cada tienda.

#Ejercicio 30: Media de duración de películas con PG.

#Ejercicio 31: Películas con mayor y con menor duración.

#Ejercicio 32: Media de duración de las películas de cada categoría.

#Ejercicio 33: Identifica todas las películas categorizadas como familiares (categoría "family").

