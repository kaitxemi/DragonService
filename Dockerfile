FROM maven:3.9.4-eclipse-temurin-17 AS build
WORKDIR /workspace

# Copy pom and download dependencies (useful for caching)
COPY pom.xml ./
RUN mvn -B -DskipTests dependency:go-offline

# Copy source and build
COPY src ./src
RUN mvn -B -DskipTests package

FROM eclipse-temurin:17-jre
WORKDIR /app

# Copy the built jar from the builder stage. Adjust the glob if your artifact has a classifier/version.
COPY --from=build /workspace/target/*.jar app.jar

# Expose a common port; change if your app uses a different port
EXPOSE 8080

# Start the application. The user specified "java -jar" as the start command; we run the built jar.
ENTRYPOINT ["java","-jar","/app/app.jar"]