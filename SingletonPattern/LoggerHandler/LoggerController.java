package LoggerHandler;

public class LoggerController {
    private static LoggerController instance;
    private Logger logger;

    private LoggerController() {
        // Initialize with a default logger, e.g., ConsoleHandler
        logger = new ConsoleHandler(LogLevel.INFO);
        Logger fileLogger = new FileHandler(LogLevel.INFO);
        Logger dbLogger = new DbHandler(LogLevel.WARN);
        logger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(dbLogger);

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
