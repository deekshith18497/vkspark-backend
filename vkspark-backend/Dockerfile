# Stage 1 - Build
FROM eclipse-temurin:21-jdk AS builder

WORKDIR /app

COPY . .

RUN chmod +x mvnw
RUN ./mvnw clean package -Dmaven.test.skip=true

# Stage 2 - Run
FROM eclipse-temurin:21-jre

WORKDIR /app

COPY --from=builder /app/target/vkspark-backend-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 7050

ENTRYPOINT ["java","-jar","app.jar"]