# Film Catalog
- The Film Catalog is a full-stack application that allows a user the ability to search for film information and actors from a film database. The user can add, update, and remove films as desired.

-Deployed AWS EC2 Link: http://18.189.252.60:8080/VideoStoreREST/

![image](https://github.com/blakevieyra/FilmCatalog/assets/88246090/fafffd1e-a0b2-48f3-a1a8-ba69c00fd1c3)

# Key Features:

| HTTP Verb | URI               | Request Body | Response Body | Status Codes |
|-----------|-------------------|--------------|---------------|---------|
| GET       | `/api/films/1`      | JSON retrieval of film id `1` | Retrieves of film with id `1` | 200, 404 |
| GET       | `/api/films/rating/G`   |  JSON of films with rating of G | Retrieves films with rating of G| 200, 404 |
| GET       | `/api/films/category/Action`   |  JSON of films by category | Retrieves films related by category Action| 200, 404 |
| GET       | `/api/films/keyword`   |  JSON of films by keyword search | Retrieves films related to keyword search| 200, 404 |
| POST      | `/api/films`      | JSON of post for film id `1`  | Creates new films with film id `1` | 201, 400 |
| PUT       | `/api/films/1`   | JSON of a new version of film for film id `1` | Updates film for film id `1` | 201, 
| DELETE    | `/api/film/1`   | JSON of deletion of film id `1` | Deletes film id `1`| 204, 404, 400 | 

       

# Tech Used:

Programming Languages:
- Java 8 (version 1.8.0_391), JavaScript
- IDEs: Spring Tool Suite (STS) (https://spring.io/tools)
- Version Control: Git 2.32.1 (https://git-scm.com/)
- Database Management: MySQL (version 5.7.39)
- Build Tool: Gradle
- Web Framework: Spring MVC, JPA, Restful API

# Lessons Learned:

- How to configure server-side settings in AWS instance. 

