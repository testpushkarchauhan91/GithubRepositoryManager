FROM java:8-jre
WORKDIR /usr/src
ENV MONGO_CI_URL=mongodb://localhost:27017/mygithubprojectdb
COPY target/netflix-eureka-naming-server-1.0-SNAPSHOT.jar netflix-eureka-naming-server-1.0-SNAPSHOT.jar
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "netflix-eureka-naming-server-1.0-SNAPSHOT.jar"]
