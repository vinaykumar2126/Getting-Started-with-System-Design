package VendingMachineEasy.Vendingstates;
import VendingMachineEasy.VendingMachineEasy;

public class WaitingForSelection implements VendingState {
    public void insertCoin(VendingMachineEasy vm, int cents){
        vm.balance += cents; 
        System.out.println("Inserted: " + cents + " cents. Total: " + vm.balance);
    }
    public void selectProduct(VendingMachineEasy vm, int idx) {
        if (idx < 0 || idx >= vm.products.length) {
            System.out.println("Invalid selection.");
            return;
        }
        if (vm.balance >= vm.prices[idx]) {
            vm.balance -= vm.prices[idx];
            vm.selectedProduct = idx;
            System.out.println("Selected: " + vm.products[idx]);
            vm.setState(new Dispensing());
            vm.dispense();
        } else {
            System.out.println("Insufficient balance. Please insert more coins.");
        }
    }
    public void dispense(VendingMachineEasy vm) {
        System.out.println("Select a product first!");
    }
}