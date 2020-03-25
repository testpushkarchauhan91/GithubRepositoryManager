FROM java:8-jre
WORKDIR /usr/src
ENV MONGO_CI_URL=mongodb://localhost:27017/mygithubprojectdb
COPY target/profile-service-1.0-SNAPSHOT.jar profile-service-1.0-SNAPSHOT.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "profile-service-1.0-SNAPSHOT.jar"]
