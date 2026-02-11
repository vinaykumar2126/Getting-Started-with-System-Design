package splitwise.service;

import splitwise.model.BalanceSheet;
import splitwise.model.Split;
import splitwise.enums.SplitType;
import splitwise.model.User;
import splitwise.model.Expense;
import splitwise.model.Group;
import splitwise.factory.SplitStrategyFactory;
import splitwise.strategies.SplitStrategy;
import java.util.List;
import java.util.Map;
public class ExpenseService {
    private final BalanceSheetService balanceSheetService;
    public ExpenseService(BalanceSheetService balanceSheetService){
        this.balanceSheetService = balanceSheetService;
    }

    public void addExpense(Group group, String description, double amount, SplitType splitType, User paidBy, Map<User, Double> meta, List<User> participants){
        SplitStrategy splitStrategy = SplitStrategyFactory.getStrategy(splitType);
        List<Split> splits = splitStrategy.split(amount, participants, meta);
        Expense expense = new Expense(description, amount, paidBy);
        group.addExpense(expense);
        balanceSheetService.updateBalanceSheet(group, paidBy, splits);
    }
}


