FROM eclipse-temurin:11-jre
COPY target/devops-mini-project-1.0.0.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
