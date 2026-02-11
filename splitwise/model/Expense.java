package splitwise.model;
import splitwise.model.User;

import java.util.List;

public class Expense {
    private final String description;
    private final double amount;
    private final User paidBy;
    // private final List<Split> splits;
    // private final SplitType splitType;

    public Expense(String description, double amount, User paidBy){
        this.description = description;
        this.amount = amount;
        this.paidBy = paidBy;
        // this.splits = splits;
        // this.splitType = splitType;
    }

}



