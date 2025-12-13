package Atm_machine;

public class withdraw extends Atmhandler{
    private int balance=2000;
    @Override
    public void move(int amount){
        if(balance-amount>=0){
            balance=balance-amount;
            System.out.println("Please collect your cash " + amount);
        }
        else{                                                                               
            System.out.println("Withdrawal failed due to insufficient balance");
        }
    }
}
    



