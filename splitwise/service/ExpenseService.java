package splitwise.service;

import splitwise.model.BalanceSheet;
import splitwise.model.Split;

public class ExpenseService {
    private final BalanceSheetService balanceSheetService;

    public void addExpense(Group group, String description, double amount, SplitType splitType, User paidBy, List<User, Double> meta, List<User> participants){
        Split split = SplitStrategyFactory.getSplitStrategy(splitType);
        List<Split> splits = split.split(amount, participants, meta);
        Expense expense = new Expense(description, amount, paidBy, splits, splitType);
        group.addExpense(expense);
        balanceSheetService.updateBalanceSheet(expense);
    }
}
