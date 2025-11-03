package SmartHomeAutomation;

public class HomeController {
    private static HomeController instance;
    private HomeController(){
        // Private constructor to prevent instantiation
    }
    public static HomeController getInstance(){
        if(instance==null){
            instance = new HomeController();
        }
        return instance;
    }
    public void executeCommand(Command command){
        command.execute();
    }
}
