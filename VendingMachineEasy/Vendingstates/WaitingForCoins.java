package VendingMachineEasy.Vendingstates;

import VendingMachineEasy.VendingMachineEasy;

public class WaitingForCoins implements VendingState {
    public void insertCoin(VendingMachineEasy vm, int cents) {
        vm.balance += cents;
        System.out.println("Inserted: " + cents + " cents. Total: " + vm.balance);
        vm.setState(new WaitingForSelection());
    }
    public void selectProduct(VendingMachineEasy vm, int idx) {
        System.out.println("Please insert coins first!");
    }
    public void dispense(VendingMachineEasy vm) {
        System.out.println("Insert coins and select product first!");
    }
}