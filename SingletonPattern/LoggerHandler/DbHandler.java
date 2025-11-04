package LoggerHandler;

public class DbHandler extends Logger{
    public DbHandler(LogLevel level){
        this.logLevel = level;
    }
    @Override
    public void write(LogLevel level, String message) {
        System.out.println("Database Logger: " + message);
    }
    
}
