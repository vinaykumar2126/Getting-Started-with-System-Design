package Logger_System;

public class ErrorLogProcessor extends LogProcessor{
    ErrorLogProcessor(LogProcessor nextLogProcessor){
        super(nextLogProcessor);
    }

    public void log(LogLevel logLevel,String Message){
        if(logLevel==LogLevel.ERROR){
            System.out.println("Error: "+Message);
        }
        super.log(logLevel, Message);

    }
    
}
