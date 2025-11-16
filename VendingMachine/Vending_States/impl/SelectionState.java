package VendingMachine.Vending_States.impl;

import VendingMachine.Vending_States.State;
import VendingMachine.Vending_States.VendingMachine;
import VendingMachine.Vending_States.Coin;
import VendingMachine.Vending_States.Product;

public class SelectionState implements State {
   
   @Override
   public void insertCoin(VendingMachine vm, Coin coin) throws Exception {
        vm.addBalance(coin.getValue());
        System.out.println("Inserted " + coin + ". Balance: " + vm.getBalance() + " cents.");
        // Stay in same state - can insert more coins
   }

   @Override
   public void selectProduct(VendingMachine vm, int productIndex) throws Exception {
        Product p = vm.getProduct(productIndex);
        if (p == null) {
            System.out.println("Invalid product selection.");
            return;
        }
        
        if (vm.getBalance() >= p.getPrice()) {
            vm.setSelectedProductIndex(productIndex);
            vm.setState(new DispenseState());
            System.out.println("Selected " + p.getName() + ". Dispensing...");
            vm.dispenseProduct();
        } else {
            System.out.println("Insufficient balance for " + p.getName() + 
                             ". Price: " + p.getPrice() + " cents. Your balance: " + 
                             vm.getBalance() + " cents.");
        }
   }

   @Override
   public void dispenseProduct(VendingMachine vm) throws Exception {
       System.out.println("Please select a product first!");
   }
}