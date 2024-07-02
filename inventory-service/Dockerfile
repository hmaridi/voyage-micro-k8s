FROM openjdk:17
LABEL authors="hmaridi"
EXPOSE 8083
ADD target/inventory-service.jar inventory-service.jar
ENTRYPOINT ["java", "-jar", "/inventory-service.jar"]