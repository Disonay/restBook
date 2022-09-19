# Book Api

## Описание

RESTful API, который предоставляет CRUDL операции для ресурсов "книги" и "авторы" 

Книга:
* title
* author
* publication_date

Автор:
* surname
* name
* middle_name

## Стек

Серверная часть - Spring Boot 2  
Клиентская часть - Angular 8

## Сброка проекта для деплоя на glassfish

`mvn clean package -P prod`

