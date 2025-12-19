package MovieTicketBookingSystem;
import java.util.List;
public class Main {

    public static void main(String[] args) {

        Show show = new Show("SHOW1", List.of("A1", "A2"));
        BookingService service = new BookingService();

        Runnable user1 = () -> {
            try {
                Booking booking = service.createBooking(show, List.of("A1"));
                booking.confirmBooking();
                System.out.println("User1: Booking successful");
            } catch (Exception e) {
                System.out.println("User1 failed: " + e.getMessage());
            }
        };

        Runnable user2 = () -> {
            try {
                Booking booking = service.createBooking(show, List.of("A1"));
                booking.confirmBooking();
                System.out.println("User2: Booking successful");
            } catch (Exception e) {
                System.out.println("User2 failed: " + e.getMessage());
            }
        };

        Thread t1 = new Thread(user1);
        Thread t2 = new Thread(user2);

        t1.start();
        t2.start();
    }
}
