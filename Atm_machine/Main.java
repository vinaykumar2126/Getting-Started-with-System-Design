package Atm_machine;
public class Main{
    public static void main(String[] args){
        Atmhandler atm = new Atmhandler();
        atm.insert_card();
        atm.selectAmount(200);
        atm.enterpin(1234);
        atm.withdraw_cash();
        // atm.eject_card();
    }
}




