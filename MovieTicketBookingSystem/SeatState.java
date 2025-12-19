package MovieTicketBookingSystem;

public interface SeatState {
    void block(Seat seat);
    void book(Seat seat);
    void release(Seat seat);
}
