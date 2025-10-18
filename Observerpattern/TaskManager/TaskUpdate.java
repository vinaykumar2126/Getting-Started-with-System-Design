package TaskManager;

public abstract class TaskUpdate {
    private TaskManager task;
    private String updatedBy;
    private long timestamp;

    public TaskUpdate(TaskManager task){
        this.task = task;
        this.updatedBy = "System";
        this.timestamp = System.currentTimeMillis();
    }
    public TaskUpdate(TaskManager task,String updatedBy){
        this.task = task;
        this.updatedBy = updatedBy;
        this.timestamp = System.currentTimeMillis();
    }
    
    public TaskManager getTask() {
        return task;
    }
    
    public String getUpdatedBy() {
        return updatedBy;
    }
    
    public long getTimestamp() {
        return timestamp;
    }
    
    public abstract String getUpdateType();
    
}
