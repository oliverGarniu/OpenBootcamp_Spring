Ejercicios sesiones 1, 2 y 3

Ejercicio 1:
Crear proyecto maven con la dependencia spring-context y crear una clase Saludo con un metodo imprimirSaludo que imprima un texto por consola.
Crear el archivo beans.xml con un bean para la clase Saludo.
Obtener el bean desde el metodo main y ejecutar el m\'e9todo imprimirSaludo.


Ejercicio 2:
Crear la clase NotificationService, con un metodo que imprima un saludo.
Crear una clase UserService que tenga un atributo de clase NotificationService.
Utilizar la anotacion @Component en cada clase.
Habilitar el escaneo de clases en el archivo beans.xml
Desde el metodo main, probar a obtener el bean UserService y ejecutar el metodo imprimirSaludo que tiene asociado el atributo de tipo NotificationService. De forma similar a la realizada en clase.


Ejercicio 3:
Crear un proyecto Spring Boot con las dependencias:
En caso de querer que la base de datos se guarde en disco habra que añadir las siguientes propiedades en el archivo application.properties:
spring.jpa.show-sql=true
spring.datasource.url=jdbc:h2:file:C:/data/sample
spring.datasource.username=sa
spring.datasource.password=
spring.datasource.driverClassName=org.h2.Driver
#spring.jpa.hibernate.ddl-auto=create
spring.jpa.hibernate.ddl-auto=update
spring.sql.init.mode=always
spring.jpa.defer-datasource-initialization=true
