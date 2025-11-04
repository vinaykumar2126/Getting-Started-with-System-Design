package LoggerHandler;

public enum LogLevel {
    INFO(1),
    WARN(2),
    ERROR(3);

    private int level;

    LogLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}
