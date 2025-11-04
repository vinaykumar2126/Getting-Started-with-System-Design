package LoggerHandler;

public class Main {
    public static void main(String args[]){
        LoggerController loggerController = LoggerController.getInstance();
        loggerController.logMessage(LogLevel.INFO, "This is an info message.");
        loggerController.logMessage(LogLevel.ERROR, "This is an error message.");
    }
    
}

