package MovieTicketBookingSystem;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BookingService {
    public BookingService() {
    }
    public Booking createBooking(Show show,List<String> seats){
        List<Seat> SelectedSeats=new ArrayList<>();

        synchronized(this){
            for(String seatid:seats){
                Seat seat = show.getSeat(seatid);
                if(seat.getStatus()!=SeatStatus.AVAILABLE){
                    throw new IllegalStateException("Seat "+seat.getSeatNumber()+" is not available");
                }
                SelectedSeats.add(seat);
            }
            for(Seat seat:SelectedSeats){
                seat.block();
            }
            return new Booking(UUID.randomUUID().toString(),show,SelectedSeats);
        }
    }
}
