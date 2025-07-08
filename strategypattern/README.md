## Without strategy pattern
- Here `Vehicle.java` is the parent and it has defined a method drive.
- `SportsVehicle.java` and `OffRoadVehicle.java` are using /Sports vehicle drive capability/ which is not in parent so we r not reusing the code but we r duplicating the code.
-Every time you want new behavior, you create a new subclass

## WithStrategyPattern
-Here Vehicle.java does not define the drive behavior directly — instead, it holds a reference to a DriveStrategy interface.

-Concrete classes like SportsDriveStrategy and NormalDriveStrategy implement different driving behaviors independently.

-SportsVehicle.java and OffRoadVehicle.java now reuse the same strategy object (SportsDriveStrategy) — no duplication of logic.

-To add a new driving style, you simply create a new strategy class (e.g., HybridDriveStrategy) — no need to touch or subclass Vehicle.

-This approach follows the Open/Closed Principle, improves code reuse, and makes the system more flexible and scalable.

## Interface:
-An interface is like a contract that says:
-"Any class that implements me must provide the following methods."
-It only defines method signatures, not actual code or behavior.
-Supports multiple inheritence.