package SmartHomeAutomation;

public class SetACTemperatureCommand implements Command {
    private AirConditioner ac;
    private int newTemperature;
    private int previousTemperature;
    
    public SetACTemperatureCommand(AirConditioner ac, int temperature) {
        this.ac = ac;
        this.newTemperature = temperature;
    }
    
    @Override
    public void execute() {
        previousTemperature = ac.getTemperature();
        ac.setTemperature(newTemperature);
    }
    
    @Override
    public void undo() {
        ac.setTemperature(previousTemperature);
    }
}