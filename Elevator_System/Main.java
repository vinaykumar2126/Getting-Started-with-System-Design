/**
 * The driver class to start and simulate the elevator system.
 */
package Elevator_System;
public class Main {
    public static void main(String[] args) {
        // --- 1. SETUP ---
        System.out.println("Starting the elevator system...");
        ElevatorCar elevatorCar = new ElevatorCar();
        ElevatorController controller = new ElevatorController(elevatorCar);

        // --- 2. ADD REQUESTS ---
        // These are the requests that come in before the elevator starts moving.
        controller.sendUpRequest(5);
        controller.sendUpRequest(3);
        controller.sendDownRequest(6);

        // --- 3. RUN SIMULATION ---
        // We will simulate 20 seconds (or 20 "ticks") of the elevator running.
        for (int i = 0; i < 20; i++) {
            System.out.println("--- Time Tick " + (i + 1) + " ---");
            // In each tick of time, the controller processes the requests.
            controller.processRequests();
        }
    }
}