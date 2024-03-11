from openjdk:8-jdk-alpine

EXPOSE 8080

ADD target/auth-service-0.0.1-SNAPSHOT.jar

CMD ["java", "-jar", "auth_service.jar"]