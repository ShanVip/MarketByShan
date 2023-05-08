FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ./target .
ENTRYPOINT ["java","-jar","./MarketByShan-0.0.1-SNAPSHOT.jar"]