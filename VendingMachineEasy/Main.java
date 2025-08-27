package VendingMachineEasy;

public class Main {
    public static void main(String[] args){
        VendingMachineEasy vm = new VendingMachineEasy();
        vm.showProducts();
        vm.selectProduct(0);              // Should ask for coins first
        vm.insertCoin(25);                // Insert quarter
        vm.insertCoin(25);                // Insert another quarter
        vm.insertCoin(10);
        vm.insertCoin(5);
        vm.selectProduct(0);  
        vm.dispense();  // Should dispense Soda and reset
        System.out.println("-----");
        vm.insertCoin(50);
        vm.selectProduct(2);  
        vm.dispense();  // Should dispense Candy and reset
    }
    
}
