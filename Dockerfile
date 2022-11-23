FROM openjdk:17
MAINTAINER baeldung.com
COPY /home/runner/work/gi/gi/target/gi-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]


