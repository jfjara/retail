# retail test prices

# Enunciado


Construir una aplicación/servicio en SpringBoot que provea una end point rest de consulta  tal que:

 

        Acepte como parámetros de entrada: fecha de aplicación, identificador de producto, identificador de cadena.
        Devuelva como datos de salida: identificador de producto, identificador de cadena, tarifa a aplicar, fechas de aplicación y precio final a aplicar.

 

Se debe utilizar una base de datos en memoria (tipo h2) e inicializar con los datos del ejemplo, (se pueden cambiar el nombre de los campos y añadir otros nuevos si se quiere, elegir el tipo de dato que se considere adecuado para los mismos).

              

    Desarrollar unos test al endpoint rest que  validen las siguientes peticiones al servicio con los datos del ejemplo:

                                                                                       

-        Test 1: petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA)

-        Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)

-        Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)

-        Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)

-        Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)




# Características del desarrollo

Diseñar e implementación de un servicio back aplicando principios SOLID y una arquitectura hexagonal.

Se han utilizado las siguientes tecnologías

* Java 1.8
* Spring Boot 
* Swagger2  http://localhost:8080/swagger-ui.html
* Spring Data
* Arquitectura Hexagonal
* Metodología SOLID
* JUnit
* Docker
* Base de datos H2 con carga inicial de datos mediante un script



# example CURL

curl --location --request GET 'localhost:8080/api/prices/find?productId=35455&brandId=1&applicationDate=2020-06-15-21.00.00' \
--header 'Content-Type: application/json'

