FROM amazoncorretto:17-alpine3.16
ADD target/MovocoApi.jar MovocoApi.jar
ENTRYPOINT ["java", "-jar", "MovocoApi.jar"]