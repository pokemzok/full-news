# Full News
Simple application which lets you stay in touch with news.

<p align="center">
    <img alt="start" src="https://github.com/pokemzok/full-news/blob/master/readme-images/overview.gif" />
</p>  

# What can you find in this application
1. Spring-Boot 2 backend
2. Angular 7 frontend
3. Karma and Spock tests
4. [News API](https://newsapi.org) integration example
5. Swagger 2 documentation generation
6. Responsive Web Design 
7. SCSS usage example
8. Advanced maven configuration which includes building and testing Angular application, docker image creation, merging frontend and backend into one singe spring-boot jar
9. Java 11

# Prerequisites 
* Java 11
* Maven 3.6.0
* Docker (running)
* Google Chrome (version 59+)

# How to build
1. Pull the project  
2. Create news-api-key.properties file in the backend\src\main\resources location.
3. Add newsapi.key property with your [api-key](https://newsapi.org) to your news-api-key.properties files. It should look something like this
    ```
    newsapi.key=YOUR-API-KEY
    ```
4. In the parent project directory run command
    ```
    mvn clean install
    ```

# How to run
1. Run docker image using this command
    ```
    docker run -p 8080:8080/tcp --name fullnews fullnews:0.0.1-SNAPSHOT
    ```
2. Go to [localhost:8080](http://localhost:8080)

# How to run without creating docker container
1. Go to bundle\target location and run the command
    ```
    java -jar bundle-0.0.1-SNAPSHOT.jar
    ```
2. Go to [localhost:8080](http://localhost:8080) in your browser

# How to run separately frontend and backend
1. Go to backend\target location and run the command
    ```
    java -jar backend-0.0.1-SNAPSHOT.jar
    ```
2. Go to frontend location and run the command
    ```
    ng serve
    ```
3. Go to [localhost:4200](http://localhost:4200) in your browser 

# API Documentation
After successful application launch visit [swagger page](http://localhost:8080/swagger-ui.html) to see more information about application REST API.
