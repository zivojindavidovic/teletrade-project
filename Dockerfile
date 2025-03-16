FROM openjdk:17-jdk

ADD target/teletrade-project-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]