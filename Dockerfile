FROM openjdk:15-alpine
EXPOSE 80
ARG JAR_FILE=CLNS-CAL-CORE/build/libs/CLNS-CAL.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
