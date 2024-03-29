FROM gradle:6.8.3-jdk11 as builder
WORKDIR /app
COPY . /app
RUN gradle bootJar

FROM amazoncorretto:11
WORKDIR /app
COPY --from=builder /app/build/libs/HealthTech-1.0-SNAPSHOT.jar /app/app.jar

ENTRYPOINT ["java"]
CMD ["-jar", "app.jar"]
