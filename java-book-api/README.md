# Java Book API

## Description

In the demo, this API written in Java can be considered as some code that must use libraries from other languages, or 
simply some legacy code in the organisation.

## API Lists

### Add Book

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

### Get Book List

Method

    GET

Endpoint

    /books

Response

```json
[
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
```

### Get Book by ID

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

### Delete Book by ID

Method

    DELETE

Endpoint

    /books/{id}

Response

```json
{
  "message": "Success."
}
```
