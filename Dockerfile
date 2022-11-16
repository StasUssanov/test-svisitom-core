FROM gradle:7.3.1-jdk17-alpine AS build
WORKDIR /home/app
COPY --chown=gradle:gradle . .
RUN gradle clean build --no-daemon

FROM openjdk:17-jdk-alpine3.14
WORKDIR /app
COPY --from=build /home/app/build/libs/*-SNAPSHOT.jar ./app.jar
EXPOSE 8010
ENTRYPOINT ["java", "-jar", "app.jar"]
