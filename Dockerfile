FROM openjdk:21-jdk-slim

WORKDIR /app

COPY target/piper-test-0.0.1-SNAPSHOT.jar /app/

ENTRYPOINT ["java", "-jar", "/app/piper-test-0.0.1-SNAPSHOT.jar"]