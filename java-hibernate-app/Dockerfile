# Use an official OpenJDK runtime as a parent image
FROM container-registry.oracle.com/java/openjdk:22.0.2-oraclelinux8

# Set the working directory inside the container
WORKDIR /app

# Create the /app/target directory
RUN mkdir -p /app/target

# Copy the JAR file or class file into the container at /app
COPY target/java-hibernate-app-0.0.1-SNAPSHOT-jar-with-dependencies.jar /app/target

# Copy the MySQL Connector JAR file into the container at /app
#COPY lib/mysql-connector-j-9.0.0.jar /app/lib/

# Run the application
CMD ["java", "-jar", "target/java-hibernate-app-0.0.1-SNAPSHOT-jar-with-dependencies.jar"]












