package Logger_System;

public abstract class LogProcessor {
    // public static int INFO = 1;
    // public static int ERROR = 3;
    // public static int DEBUG = 2;

    LogProcessor nextLogProcessor;

    LogProcessor(LogProcessor loggerProcessor){
        this.nextLogProcessor = loggerProcessor;
    }
     public void log(LogLevel logLevel,String Message){
        if(nextLogProcessor!=null){
            nextLogProcessor.log(logLevel, Message);
        }
     }
    
}
