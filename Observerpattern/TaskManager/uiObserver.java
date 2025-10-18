package TaskManager;

// UI Observer - Updates user interface
class UIObserver implements Observer {
    @Override
    public void update(TaskUpdate update) {
        if (update instanceof TaskStatusUpdate) {
            TaskStatusUpdate statusUpdate = (TaskStatusUpdate) update;
            TaskManager task = statusUpdate.getTask();
            
            System.out.println("[UI] Updating task display: " + task.getTitle() + 
                              " → " + statusUpdate.getNewStatus());
            
            // In a real app, update UI elements based on status
            switch (statusUpdate.getNewStatus()) {
                case COMPLETED:
                    System.out.println("[UI] Moving task to completed section");
                    break;
                case IN_PROGRESS:
                    System.out.println("[UI] Highlighting task as in progress");
                    break;
                case PENDING:
                    System.out.println("[UI] Placing task in backlog");
                    break;
                case OVERDUE:
                    System.out.println("[UI] Highlighting task in RED");
                    break;
            }
        }
    }
}