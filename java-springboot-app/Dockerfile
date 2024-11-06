# Use an official OpenJDK runtime as a parent image
FROM FROM container-registry.oracle.com/java/openjdk:22.0.2-oraclelinux8

# Set the working directory inside the container
WORKDIR /app

# Create the /app/target directory
RUN mkdir -p /app/target

# Copy the JAR file or class file into the container at /app
COPY target/java-springboot-app-0.0.1-SNAPSHOT.jar /app/target

# Expose the port the application runs on (usually 8080 for Spring Boot)
EXPOSE 9090

# Copy the MySQL Connector JAR file into the container at /app
#COPY lib/mysql-connector-j-9.0.0.jar /app/lib/

# Run the application
CMD ["java", "-jar", "target/java-springboot-app-0.0.1-SNAPSHOT.jar"]

# Define the entry point to run the main method of the JAR
ENTRYPOINT ["java", "-cp", "target/java-springboot-app-0.0.1-SNAPSHOT.jar" ,"demos.springboot.JavaSpringbootAppApplication"]

