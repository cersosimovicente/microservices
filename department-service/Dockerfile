FROM openjdk:21
LABEL mentainer="tumail.net@gmail.com"
WORKDIR /app
COPY ./target/department-service-0.0.1-SNAPSHOT.jar department-service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "department-service.jar" ]