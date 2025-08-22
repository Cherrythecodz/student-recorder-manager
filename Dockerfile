# Step 1: Use an official Java runtime as base image
FROM openjdk:17-jdk-slim

# Step 2: Set working directory inside container
WORKDIR /app

# Step 3: Copy project files (for Maven build)
COPY . .

# Step 4: Build the app (skip tests to save time)
RUN ./mvnw clean package -DskipTests

# Step 5: Run the JAR (replace with your actual jar name if different)
CMD ["java", "-jar", "target/demo-0.0.1-SNAPSHOT.jar"]
