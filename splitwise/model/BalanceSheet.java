package splitwise.model;

@Getter
public class BalanceSheet {
    private double totalPaid = 0.0;    // Total amount paid by the user
    private double totalExpense = 0.0; // Total share of the user 
    private final Map<User,Double> userBalances = new HashMap<>(); // Map of other users and the amount owed to or by them(positive means others owed to the user, negative means others owed by the user)

    public void addtotalPaid(double amount){
        totalPaid += amount;
    }
    public void addtotalExpense(double amount){
        totalExpense += amount;
    }
    public void adduserBalance(User user, double amount){
        userBalances.put(user, userBalances.getOrDefault(user, 0.0) + amount);
    }
    public BalanceSheet getBalanceSheet(){
        return this;
    }

    public void settleBalance(User user, double amount){
        userBalances.put(user, userBalances.getOrDefault(user, 0.0) - amount);
    }
    public void clearBalance(){
        userBalances.clear();
    }

    
}

  