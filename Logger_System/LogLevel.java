package Logger_System;

public enum LogLevel {
    INFO,
    // LogLevel INFO = new LogLevel(1);
    DEBUG,
    // LogLevel DEBUG = new LogLevel(2); 
    ERROR;
    // LogLevel ERROR = new LogLevel(3);

    // private final int level;  //GOOD: Protected from direct access, cant be changed
    // LogLevel(int level){
    //     this.level = level;
    // }
    // public int getLevel(){
    //     return level;
    // }
}
