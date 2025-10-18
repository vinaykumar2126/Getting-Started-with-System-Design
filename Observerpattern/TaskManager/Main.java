package TaskManager;

import java.time.LocalDate;

public class Main {
    public static void main(String args[]){
        
        // Create task
        TaskManager task = new TaskManager(
            "Implement Login Page", 
            "Create a responsive login page with validation", 
            LocalDate.now().plusDays(3),
            "john@example.com"
        );
        Observer uiObserver = new UIObserver();
        Observer notificationObserver = new NotificationObserver();
        Observer analyticsObserver = new AnalyticsObserver();
        
        // Register observers
        System.out.println("Registering observers...");
        task.attach(uiObserver);
        task.attach(notificationObserver);
        task.attach(analyticsObserver);
        
         // Update task status - first change
        System.out.println("\nUpdating task to IN_PROGRESS by John...");
        task.updateStatus(TaskStatus.IN_PROGRESS, "john@example.com");
        
        // Someone else updates the task
        System.out.println("\nUpdating task to COMPLETED by manager@example.com...");
        task.updateStatus(TaskStatus.COMPLETED, "manager@example.com");
        
        // Unsubscribe the UI observer
        System.out.println("\nDetaching UI observer...");
        task.detach(uiObserver);
        
        // Update again - UI should not be notified
        System.out.println("\nUpdating task to PENDING by admin@example.com...");
        task.updateStatus(TaskStatus.PENDING, "admin@example.com");
    }
}

