package LoggerSystem;

public class Main {
    public static void main(String[] args) {
        for(int i = 0;i<10;i++){
            final int threadNum = i;
            new Thread(()->{
                Logger logger = Logger.getInstance();
                logger.info("Thread"+ threadNum+"-"+logger.getInstanceInfo());
            }).start();
        }
        
        
        // logger.error("This is error");
        // logger.info("This is info");
        // logger.debug("This is debug");
        
        // System.out.println("--- Set to ERROR level ---");
        // logger.setLogLevel("ERROR");
        // logger.error("Error shows");
        // logger.info("Info hidden");
        // logger.debug("Debug hidden");
    }
}