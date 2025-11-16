package Elevator_System;
import java.util.TreeSet;

/**
 * The "brain" of the elevator system.
 * It receives requests and directs the ElevatorCar.
 */

public class ElevatorController {
    // --- Fields ---
    private ElevatorCar elevatorCar;
    private TreeSet<Integer> upRequests;
    private TreeSet<Integer> downRequests;

    // --- Constructor ---
    public ElevatorController(ElevatorCar elevatorCar) {
        this.elevatorCar = elevatorCar;
        this.upRequests = new TreeSet<>();
        this.downRequests = new TreeSet<>();
    }

    // --- Public methods to receive requests ---
    public void sendUpRequest(int floor) {
        System.out.println("REQUEST >> UP from floor " + floor);
        upRequests.add(floor);
    }

    public void sendDownRequest(int floor) {
        System.out.println("REQUEST >> DOWN from floor " + floor);
        downRequests.add(floor);
    }

    // --- Main processing logic ---
    /**
     * This is the core logic that is run in a loop by the simulation.
     * It decides the elevator's next move based on its state and requests.
     */
    public void processRequests() {
        Direction currentDirection = elevatorCar.getCurrentDirection();
        
        switch (currentDirection) {
            case IDLE:
                if (!upRequests.isEmpty()) {
                    elevatorCar.setCurrentDirection(Direction.UP);
                } else if (!downRequests.isEmpty()) {
                    elevatorCar.setCurrentDirection(Direction.DOWN);
                }
                break;
                
            case UP:
                if (!upRequests.isEmpty()) {
                    // Move towards the next up request.
                    if (elevatorCar.getCurrentFloor() < upRequests.first()) {
                        elevatorCar.move();
                    } else { // Arrived at the floor.
                        handleStop(upRequests);
                    }
                } else {
                    // No more up requests, switch to down or idle.
                    elevatorCar.setCurrentDirection(downRequests.isEmpty() ? Direction.IDLE : Direction.DOWN);
                }
                break;

            case DOWN:
                if (!downRequests.isEmpty()) {
                    // Move towards the next down request.
                    if (elevatorCar.getCurrentFloor() > downRequests.last()) {
                        elevatorCar.move();
                    } else { // Arrived at the floor.
                        handleStop(downRequests);
                    }
                } else {
                    // No more down requests, switch to up or idle.
                    elevatorCar.setCurrentDirection(upRequests.isEmpty() ? Direction.IDLE : Direction.UP);
                }
                break;
        }
    }

    private void handleStop(TreeSet<Integer> requests) {
        elevatorCar.openDoor();
        requests.remove(elevatorCar.getCurrentFloor());
        elevatorCar.closeDoor();
    }
}




