#Descargamos la imagen oficial de java runtime
FROM openjdk:17-slim as build

#Información de quien mantiene esta imagen
MAINTAINER Juan Camilo R

# Agregamos el jar al contenedor
COPY target/countries-api-0.0.1-SNAPSHOT.jar countries-api-0.0.1-SNAPSHOT.jar

#ejecuta la aplicación
ENTRYPOINT ["java","-jar","/countries-api-0.0.1-SNAPSHOT.jar"]