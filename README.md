## Match odds spring API
REST API CRUD with Spring Boot 2 and PostgreSQL that manages sport match odds

### Technology stack:

* Spring Boot 2;
* Spring Web;
* Spring Data;
* PostgreSQL database;
* Hibernate;
* Lombok;
* Docker;

#### To run this application use:

```bash
mvn spring-boot:run
```

### The view in the Postman: 
[http://localhost:8080/api/matches](http://localhost:8080/api/matches) for matches
[http://localhost:8080/api/odds](http://localhost:8080/api/odds) for odds

Also you can see all the swagger from Postman:
http://localhost:8080/v2/api-docs?group=MatchOdds

or from browser:
http://localhost:8080/swagger-ui.html

### Create docker image

First I created a Dockerfile to my project.
Then I ran these commands to powershel:

```docker build --tag=spring-bet-docker3:latest .``` //build the image

```docker run -p 8080:8080 spring-bet-docker3:latest``` //run the image in specific port

### Connect to PostgreSQL via Docker
```postgres docker```

```docker pull postgres:alpine```

```docker run --name postgres-0 -e POSTGRES_PASSWORD=PASSWORD -d -p 5432:5432 postgres:alpine``` //run postgres image to specific port using password

e7cdac096273c7197e5cdd641e72a6c00f15f306984825a0673a1783870bf0d4

```docker ps```

CONTAINER ID   IMAGE             COMMAND                  CREATED              STATUS              PORTS                    NAMES
e7cdac096273   postgres:alpine   "docker-entrypoint.s…"   About a minute ago   Up About a minute   0.0.0.0:5432->5432/tcp   postgres-0

```docker exec -it postgres-0 bash``` // to enter the postgres-0 container

```bash-5.1# psql -U postgres``` // to get access

```\c postgres```

You are now connected to database "postgres" as user "postgres".

```psql -h localhost -p 5432 -U postgres``` // used password to connect to database

```\dt``` //list of tables 

          List of relations
 Schema |  Name   | Type  |  Owner
--------+---------+-------+----------
 public | matches | table | postgres
 public | odds    | table | postgres
(2 rows)

``` \d+ odds;``` //see whats inside odd table

                                                   Table "public.odds"
  Column   |         Type         | Collation | Nullable | Default | Storage  | Compression | Stats target | Description
-----------+----------------------+-----------+----------+---------+----------+-------------+--------------+-------------
 id        | bigint               |           | not null |         | plain    |             |              |
 match_id  | bigint               |           |          |         | plain    |             |              |
 odd       | double precision     |           |          |         | plain    |             |              |
 specifier | character varying(1) |           |          |         | extended |             |              |
Indexes:
    "odds_pkey" PRIMARY KEY, btree (id)
Access method: heap

```postgres-# \d+ matches;```  //see whats inside matches table

                                                   Table "public.matches"
   Column    |          Type          | Collation | Nullable | Default | Storage  | Compression | Stats target | Description
-------------+------------------------+-----------+----------+---------+----------+-------------+--------------+-------------
 id          | bigint                 |           | not null |         | plain    |             |              |
 description | character varying(255) |           |          |         | extended |             |              |
 match_date  | date                   |           |          |         | plain    |             |              |
 match_time  | time without time zone |           |          |         | plain    |             |              |
 sport       | character varying(1)   |           |          |         | extended |             |              |
 team_a      | character varying(255) |           |          |         | extended |             |              |
 team_b      | character varying(255) |           |          |         | extended |             |              |
Indexes:
    "matches_pkey" PRIMARY KEY, btree (id)
Access method: heap
