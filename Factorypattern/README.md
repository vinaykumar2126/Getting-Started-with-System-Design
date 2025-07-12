# Juice Factory Pattern Example (Python)

This project demonstrates the **Factory Design Pattern** in Python using a simple juice example.  
The Factory Pattern helps centralize object creation, letting client code request objects without knowing their concrete classes.

---

## 📁 Project Structure

juice_factory/
│
├── interface.py # Defines the Juice interface (abstract base class)
├── mango.py # Concrete class MangoJuice implementing Juice
├── apple.py # Concrete class AppleJuice implementing Juice
├── factory.py # Factory class to create Juice objects based on type
└── main.py # Client code that uses the factory to get juice objects


---

## ⚙️ How it Works

- `interface.py` defines the abstract `Juice` class with the `serve()` method.
- `mango.py` and `apple.py` define `MangoJuice` and `AppleJuice` classes that implement `Juice`.
- `factory.py` contains `JuiceFactory` which has a method `get_juice(juice_type)` that returns the correct juice object based on the input string.
- `main.py` acts as the client, asking the factory for juice objects by name and calling their `serve()` method.

This setup **decouples** client code from specific juice implementations, making the system easy to extend and maintain.

---

## 🚀 Running the Project

1. Navigate to the project directory:
   ```bash
   cd juice_factory

python main.py

Serving Mango Juice
Serving Apple Juice
Unknown juice type
