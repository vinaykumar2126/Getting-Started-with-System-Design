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
        
        // ✅ Wait for threads to complete
        try {
            Thread.sleep(1000);  // Wait 1 second for threads to finish
        } catch (InterruptedException e) {}
        
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