FROM openjdk:21-jdk
COPY build/libs/auth-service-1.0.0-SNAPSHOT.jar app/app.jar
ENTRYPOINT java -jar app/app.jar