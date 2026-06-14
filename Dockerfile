# Etapa 1: Compilación del proyecto usando Maven y JDK 17
FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

# Etapa 2: Crear la imagen final ligera para ejecutar la app
FROM amazoncorretto:17-alpine-jdk
COPY --from=build /target/Proyecto-final-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]