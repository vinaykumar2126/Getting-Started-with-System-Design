package splitwise.strategies;
import splitwise.strategies.SplitStrategy;
import splitwise.model.User;
import splitwise.model.Split;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
public class PercentageSplitStrategy implements SplitStrategy {
    @Override
    public List<Split> split(double totalAmount, List<User> participants, Map<User, Double> metadata) {
        System.out.println("Splitting by percentage");
        double totalPercentage = metadata.values().stream().mapToDouble(Double::doubleValue).sum();
        List<Split> splits = new ArrayList<>();
        for(User user : participants){
            double percentage = metadata.get(user);
            double amount = (percentage / totalPercentage) * totalAmount;
            splits.add(new Split(user, amount)); 
        }
        return splits;
    }
    
}
