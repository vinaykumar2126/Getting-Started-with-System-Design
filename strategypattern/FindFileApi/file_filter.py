from abc import ABC,abstractmethod

class FileFilter(ABC):
    @abstractmethod
    def matches(self, filepath:str)->bool:
        pass