package splitwise.model;


import java.util.List;
@Getter
public class Expense {
    private final String description;
    private final double amount;
    private final User paidBy;
    private final List<Split> splits;
    private final SplitType splitType;

}



