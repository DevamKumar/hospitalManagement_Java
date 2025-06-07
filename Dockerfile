# Use Java image
FROM openjdk:24

#Metadata
LABEL authors="devamkumar"
LABEL project="HospitalManagement"

# Set working directory inside the container
WORKDIR /app

# Copy JAR file from the build output
COPY build/libs/*.jar app.jar

# Expose port (match your app's server.port)
EXPOSE 8180

# Default command to run your Spring Boot app
ENTRYPOINT ["java", "-jar", "app.jar"]