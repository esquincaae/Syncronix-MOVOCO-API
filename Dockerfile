FROM amazoncorretto:17-alpine3.16

RUN apk update && apk add --no-cache maven

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:resolve

COPY src ./src
RUN mvn package

CMD ["java", "-jar", "target/MovocoApi.jar"]
