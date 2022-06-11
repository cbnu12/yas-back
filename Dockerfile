# Start with a base image containing Java runtime
FROM openjdk:17-alpine

# Add Author info
LABEL maintainer="hgs6424@naver.com"

# Add a volume to /tmp
VOLUME /tmp

# Make port 8080 available to the world outside this container
EXPOSE 8080

# The application's jar file
ARG JAR_FILE=./build/libs/backend-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
ADD ${JAR_FILE} api.jar

# Add profile env
ENV PROFILE local-docker

# Run the jar file
ENTRYPOINT ["java", "-Dspring.profiles.active=${PROFILE}", "-Duser.timezone=Asia/Seoul", "-jar", "/api.jar"]
