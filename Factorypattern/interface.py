from abc import ABC, abstractmethod
class Juice(ABC):
    @abstractmethod
    def serve(self):
        pass