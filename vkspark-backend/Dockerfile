FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY . .

RUN ./mvnw clean package -Dmaven.test.skip=true

EXPOSE 7050

ENTRYPOINT ["java","-jar","target/vkspark-backend-0.0.1-SNAPSHOT.jar"]