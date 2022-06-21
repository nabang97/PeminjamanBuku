FROM openjdk:8
VOLUME /tmp
ADD target/bookrent-0.0.1-SNAPSHOT.jar borrow.jar
EXPOSE 8042
ENTRYPOINT ["java", "-jar", "/borrow.jar"]