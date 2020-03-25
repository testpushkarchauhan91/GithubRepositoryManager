FROM java:8-jre
WORKDIR /usr/src
ENV MONGO_CI_URL=mongodb://localhost:27017/mygithubprojectdb
COPY target/authentication-service-1.0-SNAPSHOT.jar authentication-service-1.0-SNAPSHOT.jar
EXPOSE 8090
ENTRYPOINT ["java", "-jar", "authentication-service-1.0-SNAPSHOT.jar"]
