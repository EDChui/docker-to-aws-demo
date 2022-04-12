from fastapi import FastAPI, HTTPException
from mangum import Mangum
import os
import requests
import random

from userDatabase import UserDatabase
import schema

app = FastAPI()

@app.post("/users")
def addUser(user: schema.User):
	id = UserDatabase().addUser({"name": user.name, "books": []})
	return {"id": id}

@app.get("/users")
def getAllUsers():
	return UserDatabase().getAllUsers()

@app.get("/users/{id}")
def getUser(id: int):
	user = UserDatabase().getUser(id)
	if user is None:
		raise HTTPException(status_code=404, detail="User not found.")
	return user

@app.delete("/users/{id}")
def deleteUser(id: int):
	success = UserDatabase().deleteUser(id)
	return {"success": success}

@app.post("/users/{id}/books")
def addBookToUser(id: int, book: schema.Book):
	success = UserDatabase().addBookToUser(id, book)
	return {"success": success}

@app.post("/users/{id}/books/random")
def addRandomBookToUser(id: int):
	session = requests.Session()
	session.trust_env = False
	requestResult = session.get(os.getenv("BOOK_API_BASE_URL")+"/books")
	if requestResult.status_code != 200:
		return {"success": False}
	bookList = requestResult.json()["books"]
	success = UserDatabase().addBookToUser(id, random.choice(bookList))
	return {"success": success}

# Handler for deploying to AWS lambda.
handler = Mangum(app)
