from abc import ABC, abstractmethod

class Chair(ABC):
    @abstractmethod
    def sit_on(self):
        pass

class ModernChair(Chair):
    def sit_on(self):
        print("Sitting on a modern chair")

class VictorianChair(Chair):
    def sit_on(self):
        print("Sitting on a Victorian chair")
