FROM openjdk:17
LABEL authors="hmaridi"
EXPOSE 8086
ADD target/payment-service.jar payment-service.jar
ENTRYPOINT ["java", "-jar", "/payment-service.jar"]