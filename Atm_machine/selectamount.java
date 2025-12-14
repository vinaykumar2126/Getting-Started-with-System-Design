package Atm_machine;

public class Selectamount implements states{
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
        System.out.println("Amount Selected: " + amount);
        atm.setState(new Enterpin(amount,atm.getPin()));
    }
    @Override
    public void withdraw_cash(Atmhandler atm){
        System.out.println("Select Amount First");
    }
    @Override
    public void enterpin(Atmhandler atm, int pin){
        System.out.println("PIN not required");
    }
}
 
