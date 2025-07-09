# File: decorators.py
from beverages import Beverage

class BeverageDecorator(Beverage):
    """The base Decorator class."""
    _wrapped_beverage: Beverage = None

    def __init__(self, beverage: Beverage) -> None:
        self._wrapped_beverage = beverage

    def get_cost(self) -> float:
        return self._wrapped_beverage.get_cost()

    def get_description(self) -> str:
        return self._wrapped_beverage.get_description()

class MilkDecorator(BeverageDecorator):
    """Concrete Decorator for Milk."""
    def get_cost(self) -> float:
        return super().get_cost() + 0.50

    def get_description(self) -> str:
        return super().get_description() + ", Milk"

class SugarDecorator(BeverageDecorator):
    """Concrete Decorator for Sugar."""
    def get_cost(self) -> float:
        return super().get_cost() + 0.25

    def get_description(self) -> str:
        return super().get_description() + ", Sugar"