FROM openjdk:17-jdk-slim
COPY target/beauf-king-service-0.0.1-SNAPSHOT.jar beauf-king-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT [ "java", "-jar", "/beauf-king-service-0.0.1-SNAPSHOT.jar" ]
