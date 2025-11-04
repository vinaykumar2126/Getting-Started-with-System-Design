package LoggerHandler;

public abstract class Logger {
    protected LogLevel logLevel;
    protected Logger nextLogger;    

    public void setNextLogger(Logger nextLogger) {
        this.nextLogger = nextLogger;
    }
    public void log(LogLevel level, String message) {
        if (this.logLevel.getLevel() <= level.getLevel()) {
            write(level, message);
        }
        if (nextLogger != null) {
            nextLogger.log(level, message);
        }
    }



    public abstract void write(LogLevel level, String message);
    
}
