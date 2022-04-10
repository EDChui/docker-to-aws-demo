# Ref: https://medium.com/geekculture/docker-basics-and-easy-steps-to-dockerize-spring-boot-application-17608a65f657
FROM adoptopenjdk/openjdk11

ENV APP_HOME = /usr/app

WORKDIR ${APP_HOME}

COPY build/libs/*.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
