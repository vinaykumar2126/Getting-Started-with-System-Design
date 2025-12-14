package Atm_machine;

public class Atmhandler{
    private int balance = 1000;
    private int pin = 1234;
    private states currentState;
    public Atmhandler(){
        currentState = new idle();
    }
    public int getPin(){
        return pin;
    }   
    public void setState(states state){
        this.currentState = state;
    }
    public void setBalance(int balance){
        this.balance = balance;
    }
    public int getBalance(){
        return balance;
    }
    public void insert_card(){
        currentState.insert_card(this);
    }
    public void eject_card(){
        currentState.eject_card(this);
    }
    public void selectAmount(int amount){
        currentState.selectAmount(this, amount);
    }
    public void withdraw_cash(){
        currentState.withdraw_cash(this);
    }
    public void enterpin(int pin){
        currentState.enterpin(this, pin);
    }
}
    
    




