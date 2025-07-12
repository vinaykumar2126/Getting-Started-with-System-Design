# Abstract Factory Pattern Example (Python)

This project demonstrates the **Abstract Factory Design Pattern** in Python using a furniture example.  
The Abstract Factory Pattern allows you to create **families of related objects** without specifying their concrete classes, ensuring that the objects used together are compatible.

---

## 📁 Project Structure

abstract_factory/
│
├── chair.py # Abstract Chair class and concrete chair implementations
├── sofa.py # Abstract Sofa class and concrete sofa implementations
├── factories.py # Abstract factory and concrete factory classes for furniture
├── client.py # Client code that uses the factories to create furniture
└── main.py # Entry point to run the example


---

## ⚙️ How it Works

- `chair.py` defines the abstract `Chair` class and concrete `ModernChair` and `VictorianChair` classes.
- `sofa.py` defines the abstract `Sofa` class and concrete `ModernSofa` and `VictorianSofa` classes.
- `factories.py` contains the abstract `FurnitureFactory` and concrete factories `ModernFurnitureFactory` and `VictorianFurnitureFactory`, which create matching families of furniture.
- `client.py` contains client code that works with any furniture factory to create and use chair and sofa objects.
- `main.py` runs the client code with different furniture factories.

This design ensures the client code is decoupled from concrete classes and can easily switch between furniture families.

---

## 🚀 Running the Project

1. Navigate to the project directory:
   ```bash
   cd abstract_factory

python main.py

Modern furniture:
Sitting on a modern chair
Lying on a modern sofa

Victorian furniture:
Sitting on a Victorian chair
Lying on a Victorian sofa
