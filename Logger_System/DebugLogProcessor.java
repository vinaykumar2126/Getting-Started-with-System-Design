package Logger_System;

public class DebugLogProcessor extends LogProcessor{
    DebugLogProcessor(LogProcessor nextLogProcessor){
        super(nextLogProcessor);
    }

    public void log(LogLevel logLevel,String Message){
        if(logLevel==LogLevel.DEBUG){
            System.out.println("Debug: "+Message);
        }
        super.log(logLevel, Message);

    }
}