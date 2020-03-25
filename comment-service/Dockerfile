FROM java:8-jre
WORKDIR /usr/src
ENV MONGO_CI_URL=mongodb://localhost:27017/mygithubprojectdb
COPY target/comment-service-1.0-SNAPSHOT.jar comment-service-1.0-SNAPSHOT.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "comment-service-1.0-SNAPSHOT.jar"]
