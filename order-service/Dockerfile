FROM openjdk:17
LABEL authors="hmaridi"
EXPOSE 8085
ADD target/order-service.jar order-service.jar
ENTRYPOINT ["java", "-jar", "/order-service.jar"]