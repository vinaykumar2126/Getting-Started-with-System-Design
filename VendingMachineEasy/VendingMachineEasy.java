package VendingMachineEasy;
import VendingMachineEasy.Vendingstates.*;
public class VendingMachineEasy{
    public VendingState state;
    public int balance = 0;
    public int selectedProduct = -1;
    public String[] products = {"Soda", "Chips", "Candy"};
    public int[] prices = {65, 50, 35};

    public VendingMachineEasy(){
        state = new WaitingForCoins();
    }
    public void setState(VendingState newState) {
        state = newState;
    }
    public void insertCoin(int cents) {
        state.insertCoin(this, cents);
    }
    public void selectProduct(int idx) {
        state.selectProduct(this, idx);
    }
    public void dispense() {
        state.dispense(this);
    }
    public void showProducts() {
        for (int i = 0; i < products.length; i++)
            System.out.println(i + ": " + products[i] + " (" + prices[i] + " cents)");
    }
}
