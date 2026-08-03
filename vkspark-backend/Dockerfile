FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY target/vkspark-backend-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 7050

ENTRYPOINT ["java","-jar","app.jar"]