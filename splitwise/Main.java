package splitwise;

import java.util.Arrays;
import java.util.Map;

import splitwise.model.BalanceSheet;
import splitwise.model.Expense;
import splitwise.model.Group;
import splitwise.model.Split;
import splitwise.model.User;
import splitwise.service.BalanceSheetService;
import splitwise.service.ExpenseService;
import splitwise.service.GroupService;
import splitwise.strategies.PercentageSplitStrategy;
import splitwise.factory.SplitStrategyFactory;
import splitwise.repository.GroupRespository;
import splitwise.repository.InMemoryGroupRepository;
import splitwise.enums.SplitType;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("1", "Alice");
        User user2 = new User("2", "Bob");
        User user3 = new User("3", "Charlie");

        InMemoryGroupRepository groupRepo = new InMemoryGroupRepository();
        BalanceSheetService balanceSheetService = new BalanceSheetService();
        ExpenseService expenseService = new ExpenseService(balanceSheetService);
        GroupService groupService = new GroupService(groupRepo, balanceSheetService,expenseService);

        String groupId = groupService.createGroup("Trip", Arrays.asList(user1, user2, user3));
        groupService.addExpense(groupId, "Hotel", 300, SplitType.PERCENTAGE,user1, Map.of(user1, 50.0, user2, 30.0, user3, 20.0));

        // Print balances
        System.out.println("\n=== Balance Summary ===");
        groupService.showBalance(groupId, user1);
        groupService.showBalance(groupId, user2);
        groupService.showBalance(groupId, user3);
    }
    
}
