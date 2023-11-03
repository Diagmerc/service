FROM openjdk:17-jdk-alpine
COPY target/app.war app.war
ENTRYPOINT ["java","-jar","app.war"]

