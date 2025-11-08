package LoggerSystem;

public class Logger {
    private static Logger instance;
    private String currentLevel = "INFO";
    
    private Logger() {
        System.out.println("Logger created");
    }
    
    public String getInstanceInfo(){
        return "Logger instance: " + this.hashCode() + " | Thread: " + Thread.currentThread().getName();
    }
    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }
    
    public void setLogLevel(String level) {
        this.currentLevel = level;
    }
    
    public synchronized void error(String message) {
        if (canLog("ERROR")) {
            System.out.println("[ERROR] " + message);
        }
    }
    
    public synchronized void info(String message) {
        if (canLog("INFO")) {
            System.out.println("[INFO] " + message);
        }
    }
    
    public synchronized void debug(String message) {
        if (canLog("DEBUG")) {
            System.out.println("[DEBUG] " + message);
        }
    }
    
    private boolean canLog(String messageLevel) {
        if (currentLevel.equals("ERROR")) {
            return messageLevel.equals("ERROR");
        } else if (currentLevel.equals("INFO")) {
            return messageLevel.equals("ERROR") || messageLevel.equals("INFO");
        } else if (currentLevel.equals("DEBUG")) {
            return true;  // DEBUG shows all
        }
        return true;
    }
}
