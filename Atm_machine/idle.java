package Atm_machine;

public class idle implements states{
    @Override
    public void insert_card(Atmhandler atm){
        System.out.println("Card Inserted");
        atm.setState(new Selectamount());
    }
    @Override
    public void eject_card(Atmhandler atm){
        System.out.println("Ejecting Card");
    }
    @Override
    public void selectAmount(Atmhandler atm, int amount){
        System.out.println("Insert Card First");
    }
    @Override
    public void withdraw_cash(Atmhandler atm){
        System.out.println("Insert Card First");
    }
    @Override
    public void enterpin(Atmhandler atm, int pin){
        System.out.println("Insert Card First");
    }
}