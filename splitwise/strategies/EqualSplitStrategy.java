package splitwise.strategies;

import splitwise.strategies.SplitStrategy;
import splitwise.model.User;
import splitwise.model.Split;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class EqualSplitStrategy implements SplitStrategy{
    @Override
    public List<Split> split(double totalAmount, List<User> participants, Map<User, Double> metadata) {
        double share= totalAmount/participants.size();
        List<Split> splits = new ArrayList<>();
        for(User user: participants){
            splits.add(new Split(user, share)); 
        }
        return splits;
    }
}
