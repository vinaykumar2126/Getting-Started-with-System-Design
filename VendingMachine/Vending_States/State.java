package VendingMachine.Vending_States;

public interface State {
   public void insertCoin(VendingMachine vm, Coin coin) throws Exception;
   public void selectProduct(VendingMachine vm, int productIndex) throws Exception;
   public void dispenseProduct(VendingMachine vm) throws Exception;
}
