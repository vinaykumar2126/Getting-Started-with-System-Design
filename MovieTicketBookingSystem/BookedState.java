package MovieTicketBookingSystem;

public class BookedState implements SeatState {
    @Override
    public void block(Seat seat){
        throw new IllegalStateException("Seat is already booked.");
    }
    @Override
    public void book(Seat seat){
        throw new IllegalStateException("Seat is already booked.");
    }
    @Override
    public void release(Seat seat){
        throw new IllegalStateException("Booked seat cannot be released directly.");
    }
    
}
