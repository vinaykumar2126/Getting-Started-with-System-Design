package Atm_machine;

public class Enterpin implements states{
    private int pin;
    private int amount;
    public Enterpin(int amount,int pin){
        this.pin = pin;
        this.amount = amount;
        
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
    public void selectAmount(Atmhandler atm, int amount){
        System.out.println("Amount already selected");
    }
    @Override
    public void enterpin(Atmhandler atm, int pin){
        System.out.println("PIN entered");
        if(this.pin != pin){
            System.out.println("Incorrect PIN");
            atm.eject_card();
            return;
        }else{
            System.out.println("PIN Verified");
            atm.setState(new withdraw(this.amount));
        }
        
    }
    @Override
    public void withdraw_cash(Atmhandler atm){
        System.out.println("PIN Verified");
        
    }
    
}
