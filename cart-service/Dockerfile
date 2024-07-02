FROM openjdk:17
LABEL authors="hmaridi"
EXPOSE 8082
ADD target/cart-service.jar cart-service.jar
ENTRYPOINT ["java", "-jar", "/cart-service.jar"]