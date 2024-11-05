# Use an official OpenJDK image as a parent image
FROM container-registry.oracle.com/java/openjdk:22.0.2-oraclelinux8

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file or class file into the container at /app
COPY hello-user.jar /app/

# Run the application
#CMD ["java", "-jar", "welcome-user.jar"]

ENTRYPOINT ["java", "-cp", "hello-user.jar" ,"HelloUser"]




















