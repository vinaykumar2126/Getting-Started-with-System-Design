package Logger_System;

public class InfoLogProcessor extends LogProcessor {
    InfoLogProcessor(LogProcessor nextLogProcessor){
        super(nextLogProcessor);
    }
    public void log(LogLevel logLevel,String Message){
        if(logLevel==LogLevel.INFO){
            System.out.println("Info: "+Message);
        }
        super.log(logLevel, Message);
    }
    
}
