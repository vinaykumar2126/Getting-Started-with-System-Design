package VendingMachine;

import VendingMachine.Vending_States.*;

public class Main {
    public static void main(String[] args) {
        VendingMachine vm = new VendingMachine();
        vm.displayProducts();
        
        System.out.println("=== Transaction 1 ===");
        vm.insertCoin(Coin.QUARTER);
        vm.insertCoin(Coin.QUARTER);
        vm.insertCoin(Coin.DIME);
        vm.insertCoin(Coin.NICKEL);
        vm.selectProduct(0); // Should select and dispense Soda
        
        System.out.println("\n=== Transaction 2 ===");
        vm.insertCoin(Coin.QUARTER);
        vm.insertCoin(Coin.QUARTER);
        vm.selectProduct(2); // Should say insufficient balance
        vm.insertCoin(Coin.DIME);
        vm.selectProduct(2); // Should select and dispense Candy
    }
}