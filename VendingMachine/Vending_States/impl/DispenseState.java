package VendingMachine.Vending_States.impl;

import VendingMachine.Vending_States.Product;
import VendingMachine.Vending_States.State;
import VendingMachine.Vending_States.VendingMachine;
import VendingMachine.Vending_States.Coin;

public class DispenseState implements State {
   
   @Override
   public void insertCoin(VendingMachine vm, Coin coin) throws Exception {
       System.out.println("Product is being dispensed. Please wait.");
   }

   @Override
   public void selectProduct(VendingMachine vm, int productIndex) throws Exception {
       System.out.println("Product is being dispensed. Please wait.");
   }

   @Override
   public void dispenseProduct(VendingMachine vm) throws Exception {
       Product p = vm.getProduct(vm.getSelectedProductIndex());
       if (p != null) {
           System.out.println("Dispensed: " + p.getName());
           int change = vm.getBalance() - p.getPrice();
           if (change > 0) {
               System.out.println("Change returned: " + change + " cents.");
           }
           vm.reset();
           System.out.println("Transaction complete. Machine ready for next customer.");
       }
   }
}