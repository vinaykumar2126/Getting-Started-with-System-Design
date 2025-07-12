# Decorator Design Pattern: Coffee Shop Example

This project provides a clear, step-by-step implementation of the Decorator Design Pattern in Python. The example is based on a common analogy: a coffee shop where you start with a basic coffee and add extras like milk and sugar.

## What is the Decorator Pattern?

The Decorator pattern allows you to dynamically add new functionalities or behaviors to an object without altering its original class. It's a structural pattern that favors **composition over inheritance**. Instead of creating a massive tree of subclasses for every possible feature combination, you "wrap" a core object with decorator objects, each adding a new layer of functionality.

## Project File Structure

The code is organized into three logical files:

1.  **`beverages.py`**:
    * Defines the `Beverage` abstract base class. This acts as the common "Component" interface that both the core object and its decorators must follow.
    * Contains the `SimpleCoffee` class, our "Concrete Component." This is the basic, undecorated object we start with.

2.  **`decorators.py`**:
    * Defines the `BeverageDecorator` abstract base class. This is the blueprint for all decorators. It both **IS-A** `Beverage` (by inheritance) and **HAS-A** `Beverage` (the object it wraps).
    * Contains the concrete decorators: `MilkDecorator` and `SugarDecorator`. Each one adds its own cost and description to the beverage it wraps.

3.  **`main.py`**:
    * This is the client code and the entry point of the application. It demonstrates how to create a `SimpleCoffee` and then wrap it with decorators to build a complex beverage step-by-step.

## How to Run

1.  Ensure all three files (`beverages.py`, `decorators.py`, `main.py`) are in the same directory.
2.  Open a terminal and navigate to that directory.
3.  Run the main script:
    ```sh
    python main.py
    ```

## Detailed Code Flow Explanation

Understanding the flow of method calls is key to understanding the pattern. Let's trace the execution of `main.py`.

### Step 1: Creating the Base Object

```python
my_coffee = SimpleCoffee()

[]
.
├── beverages.py     # Defines the base interface and the core class (SimpleCoffee)
├── decorators.py    # Defines abstract decorator and concrete decorators (Milk, Sugar)
└── main.py          # Entry point: builds decorated coffee orders step by step

