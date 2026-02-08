package splitwise.strategies;

public class PercentageSplitStrategy implements SplitStrategy {
    @Override
    public List<Double> split(double totalAmount, List<User> participants, Map<User, Double> metadata) {
        System.out.println("Splitting by percentage");
        return null;
    }
    
}
