# Python Library User API

## API Lists

### Add Users

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

### Get All Users

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

### Get User by ID

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

### Delete User by ID

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

### Add Book to User

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