package VendingMachineEasy.Vendingstates;

import VendingMachineEasy.VendingMachineEasy;

public class Dispensing implements VendingState {
    public void insertCoin(VendingMachineEasy vm, int cents) {
        System.out.println("Please wait, dispensing product...");
    }
    public void selectProduct(VendingMachineEasy vm, int idx) {
        System.out.println("Please wait, dispensing product...");
    }
    public void dispense(VendingMachineEasy vm) {
        System.out.println("Dispensing: " + vm.products[vm.selectedProduct]);
        if (vm.balance > 0) {
            System.out.println("Returning change: " + vm.balance + " cents.");
        }
        vm.balance = 0;
        vm.selectedProduct = -1;
        vm.setState(new WaitingForCoins());
    }
}

