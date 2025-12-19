package MovieTicketBookingSystem;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
public class Show {
    private String showId;
    private final Map<String,Seat> seats=new HashMap<>();

    public Show(String showId, List<String> totalSeats){
        this.showId=showId;
        for(int i=1;i<=totalSeats.size();i++){
            String seatNumber="A"+i;
            seats.put(seatNumber,new Seat(seatNumber));
        }
    }
    public Seat getSeat(String seatNumber){
        return seats.get(seatNumber);
    }
    
}
