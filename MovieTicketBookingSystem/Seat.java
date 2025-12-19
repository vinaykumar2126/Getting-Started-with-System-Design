package MovieTicketBookingSystem;

public class Seat {
    private final String seatNumber;
    private SeatState state;
    private SeatStatus status;

    public Seat(String seatNumber){
        this.seatNumber = seatNumber;
        this.state = new AvailableState();
        this.status = SeatStatus.AVAILABLE;
    }
    public synchronized void block(){
        state.block(this);
    }
    public synchronized void book(){
        state.book(this);
    }
    public synchronized void release(){
        state.release(this);
    }
    public void setState(SeatState state){
        this.state = state;
    }
    public void setStatus(SeatStatus status){
        this.status = status;
    }
    public SeatStatus getStatus(){
        return status;
    }
    public String getSeatNumber(){
        return this.seatNumber;
    }
   
}
