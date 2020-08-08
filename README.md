# Back End Gestor de Reportes

## Inicio

Para construir esta aplicación se requieren como versiones mínimas:
 
 * Java 8
 * Maven 3
 * En modo local (dev) se requiere también una base de datos MySQL con instalación por default.

El puerto de despliegue es el default

```
8080
```

En el perfil cloud, el puerto por defecto es

```
80
```

## Perfiles

Se configuran los siguientes perfiles que permiten orientar el código hacia diferentes ambientes, según
sea el ciclo de desarrollo:

* dev           Perfil de desarrollo local(por default), utilizando la base de datos en localhost.
* bmx           Perfil de desarrollo local, utilizando la base de datos en Bluemix.
* cloud         Perfil para despliegue en servicios de tipo CloudFoundry (Bluemix).

Para hacer uso de estos perfiles en la aplicación se utilizan las siguientes instrucciones:

### Profile Dev

```
mvn spring-boot:run
```

### Profile Bmx

Este profile permite la ejecución de código localmente:

```
mvn spring-boot:run -Dspring.profiles.active=bmx
```

### Profile Cloud

Este profile normalmente sólo es utilizado desde CloudFoundry, por lo que no
tiene sentido ejecutarlo de manera local.


## Actuator

La aplicación proporciona endpoints para monitorear e interactuar con ella. Estos endpoints son proporcionados por
Spring Actuator [https://docs.spring.io/spring-boot/docs/current/reference/html/production-ready-endpoints.html] y
pueden ser consultados en la siguiente ubicación:

```
URL_APLICACION/admin/ENDPOINT
```

Por ejemplo:

http://localhost:8080/admin/mappings

Nota: Estos endpoints se encuentran asegurados, el usuario y contraseña por defecto pueden consultarse en /src/main/resources/application.yml.
Para ambientes cloud, se sugiere cambiar usuario y/o contraseña por default por medio de variables de entorno. 
