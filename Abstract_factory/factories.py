from abc import ABC, abstractmethod
from chair import ModernChair, VictorianChair
from sofa import ModernSofa, VictorianSofa

class FurnitureFactory(ABC):
    @abstractmethod
    def create_chair(self):
        pass

    @abstractmethod
    def create_sofa(self):
        pass

class ModernFurnitureFactory(FurnitureFactory):
    def create_chair(self):
        return ModernChair()

    def create_sofa(self):
        return ModernSofa()

class VictorianFurnitureFactory(FurnitureFactory):
    def create_chair(self):
        return VictorianChair()

    def create_sofa(self):
        return VictorianSofa()
