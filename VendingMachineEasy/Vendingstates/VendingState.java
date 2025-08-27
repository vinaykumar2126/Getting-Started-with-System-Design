package VendingMachineEasy.Vendingstates;
import VendingMachineEasy.VendingMachineEasy;

public interface VendingState {
    void insertCoin(VendingMachineEasy vm, int cents);
    void selectProduct(VendingMachineEasy vm, int idx);
    void dispense(VendingMachineEasy vm);
}
