package MovieTicketBookingSystem;

public class AvailableState implements SeatState {
    @Override
    public void block(Seat seat){
        seat.setState(new BlockedState());
        seat.setStatus(SeatStatus.BLOCKED);
    }
    @Override
    public void book(Seat seat){
        throw new IllegalStateException("Block the seat first.");
    }
    @Override
    public void release(Seat seat){
        throw new IllegalStateException("Seat is already available.");
    }
    
}
