# Using this Dockerfile, Gradle clean build has to be executed first before build and running this application in Docker.
# Gradle clean build can be done in IDE such as IntelliJ.
# Use this to reduce the time needed to build the .jar files each time when deploy locally.
# Commands:
# Build docker image: docker build -t <image_name> .
# Deploy container: docker run -d --name <container_name> -p 8080:8080 <image_name>
# The application will run on http://localhost:8080 after deploy.

# Ref: https://medium.com/geekculture/docker-basics-and-easy-steps-to-dockerize-spring-boot-application-17608a65f657
FROM adoptopenjdk/openjdk11

ENV APP_HOME = /usr/app

WORKDIR ${APP_HOME}

COPY build/libs/*.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
