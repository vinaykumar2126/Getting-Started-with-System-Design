package TaskManager;

public class TaskStatusUpdate extends TaskUpdate{
    private TaskStatus oldStatus;
    private TaskStatus newStatus;

    public TaskStatusUpdate(TaskManager task, TaskStatus oldStatus,TaskStatus newStatus){
        super(task);
        this.oldStatus = oldStatus;
        this.newStatus = newStatus;

    }
    public TaskStatusUpdate(TaskManager task, TaskStatus oldStatus,TaskStatus newStatus, String updatedBy){
        super(task, updatedBy);
        this.oldStatus = oldStatus;
        this.newStatus = newStatus;

    }
     public TaskStatus getOldStatus() {
        return oldStatus;
    }
    
    public TaskStatus getNewStatus() {
        return newStatus;
    }
    
    @Override
    public String getUpdateType() {
        return "STATUS_CHANGE";
    }
    
    @Override
    public String toString() {
        return "Task '" + getTask().getTitle() + "' status changed from " + 
                oldStatus + " to " + newStatus + " by " + getUpdatedBy();
    }
}

