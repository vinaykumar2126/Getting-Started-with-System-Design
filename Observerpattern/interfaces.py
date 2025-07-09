# interfaces.py

class Observer:
    """
    The Observer interface declares the update method, used by subjects.
    """
    def update(self, message: str):
        raise NotImplementedError()

class Subject:
    """
    The Subject interface declares methods for managing subscribers.
    """
    def register(self, observer: Observer):
        raise NotImplementedError()

    def unregister(self, observer: Observer):
        raise NotImplementedError()

    def notify(self):
        raise NotImplementedError()