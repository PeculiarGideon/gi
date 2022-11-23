FROM maven:3.6.3-openjdk-14-slim AS build
RUN mkdir -p /workspace
WORKDIR /workspace
COPY pom.xml /workspace
COPY src /workspace/src
RUN mvn -B package --file pom.xml -DskipTests




FROM openjdk:17
MAINTAINER baeldung.com
COPY --from=build /workspace/target/*jar-with-dependencies.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
