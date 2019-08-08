## TRA Demo application

### This demo application is available on Heroku:
https://tra-demo.herokuapp.com/ (username/password: user/user)

#### Local set-up
First of all you need to set-up Postgres DB.

Flyway settings in *build.gradle* and Spring datasource settings in *application.properties* must be the same.

You should create database and DB user accordingly to the given credentials or modify it to something that you are using in your environment.

All necessary tables and some test data will be created automatically when you run bootjar.

Swagger docs: http://localhost:8080/v2/api-docs

Swagger UI: http://localhost:8080/swagger-ui.html

#### Running application

Run gradle task **bootJar** to build jar and then run **java -jar tra-demo-0.0.1-SNAPSHOT.jar**

or

Run gradle task **bootRun** to start application immediately after building.

#### Security

Basic Auth

username: **user**\
password: **user**