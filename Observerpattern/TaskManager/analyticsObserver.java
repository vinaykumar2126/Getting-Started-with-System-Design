package TaskManager;

// Analytics Observer - Tracks statistics
class AnalyticsObserver implements Observer {
    @Override
    public void update(TaskUpdate update) {
        if (update instanceof TaskStatusUpdate) {
            TaskStatusUpdate statusUpdate = (TaskStatusUpdate) update;
            TaskManager task = statusUpdate.getTask();
            
            System.out.println("[ANALYTICS] Tracking status change: " + 
                              statusUpdate.getOldStatus() + " → " + statusUpdate.getNewStatus());
            
            // In a real app, update completion metrics, track time in status, etc.
            if (statusUpdate.getNewStatus() == TaskStatus.COMPLETED) {
                System.out.println("[ANALYTICS] Task completed! Updating completion metrics and reports");
            }
        }
    }
}