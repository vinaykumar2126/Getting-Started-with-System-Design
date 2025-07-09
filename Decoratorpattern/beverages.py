# File: beverages.py
from abc import ABC, abstractmethod

class Beverage(ABC):
    """The Component interface."""
    @abstractmethod
    def get_cost(self) -> float:
        pass

    @abstractmethod
    def get_description(self) -> str:
        pass

class SimpleCoffee(Beverage):
    """The Concrete Component."""
    def get_cost(self) -> float:
        return 2.00

    def get_description(self) -> str:
        return "Simple Coffee"