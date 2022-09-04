# restBook

## Api

RESTful API, который предоставляет CRUDL операции для ресурса "книги"

Книга:
* name
* author
* publication_date

Endpoints:
* create 
* read - Получение книги по id (параметр bookId)
* update
* delete 
* list - Список книг одного автора (параметр author)

## Spring profiles

Используются два профиля:
* dev (Используется при запуске через Spring Boot)
* prod (Используется при деплое на GlassFish)

В профиле **dev** происходит подключение к postgres бд без использования миграций. Параметры 
для подключения задаются через application.properties

В профиле **prod** происходит подключение к oracle бд, параметры для подключения получаются через JNDI. Cхема БД через 
flyway миграцию

## Glassfish JNDI

### JDBC Connection Pool

![JDBC Connection Pool](https://imgu.com/a/OTJxbpJ)

### Oracle Pool Param

![Oracle Pool Param](https://imgur.com/a/Dn1Yvzq)

### JDBC Resources

![JDBC Resources](https://imgur.com/a/NKwz0XC)