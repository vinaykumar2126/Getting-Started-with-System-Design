package LoggerSystem;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        
        logger.error("This is error");
        logger.info("This is info");
        logger.debug("This is debug");
        
        System.out.println("--- Set to ERROR level ---");
        logger.setLogLevel("ERROR");
        logger.error("Error shows");
        logger.info("Info hidden");
        logger.debug("Debug hidden");
    }
}