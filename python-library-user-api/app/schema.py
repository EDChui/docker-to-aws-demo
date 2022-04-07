from pydantic import BaseModel

class User(BaseModel):
	name: str

class Book(BaseModel):
	isbn: str
	name: str
	author: str
