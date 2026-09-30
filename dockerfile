# FROM eclipse-temurin:17-jdk
#
# WORKDIR /app
#
# COPY target/spring-data-jpa-mapping-0.0.1-SNAPSHOT.jar app.jar
#
# EXPOSE 8899
#
# ENTRYPOINT ["java","-Dspring.profiles.active=docker","-jar","app.jar"]

FROM eclipse-temurin:17-jre

WORKDIR /app

COPY target/*.jar app.jar

EXPOSE 8899

ENTRYPOINT ["java","-Dspring.profiles.active=docker","-jar","app.jar"]

