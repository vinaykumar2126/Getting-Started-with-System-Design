package Logger_System;

public class Main {
    public static void main(String args[]){
        LogProcessor Logobject = new InfoLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));
        Logobject.log(LogLevel.ERROR, "Execption happended");
        Logobject.log(LogLevel.DEBUG, "Debugging the code");
        Logobject.log(LogLevel.INFO, "Info log message");

    }
    
}
