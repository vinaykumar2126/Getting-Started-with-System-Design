package LoggerHandler;

public class LoggerController {
    private static LoggerController instance;
    private Logger logger;

    private LoggerController() {
        // Initialize with a default logger, e.g., ConsoleHandler
        Logger consoleLogger = new ConsoleHandler(LogLevel.INFO);
        Logger fileLogger = new FileHandler(LogLevel.INFO);
        Logger dbLogger = new DbHandler(LogLevel.WARN);
        consoleLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(dbLogger);

        this.logger = consoleLogger;
    }

    public static LoggerController getInstance() {
        if (instance == null) {
            instance = new LoggerController();
        }
        return instance;
    }
    public void logMessage(LogLevel level, String message){
        logger.log(level, message);
    }
    
}
