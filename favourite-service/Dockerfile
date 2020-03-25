FROM java:8-jre
WORKDIR /usr/src
ENV MONGO_CI_URL=mongodb://localhost:27017/mygithubprojectdb
COPY target/favourite-service-1.0-SNAPSHOT.jar favourite-service-1.0-SNAPSHOT.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "favourite-service-1.0-SNAPSHOT.jar"]
