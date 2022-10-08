FROM openjdk:8-alpine
#FROM ubuntu
#RUN apt-get update && apt-get install -y curl
#WORKDIR /src
#COPY . .
ADD target/*.jar gocheeta.jar
ENTRYPOINT ["java", "-jar", "gocheeta.jar"]

