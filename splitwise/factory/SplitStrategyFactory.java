package splitwise.factory;
import splitwise.enums.SplitType;
import splitwise.model.Expense;
import splitwise.model.Split;
import splitwise.model.User;
import splitwise.strategies.EqualSplitStrategy;
import splitwise.strategies.SplitStrategy;
import splitwise.strategies.PercentageSplitStrategy;

public class SplitStrategyFactory {
    public static SplitStrategy getStrategy(SplitType splitType){
        switch(splitType){
            case EQUAL:
                return new EqualSplitStrategy();
            case PERCENTAGE:
                return new PercentageSplitStrategy();
            default:
                throw new IllegalArgumentException("Invalid split type");
        }
    }
    
}
 