FROM openjdk:8
VOLUME /tmp
ADD target/bookrent-0.0.1-SNAPSHOT.jar userservice.jar
EXPOSE 8040
ENTRYPOINT ["jar", "-jar", "/userservice.jar"]