package LibraryBookAvailabilitySystem;

public class User2 implements Observer {
    private String name;
    private String role;    
    private String email;

    public User2(String name, String role, String email) {
        this.name = name;
        this.role = role;
        this.email = email;
    }

    @Override
    public void update(book b) {
        System.out.println("Notification to " + name + " (" + role + ", " + email + "): The book '" + b.getTitle() + "' is now " + b.getStatus() + ".");
    }
    
}
