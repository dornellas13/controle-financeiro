FROM openjdk:8-jre-alpine
VOLUME /app
COPY ./build/libs/controle-financeiro-1.0-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]