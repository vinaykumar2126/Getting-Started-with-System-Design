package splitwise.strategies;

import splitwise.strategies.SplitStrategy;

public class EqualSplitStrategy implements SplitStrategy{
    @Override
    public List<Double> split(double totalAmount, List<User> participants, Map<User, Double> metadata) {
        double share= totalAmount/participants.size();
        List<Double> splits = new ArrayList<>();
        for(User user: participants){
            splits.add(new Split(user, share)); 
        }
        return splits;
    }
}
