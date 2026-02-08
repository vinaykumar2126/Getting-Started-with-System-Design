package splitwise.model;

import java.util.HashMap;
import java.util.Map;

import ChatApplication.User;
 
@Getter
public class Group {
    private final String id;
    private final String name;
    private final List<User> members = new ArrayList<>();
    private final List<Expense> expenses = new ArrayList<>();
    private final Map<User, BalanceSheet> balanceSheet = new HashMap<>();


    public Group(String id, String name){
        this.id = id;
        this.name = name;
    }

    public void addMember(User user){}
    public void addExpense(Expense expense){
        expense.add(expense);
    }

    public BalanceSheet getBalanceSheet(User user){
        return balanceSheet.get(user);
    }
    
}
