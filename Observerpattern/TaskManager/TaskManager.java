package TaskManager;
import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;

public class TaskManager implements Subject{
    private String title;
    private String description;
    private TaskStatus status; // PENDING, IN_PROGRESS, COMPLETED, OVERDUE
    private LocalDate dueDate;
    private String assignee;
    private List<Observer> observers;

    public TaskManager(String title, String description, LocalDate dueDate, String assignee){
        this.title = title;
        this.description = description;
        this.status = TaskStatus.PENDING; // Default status
        this.dueDate = dueDate;
        this.assignee = assignee;
        this.observers = new ArrayList<>();

    }
        // Getters
    public String getTitle() {
        return title;
    }
    
    public String getDescription() {
        return description;
    }
    
    public TaskStatus getStatus() {
        return status;
    }
    
    public LocalDate getDueDate() {
        return dueDate;
    }
    
    public String getAssignee() {
        return assignee;
    }

    // Setters
    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public void setDueDate(LocalDate dueDate) {
        LocalDate oldDueDate = this.dueDate;
        this.dueDate = dueDate;
        // You could notify observers about date change here
    }
    
    public void setAssignee(String assignee) {
        String oldAssignee = this.assignee;
        this.assignee = assignee;
        // You could notify observers about assignment change here
    }
    
    // Update task status
    public void updateStatus(TaskStatus newStatus) {
        TaskStatus oldStatus = this.status;
        this.status = newStatus;
        notifyObservers(new TaskStatusUpdate(this, oldStatus, newStatus));
    }
    // Update task status with user who made the change
    public void updateStatus(TaskStatus newStatus, String updatedBy) {
        TaskStatus oldStatus = this.status;
        this.status = newStatus;
        notifyObservers(new TaskStatusUpdate(this, oldStatus, newStatus, updatedBy));
    }
    
    // Subject interface methods
    @Override
    public void attach(Observer observer) {
        observers.add(observer);
        System.out.println("Observer attached to task: " + title);
    }
    
    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
        System.out.println("Observer detached from task: " + title);
    }
    
    @Override
    public void notifyObservers(TaskUpdate update) {
        System.out.println("Notifying " + observers.size() + " observers about update to task: " + title);
        for (Observer observer : observers) {
            observer.update(update);
        }
    }
    @Override
    public String toString() {
        return "Task: " + title + " (" + status + ")";
    }
}
    

    

