FROM eclipse-temurin:17.0.7_7-jre-alpine AS dev

RUN mkdir /app
WORKDIR /app

COPY build/quarkus-app/app ./app
COPY build/quarkus-app/lib ./lib
COPY build/quarkus-app/quarkus  ./quarkus
COPY build/quarkus-app/quarkus-run.jar app.jar

EXPOSE 9090

CMD ["java","-jar","app.jar"]

# Construccion de imagen dev en docker
# docker build --target dev . -t app-usuarios:1.0.0