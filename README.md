# Getting Started

Aplicación/servicio en SpringBoot que provea una endpoint rest de consulta.

Utilizar una base de datos en memoria (tipo h2).

Uso de Flyway para migraciones de bases de datos.

Uso de advice para manejo de excepciones.

Aplicar testing unitarios y de integración.

<br><br>

---


### Reference Documentation
For further reference, please consider the following sections:

* [H2 Database](https://www.baeldung.com/spring-boot-h2-database)
* [Flyway](https://www.baeldung.com/database-migrations-with-flyway)


* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.1.1/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.1.1/maven-plugin/reference/html/#build-image)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.1.1/reference/htmlsingle/#data.sql.jpa-and-spring-data)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.1.1/reference/htmlsingle/#web)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/3.1.1/reference/htmlsingle/#using.devtools)

### Guides
The following guides illustrate how to use some features concretely:

* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)


Desarrollar unos test al endpoint rest que  validen las siguientes peticiones al servicio con los datos del ejemplo:


-          Test 1: petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA)

-          Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)

-          Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)

-          Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)

-          Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)