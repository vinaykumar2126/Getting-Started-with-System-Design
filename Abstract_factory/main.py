from factories import ModernFurnitureFactory, VictorianFurnitureFactory
from client import client_code

if __name__ == "__main__":
    print("Modern furniture:")
    client_code(ModernFurnitureFactory())

    print("\nVictorian furniture:")
    client_code(VictorianFurnitureFactory())
