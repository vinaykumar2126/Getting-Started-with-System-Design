package MovieTicketBookingSystem;

import java.util.List;

public class Booking {
    private final String bookingId;
    private final Show show;
    private final List<Seat> seats;
    private BookingStatus status;

    public Booking(String bookingId, Show show, List<Seat> seats){
        this.bookingId = bookingId;
        this.show = show;
        this.seats = seats;
        this.status = BookingStatus.INITIATED;
    }
    public synchronized void confirmBooking(){
        for(Seat seat : seats){
            seat.book();
        }
        status = BookingStatus.CONFIRMED;
    }
    public synchronized void cancelBooking(){
        for(Seat seat : seats){
            seat.release();
        }
        status = BookingStatus.CANCELLED;
    }
}
