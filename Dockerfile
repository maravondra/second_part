FROM openjdk:21-jdk

RUN mkdir "api"

WORKDIR api

COPY target/SpringBootInDocker-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","app.jar"]