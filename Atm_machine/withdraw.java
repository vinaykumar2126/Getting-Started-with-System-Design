package Atm_machine;

public class withdraw implements states{
    private int amount;
    // private Atmhandler atm;
    public withdraw(int amount){
        this.amount = amount;
        System.out.println("Withdrawing Cash");
    }
    @Override
    public void insert_card(Atmhandler atm){
        System.out.println("Card already inserted");
    }
    @Override
    public void eject_card(Atmhandler atm){
        System.out.println("Ejecting Card");
        atm.setState(new idle());
    }
    @Override
    public void selectAmount(Atmhandler atm,int amount){
        System.out.println("Amount already selected");
    }
    @Override
    public void withdraw_cash(Atmhandler atm){
        int balance = atm.getBalance()-amount;
        atm.setBalance(balance);
        if(balance>=0){
            System.out.println("Please collect your cash: " + amount);
            System.out.println("Remaining Balance: " + balance);
            atm.eject_card();
        }else{
            System.out.println("Insufficient Balance");
        }

        atm.setState(new idle());
    }
    @Override
    public void enterpin(Atmhandler atm, int pin){
        System.out.println("PIN not required");
    }
}
    




