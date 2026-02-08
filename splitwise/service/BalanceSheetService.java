package splitwise.service;

import java.util.List;

public class BalanceSheetService {
    public void updateBalanceSheet(Group group, User paidBy, List<Split> splits){
        double totalamount = splits.stream().mapToDouble(Split::getAmount).sum();
        BalanceSheet balanceSheet = group.getBalanceSheet(paidBy).addtotalPaid(amount);
        for(Split split: splits){
            User owedTo = split.getUser();
            double amt = split.getAmount();
            group.getBalanceSheet(owedTo).addTotalExpense(amt);
            if(owedTo!=paidBy){
                 balanceSheet.addUserBalance(owedTo, amt);
                 group.getBalanceSheet(owedTo).addUserBalance(paidBy, -amt);
            }        
            
        }
        
    }
}
