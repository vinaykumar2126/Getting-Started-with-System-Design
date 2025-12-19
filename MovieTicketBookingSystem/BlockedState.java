package MovieTicketBookingSystem;

public class BlockedState implements SeatState {
    @Override
    public void block(Seat seat){
        throw new IllegalStateException("Seat is already blocked.");
    }
    @Override
    public void book(Seat seat){
        seat.setState(new BookedState());
        seat.setStatus(SeatStatus.BOOKED);
    }    
    @Override
    public void release(Seat seat){
        seat.setState(new AvailableState());
        seat.setStatus(SeatStatus.AVAILABLE);
    }

}
