package splitwise.service;

import splitwise.model.Split;
import splitwise.model.User;
import splitwise.model.Expense;
import splitwise.model.Group;
import splitwise.enums.SplitType;
import splitwise.repository.GroupRespository;
import splitwise.factory.SplitStrategyFactory;
import splitwise.model.BalanceSheet;
import java.util.List;
import java.util.Map;
import java.util.UUID;
public class GroupService {
    private final GroupRespository repo;
    private final ExpenseService expenseService;
    public BalanceSheetService balanceSheetService;

    public GroupService(GroupRespository repo, BalanceSheetService balanceSheetService, ExpenseService expenseService){
        this.repo = repo;
        this.expenseService = expenseService;
        this.balanceSheetService = balanceSheetService;
    }
    public String createGroup(String name, List<User> members){
        String id = UUID.randomUUID().toString();
        Group group = new Group(id, name);
        for(User member: members){
            group.addMember(member);
        }
        repo.save(group);
        return id;
    }
    public void addExpense(String groupId, String description, double amount, SplitType splitType, User paidBy, Map<User, Double> meta){
        Group group = repo.findById(groupId).orElseThrow(() -> new RuntimeException("Group not found"));
        List<User> participants = group.getMembers();
        Expense expense = new Expense(description, amount, paidBy);
        group.addExpense(expense);
        expenseService.addExpense(group, description, amount, splitType, paidBy, meta, participants);
        System.out.println("Expense added: " + description + " Amount: " + amount + " Paid by: " + paidBy.getName());
        repo.save(group);
    }
    public void showBalance(String groupId, User user){
    Group group = repo.findById(groupId).orElseThrow(() -> new RuntimeException("Group not found"));
    BalanceSheet balanceSheet = group.getBalanceSheet(user);
    
    System.out.println("\n=== Balance for " + user.getName() + " ===");
    System.out.println("Total Paid: " + balanceSheet.getTotalPaid());
    System.out.println("Total Expense: " + balanceSheet.getTotalExpense());
    System.out.println("Net Balance: " + (balanceSheet.getTotalPaid() - balanceSheet.getTotalExpense()));
    
    System.out.println("\nBalances with others:");
    for (User other : group.getMembers()) {
        if (!other.equals(user)) {
            double balance = balanceSheet.get(other);
            if (balance > 0) {
                System.out.println(other.getName() + " owes " + user.getName() + ": " + balance);
            } else if (balance < 0) {
                System.out.println(user.getName() + " owes " + other.getName() + ": " + Math.abs(balance));
            }
        }
    }
}
}


