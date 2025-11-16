/**
 * Represents the physical elevator car.
 * Manages its own state and performs basic actions like moving.
 * It is controlled by the ElevatorController.
 */
package Elevator_System;
public class ElevatorCar {
    // --- Fields ---
    private int currentFloor;
    private Direction currentDirection;
    private DoorState doorState;

    // --- Constructor ---
    public ElevatorCar() {
        // An elevator starts on the ground floor, idle, with its doors closed.
        this.currentFloor = 0; // Assuming 0 is the ground floor
        this.currentDirection = Direction.IDLE;
        this.doorState = DoorState.CLOSED;
    }

    // --- Public Methods (Actions) ---

    /**
     * Simulates the elevator moving one floor in its current direction.
     */
    public void move() {
        if (this.currentDirection == Direction.UP) {
            currentFloor++;
            System.out.println("Elevator moving UP to floor " + currentFloor);
        } else if (this.currentDirection == Direction.DOWN) {
            currentFloor--;
            System.out.println("Elevator moving DOWN to floor " + currentFloor);
        }
    }

    public void openDoor() {
        this.doorState = DoorState.OPEN;
        System.out.println("Doors are OPEN at floor " + currentFloor);
    }

    public void closeDoor() {
        this.doorState = DoorState.CLOSED;
        System.out.println("Doors are CLOSED");
    }

    // --- Getters and Setters (for the Controller to use) ---

    public int getCurrentFloor() {
        return currentFloor;
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }

    public void setCurrentDirection(Direction currentDirection) {
        this.currentDirection = currentDirection;
    }
    
    public DoorState getDoorState() {
        return doorState;
    }
}