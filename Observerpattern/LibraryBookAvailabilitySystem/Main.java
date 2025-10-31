package LibraryBookAvailabilitySystem;

public class Main {
    public static void main(String[] args) {
        // Create books
        book b1 = new book("Can't hurt me", Bookstatus.checked_out);
        book b2 = new book("Atomic Habits", Bookstatus.checked_out);

        // Create users
        User1 u1 = new User1("Vinay", "Student", "vinay@example.com");
        User2 u2 = new User2("John", "Student", "john@example.com");

        // Users subscribe to books
        b1.registerObserver(u1);
        b1.registerObserver(u2);
        b2.registerObserver(u2); // John is waiting for both books

        // Change book status and notify observers
        b1.setStatus(Bookstatus.available);      // Notifies Vinay and John for "Can't hurt me"
        b2.setStatus(Bookstatus.available);      // Notifies John for "Atomic Habits"
        b1.setStatus(Bookstatus.checked_out);    // Notifies Vinay and John for "Can't hurt me"
    }
}