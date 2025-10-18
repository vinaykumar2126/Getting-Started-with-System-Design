package TaskManager;

// Notification Observer - Sends notifications
class NotificationObserver implements Observer {
    @Override
    public void update(TaskUpdate update) {
        if (update instanceof TaskStatusUpdate) {
            TaskStatusUpdate statusUpdate = (TaskStatusUpdate) update;
            TaskManager task = statusUpdate.getTask();
            String updatedBy = statusUpdate.getUpdatedBy();
            
            // Only send notification if someone else updated the task
            if (!task.getAssignee().equals(updatedBy)) {
                System.out.println("[NOTIFICATION] Sending email to " + task.getAssignee() + 
                                  ": Task '" + task.getTitle() + "' changed to " + 
                                  statusUpdate.getNewStatus() + " by " + updatedBy);
            } else {
                System.out.println("[NOTIFICATION] No notification sent (self-update)");
            }
        }
    }
}