from fastapi import FastAPI, HTTPException

from userDatabase import UserDatabase
import schema

app = FastAPI()

@app.get("/")
def root():
	return {"message": "App is running."}

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
