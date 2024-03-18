FROM openjdk:21

EXPOSE 8080

ARG JAR_FILE=target/techchallenge-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar

#ENV DATABASE_URL=jdbc:mysql://localhost:3340/techchallenge
#ENV DATABASE_USERNAME=root
#ENV DATABASE_PASSWORD=admin

ENTRYPOINT ["java", "-jar", "/app.jar"]