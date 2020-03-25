FROM java:8-jre
WORKDIR /usr/src
ENV MONGO_CI_URL=mongodb://localhost:27017/mygithubprojectdb
COPY target/spring-cloud-config-server-0.0.1-SNAPSHOT.jar spring-cloud-config-server-0.0.1-SNAPSHOT.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "spring-cloud-config-server-0.0.1-SNAPSHOT.jar"]
