package splitwise.strategies;

import java.util.List;
import java.util.Map;

import splitwise.model.User;
import splitwise.model.Split;

public interface SplitStrategy{
    List<Split> split(double amount, List<User> participants,Map<User, Double> metadata);
    
} 