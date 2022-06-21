# Welcome to simple cinema service application!

<img src="https://img.freepik.com/free-vector/isometric-cinema-icon-set_1284-18691.jpg?w=740&t=st=1655819279~exp=1655819879~hmac=b537d9c1c8fcb7dda89728ec1e84151a227da1ff762ec73b71a59b7a0e6aae09" width="400" alt="cinema">

## The goal of this project is:
* Create a Java application using Spring and Hibernate
* Simulate simple cinema-shop functionality

This is a web project, which could be characterized as a simple cinema shop realization. 
The project is based on the principles of SOLID and three-tier software architecture. 
Besides, such frameworks as Spring Web, Spring REST, Spring Security, Hibernate have been used to accomplish the cinema shop. 
Authentication and authorization are also represented as a part of a project. 
HTTP requests can be sent in JSON format and are stored in a database.

## Technologies that were used to create the service:
* Java 11
* MySQL
* Hibernate
* Spring (Core, WEB, Security)
* Apache Tomcat (to run app locally)
* Maven Checkstyle Plugin

## Overview
#### Project has multiple endpoints with user and admin access
POST: `/register` (to create a user) - ALL <br/>
POST: `/cinema-halls` (to create a cinema hall) - ADMIN <br/>
POST: `/movies` (to create a movie) - ADMIN <br/>
POST: `/movie-sessions` (to create a movie sessions) - ADMIN <br/>
POST: `/orders/complete` (to create an order for current user) - USER <br/>
PUT: `/movie-sessions/{id}` (to update a movie session) - ADMIN <br/>
PUT: `/shopping-carts/movie-sessions` (to add movie session to shopping cart) - USER <br/>
DELETE: `/movie-sessions/{id}` (to delete a movie session) - ADMIN <br/>
GET: `/orders` (to get order history for current user) - USER <br/>
GET: `/shopping-carts/by-user` (to get a shopping cart for current user) - USER <br/>
GET: `/cinema-halls ` (to get all cinema halls) - USER or ADMIN <br/>
GET: `/movies` (to get all movies) - USER or ADMIN <br/>
GET: `/movie-sessions/available` (to get all available movie by date) - USER or ADMIN <br/>
GET: `/users/by-email` (to find user by email) - ADMIN <br/>
#### Example how to add data into the application (using for example Postman)
{"email":"bob@gmail.com", "password":"bobsPass", "repeatPassword":"bobsPass"}  POST: /register <br/>
{"capacity":200, "description":"Modern hall"}  POST: /cinema-halls <br/>
{"title":"The Matrix", "description":"Will Neo be The One?"}  POST: /movies <br/>
{"movieId":1, "cinemaHallId":1, "showTime":"15.06.2022 15:15"}  POST: /movie-sessions <br/>
{"movieId":1, "cinemaHallId":1, "showTime":"15.06.2022 15:15"}  PUT: /movie-sessions/{id} <br/>

/movie-sessions/available?movieId={id}&date=dd.MM.yyyy  GET <br/>
/shopping-carts/movie-sessions?movieSessionId=1  PUT <br/>
/users/by-email?email=your email  GET <br/>

## How to start cinema service locally:
1. Install and configure Apache Tomcat (recommended version 9.0.50)
2. Install and configure and create a schema in MySQL
3. Fork and clone this project
4. To connect to database in application you need change configuration information
   in the file from `/resources/db.properties` to the ones you specified when installing MySQL
~~~
for example: 
    URL = "jdbc:mysql://localhost:3306/cinema?serverTimezone=UTC";
    USERNAME = "root";
    PASSWORD = "root";
    JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
~~~
5. Run this project using Tomcat local server

