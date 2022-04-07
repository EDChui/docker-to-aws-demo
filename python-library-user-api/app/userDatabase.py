# Singleton implementation reference: https://refactoring.guru/design-patterns/singleton/python/example#example-1

from threading import Lock, Thread

class SingletonMeta(type):
	_instances = {}
	_lock: Lock = Lock()

	def __call__(cls, *args, **kwargs):
		with cls._lock:
			if cls not in cls._instances:
				instance = super().__call__(*args, **kwargs)
				cls._instances[cls] = instance
		return cls._instances[cls]

class UserDatabase(metaclass=SingletonMeta):
	_dbLock: Lock = Lock()
	lastId: int = 0
	database: dict = {}
	
	def __init__(self):
		self.addUser({"name": "Alice", "books": []})
		self.addUser({"name": "Bob", "books": []})
		self.addUser({"name": "Cindy", "books": []})
	
	def addUser(self, user: dict) -> int:
		with self._dbLock:
			self.database.update({self.lastId: user})
			returnId = self.lastId
			self.lastId += 1
		return returnId

	def getUser(self, id: int) -> dict:
		try:
			return self.database[id]
		except KeyError:
			return None

	def getAllUsers(self) -> dict:
		return self.database

	def deleteUser(self, id: int) -> bool:
		with UserDatabase._dbLock:
			try:
				return self.database.pop(id) is not None
			except KeyError:
				return False

	def addBookToUser(self, user_id: int, book: dict):
		user = self.getUser(user_id)
		if user is None:
			return False
		user["books"].append(book)
		return True
