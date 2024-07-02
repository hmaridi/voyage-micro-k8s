FROM openjdk:17
LABEL authors="hmaridi"
EXPOSE 8084
ADD target/product-service.jar product-service.jar
ENTRYPOINT ["java", "-jar", "/product-service.jar"]