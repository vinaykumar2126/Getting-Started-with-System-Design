from abc import ABC, abstractmethod

class Sofa(ABC):
    @abstractmethod
    def lie_on(self):
        pass

class ModernSofa(Sofa):
    def lie_on(self):
        print("Lying on a modern sofa")

class VictorianSofa(Sofa):
    def lie_on(self):
        print("Lying on a Victorian sofa")
