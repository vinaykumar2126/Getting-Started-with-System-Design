package SmartHomeAutomation;

public interface Command {
    void execute();
    void undo();  // Optional: to reverse the command
}
