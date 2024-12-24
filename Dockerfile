FROM openjdk:11.0.11-jre-slim
COPY target/beauf-king-api-0.0.1-SNAPSHOT.jar beauf-king-api-0.0.1-SNAPSHOT.jar
ENTRYPOINT [ "java", "-jar", "/beauf-king-api-0.0.1-SNAPSHOT.jar" ]