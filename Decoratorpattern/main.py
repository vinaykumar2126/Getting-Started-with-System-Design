# main.py
# Note: This file assumes you have beverages.py and decorators.py in the same directory.

from beverages import SimpleCoffee
from decorators import MilkDecorator, SugarDecorator

if __name__ == "__main__":
    # 1. Start with a basic, undecorated coffee
    my_coffee = SimpleCoffee()
    print(f"Order 1: {my_coffee.get_description()} | Cost: ${my_coffee.get_cost():.2f}")

    # 2. Decorate the coffee with Milk
    my_coffee = MilkDecorator(my_coffee)
    print(f"Order 2: {my_coffee.get_description()} | Cost: ${my_coffee.get_cost():.2f}")

    # 3. Decorate it further with Sugar
    my_coffee = SugarDecorator(my_coffee)
    print(f"Order 3: {my_coffee.get_description()} | Cost: ${my_coffee.get_cost():.2f}")

    print("\n--- Another Order ---")

    # Or, create a fully decorated coffee in one go
    another_coffee = SugarDecorator(MilkDecorator(SimpleCoffee()))
    cost = another_coffee.get_cost()
    description = another_coffee.get_description()
    print(f"Final Order: {description} | Cost: ${cost:.2f}")