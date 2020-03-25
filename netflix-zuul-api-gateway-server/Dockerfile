FROM java:8-jre
WORKDIR /usr/src
ENV MONGO_CI_URL=mongodb://localhost:27017/mygithubprojectdb
COPY target/netflix-zuul-api-gateway-server-1.0-SNAPSHOT.jar netflix-zuul-api-gateway-server-1.0-SNAPSHOT.jar
EXPOSE 8765
ENTRYPOINT ["java", "-jar", "netflix-zuul-api-gateway-server-1.0-SNAPSHOT.jar"]
