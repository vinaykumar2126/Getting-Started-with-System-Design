package SmartHomeAutomation;

public class Main {
    public static void main(String[] args) {
        // Get the singleton controller
        HomeController controller = HomeController.getInstance();
        Sensor motionSensor = new Sensor("Motion");
        Sensor temperatureSensor = new Sensor("Temperature");
       
        // Create devices
        Light livingRoomLight = new Light("Living Room");
        Light bedroomLight = new Light("Bedroom");
        AirConditioner livingRoomAC = new AirConditioner("Living Room");

        motionSensor.registerObserver(livingRoomLight);
        motionSensor.registerObserver(livingRoomAC);
        temperatureSensor.registerObserver(bedroomLight);
        
        // Create commands
        Command turnOnLiving = new TurnOnLightCommand(livingRoomLight);
        Command turnOnBedroom = new TurnOnLightCommand(bedroomLight);
        Command setAC = new SetACTemperatureCommand(livingRoomAC, 20);
        
        // Execute commands through controller
        System.out.println("=== Executing Commands ===");
        controller.executeCommand(turnOnLiving);
        controller.executeCommand(turnOnBedroom);
        livingRoomAC.turnOn();
        controller.executeCommand(setAC);
        
        System.out.println("\n=== Undoing Commands ===");
        turnOnLiving.undo();
        setAC.undo();
         // === PART 2: Observer Pattern (Automatic Control) ===
        System.out.println("\n\n=== Automatic Control (Observer Pattern) ===");
        
        // Simulate motion detection
        motionSensor.detectMotion();
        
        // Simulate temperature change
        temperatureSensor.setTemperature(30);  // Hot! AC should turn on
        
        // Simulate another temperature change
        temperatureSensor.setTemperature(18);  // Cold! AC should turn off
    }
}