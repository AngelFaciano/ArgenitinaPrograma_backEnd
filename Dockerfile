FROM amazoncorretto:17-alpine-jdk
maintainer FAF
COPY target/faf-0.0.1-SNAPSHOT.jar faf-app.jar
ENTRYPOINT ["java","-jar","/faf-app.jar"]
