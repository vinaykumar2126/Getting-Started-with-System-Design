package LibraryBookAvailabilitySystem;

public class User1 implements Observer {
    private String name;
    private String role;
    private String email;

    public User1(String name, String role, String email) {
        this.name = name;
        this.role = role;
        this.email = email;
    }

    @Override
    public void update(book b) {
        System.out.println(name + " notified: '" + b.getTitle() + "' is now " + b.getStatus());
    }
}