package VendingMachine.Vending_States.impl;

import VendingMachine.Vending_States.State;
import VendingMachine.Vending_States.VendingMachine;
import VendingMachine.Vending_States.Coin;

public class Idle implements State {
   
   @Override
   public void insertCoin(VendingMachine vm, Coin coin) throws Exception {
        vm.addBalance(coin.getValue());
        System.out.println("Inserted " + coin + ". Balance: " + vm.getBalance() + " cents.");
        vm.setState(new SelectionState());
   }

   @Override
   public void selectProduct(VendingMachine vm, int productIndex) throws Exception {
       System.out.println("Please insert coins first!");
   }

   @Override
   public void dispenseProduct(VendingMachine vm) throws Exception {
       System.out.println("Please insert coins and select a product first!");
   }
}