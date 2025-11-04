package LoggerHandler;

public class FileHandler extends Logger{
    public FileHandler(LogLevel level){
        this.logLevel = level;
    }
    @Override
    public void write(LogLevel level, String message) {
        System.out.println("File Logger: " + message);
    }

}
        
