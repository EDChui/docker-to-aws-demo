# Java Book API

# Table of Content

- [Java Book API](#java-book-api)
- [Table of Content](#table-of-content)
- [Description](#description)
- [Languages and Framework Used](#languages-and-framework-used)
- [APIs](#apis)
  - [Add Book](#add-book)
  - [Get Book List](#get-book-list)
  - [Get Book by ID](#get-book-by-id)
  - [Delete Book by ID](#delete-book-by-id)

# Description

In the demo, this API written in Java handles the service related to the books of a library.

This API can be considered as some code that must use libraries from other languages, or some legacy code, or some other services in a project.

To run this server individually, just execute

    RestServiceApplication::main

The webserver will be running on `http://localhost:8080` by default.

# Languages and Framework Used

- Java 11
- [Spring Boot 2.6.6](https://spring.io/projects/spring-boot)

# APIs

## Add Book

Method

    POST

Endpoint

    /books

Payload

```json
{
  "isbn": "9780262033848",
  "name" : "Introduction to Algorithms",
  "author": "Thomas H. Cormen, Charles E. Leiserson, Ronald L. Rivest and Clifford Stein"
}
```

Response

```json
{
  "id": 1
}
```

## Get Book List

Method

    GET

Endpoint

    /books

Response

```json
{
  "books" : [
    {
      "isbn": "1792901690",
      "name" : "Discrete Mathematics: An Open Introduction",
      "author": "Oscar Levin",
      "id": 0
    },
    {
      "isbn": "9780262033848",
      "name" : "Introduction to Algorithms",
      "author": "Thomas H. Cormen, Charles E. Leiserson, Ronald L. Rivest and Clifford Stein",
      "id": 1
    }
  ]
}
```

## Get Book by ID

Method

    GET

Endpoint

    /books/{id}

Response

```json
{
  "isbn": "9780262033848",
  "name" : "Introduction to Algorithms",
  "author": "Thomas H. Cormen, Charles E. Leiserson, Ronald L. Rivest and Clifford Stein",
  "id": 1
}
```

## Delete Book by ID

Method

    DELETE

Endpoint

    /books/{id}

Response

```json
{
  "success": true
}
```
