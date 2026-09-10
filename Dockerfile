FROM eclipse-temurin:25-jre

WORKDIR /app

COPY target/devops-cicd-pipeline-1.0-SNAPSHOT.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
