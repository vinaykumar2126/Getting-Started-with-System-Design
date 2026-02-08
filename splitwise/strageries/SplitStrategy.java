package splitwise.strategies;

import java.util.List;

import ChatApplication.User;

public interface SplitStrategy{
    List<Double> split(double amount, List<User> participants,Map<User, Double> metadata);
    
} 