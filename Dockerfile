FROM openjdk:14-alpine
EXPOSE 80
ARG JAR_FILE=/build/libs/CLNS-CAL-1.0.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
