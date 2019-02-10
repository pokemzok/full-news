FROM openjdk:11.0.2-jdk-stretch
ADD target/bundle-0.0.1-SNAPSHOT.jar full-news.jar
EXPOSE 8080:8080/tcp
CMD java -jar full-news.jar
