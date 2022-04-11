# Python Library User API

# Table of Content

- [Python Library User API](#python-library-user-api)
- [Table of Content](#table-of-content)
- [Description](#description)
- [Language and Framework Used](#language-and-framework-used)
- [APIs](#apis)
  - [Add Users](#add-users)
  - [Get All Users](#get-all-users)
  - [Get User by ID](#get-user-by-id)
  - [Delete User by ID](#delete-user-by-id)
  - [Add Book to User](#add-book-to-user)
  - [Add Random Book to User](#add-random-book-to-user)

# Description

In this demo, this API written in Python handles the service related to the users of a library.

Note the [one of the API](#add-random-book-to-user) will make a HTTP request to the service `book`. Related server has to be set up and its base url need to be configured in environment variable. 

# Language and Framework Used

- Python 3.9
- [FastAPI](https://fastapi.tiangolo.com/)

# APIs

## Add Users

Method

	POST

Endpoint

	/users

Payload

```json
{
	"name": "Danny"
}
```

Response

```json
{
	"id": 3
}
```

## Get All Users

Method

	GET

Endpoint

	/users

Response

```json
{
    "0": {
        "name": "Alice",
        "books": [
            {
                "isbn": "1234567",
                "name": "A new book",
                "author": "It's me"
            }
        ]
    },
    "1": {
        "name": "Bob",
        "books": []
    },
    "2": {
        "name": "Cindy",
        "books": []
    },
    "3": {
        "name": "Danny",
        "books": []
    }
}
```

## Get User by ID

Method

	GET

Endpoint

	/users/{id}

Response

```json
{
    "name": "Alice",
    "books": [
        {
            "isbn": "1234567",
            "name": "A new book",
            "author": "It's me"
        }
    ]
}
```

## Delete User by ID

Method

	DELETE

Endpoint

	/users/{id}

Response

```json
{
	"success": true
}
```

## Add Book to User

Method

	POST

Endpoint

	/users/{id}/books

Payload

```json
{
    "isbn": "1234567",
    "name": "A new book",
    "author": "It's me"
}
```

Response

```json
{
	"success": true
}
```

## Add Random Book to User

Details

This method will make a HTTP request to ${BOOK_API_BASE_URL}/books and randomly select a book from the respond.
The response from ${BOOK_API_BASE_URL}/books should looks like:
```json
{
    "books": [
        {
            "isbn": "0262162091",
            "name": "Types and Programming Languages",
            "author": "Benjamin C. Pierce"
        },
        {
            "isbn": "0201633612",
            "name": "Design Patterns: Elements of Reusable Object-Oriented Software",
            "author": "Erich Gamma; Richard Helm; Ralph Johnson; John Vlissides"
        }
    ]
}
```

Method

    POST

Endpoint

    /users/{id}/books/random

Response

```json
{
    "success": true
}
```