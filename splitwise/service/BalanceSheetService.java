package splitwise.service;
import splitwise.model.BalanceSheet;
import splitwise.model.Split;
import splitwise.model.User;
import splitwise.model.Expense;
import splitwise.model.Group;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class BalanceSheetService {
    public void updateBalanceSheet(Group group, User paidBy, List<Split> splits){
        List<Double> amounts = new ArrayList<>();
        double totalamount = splits.stream().mapToDouble(Split::getAmount).sum();
        BalanceSheet balanceSheet = group.getBalanceSheet(paidBy);
        balanceSheet.addtotalPaid(totalamount);
        for(Split split: splits){
            User owedTo = split.getUser();
            double amt = split.getAmount();
            amounts.add(amt);
            System.out.println("Updating balance sheet: " + owedTo.getName() + " owes " + paidBy.getName() + " amount: " + amt);


            group.getBalanceSheet(owedTo).addtotalExpense(amt);
            if(owedTo!=paidBy){
                 balanceSheet.addUserBalance(owedTo, amt);
                 group.getBalanceSheet(owedTo).addUserBalance(paidBy, -amt);
            }        
            
        }
        
    }
}
