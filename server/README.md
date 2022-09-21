# Book Api Server

Endpoints for books:
* POST: /api/books/
* GET: /api/books/id
* PUT: /api/books/id
* DELETE: /api/books/id
* DELETE: /api/books/soft/id
* GET: /api/books/

Endpoints for authors:
* POST: /api/authors/
* GET: /api/authors/id
* PUT: /api/authors/id
* DELETE: /api/authors/id
* GET: /api/authors/books
* 
## Spring profiles

Используются два профиля:
* dev (Используется при запуске через Spring Boot)
* prod (Используется при деплое на GlassFish)

В профиле **dev** происходит подключение к postgres бд без использования миграций. Параметры
для подключения задаются через application.properties

В профиле **prod** происходит подключение к oracle бд, параметры для подключения получаются через JNDI. Cхема БД через
flyway миграцию

## Data Bases

Postgres бд разворачивалась на heroku.
Oracle бд разворачивалась на VM, образ Oracle DB Developer VM

## Glassfish JNDI

### JDBC Connection Pool

![JDBC Connection Pool](https://i.imgur.com/6ImPhvt.png)

### Oracle Pool Param

![Oracle Pool Param](https://i.imgur.com/BmVz2tW.png)

### JDBC Resources

![JDBC Resources](https://i.imgur.com/gFt0pkb.png)

## Glassfish Deploy

![Glassfish Deploy](https://i.imgur.com/JQ1ENPu.png)

