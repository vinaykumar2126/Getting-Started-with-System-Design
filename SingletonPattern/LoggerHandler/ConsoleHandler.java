package LoggerHandler;

public class ConsoleHandler extends Logger{
    public ConsoleHandler(LogLevel level){
        this.logLevel = level;
    }
    @Override
    public void write(LogLevel level, String message) {
        System.out.println("Console Logger: " + message);
       
    }
    
}
