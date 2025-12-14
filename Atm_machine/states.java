package Atm_machine;

public interface states {
    void insert_card(Atmhandler atm);
    void eject_card(Atmhandler atm); 
    void selectAmount(Atmhandler atm, int amount); 
    void enterpin(Atmhandler atm, int pin);
    void withdraw_cash(Atmhandler atm);
}
