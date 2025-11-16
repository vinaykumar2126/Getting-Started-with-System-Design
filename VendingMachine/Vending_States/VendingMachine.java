package VendingMachine.Vending_States;

import VendingMachine.Vending_States.impl.Idle;

public class VendingMachine {
    private State state;
    private int balance;
    private int selectedProductIndex = -1;
    private final Product[] products = {
        new Product("Soda", 65),
        new Product("Chips", 50),
        new Product("Candy", 35)
    };

    public VendingMachine() {
        this.state = new Idle();
    }

    // Getters and Setters
    public void setState(State state) { 
        this.state = state; 
    }
    
    public int getBalance() { 
        return balance; 
    }
    
    public void addBalance(int amount) { 
        balance += amount; 
    }
    
    public void setSelectedProductIndex(int idx) { 
        selectedProductIndex = idx; 
    }
    
    public int getSelectedProductIndex() { 
        return selectedProductIndex; 
    }
    
    public Product getProduct(int idx) {
        if (idx < 0 || idx >= products.length) return null;
        return products[idx];
    }

    // Display methods
    public void displayProducts() {
        System.out.println("--- Available Products ---");
        for (int i = 0; i < products.length; i++) {
            System.out.println(i + ": " + products[i].getName() + 
                             " (" + products[i].getPrice() + " cents)");
        }
        System.out.println("Current Balance: " + balance + " cents");
        System.out.println();
    }

    // State-delegated methods
    public void insertCoin(Coin coin) {
        try {
            state.insertCoin(this, coin);
        } catch (Exception e) {
            System.out.println("Error inserting coin: " + e.getMessage());
        }
    }
    
    public void selectProduct(int idx) {
        try {
            state.selectProduct(this, idx);
        } catch (Exception e) {
            System.out.println("Error selecting product: " + e.getMessage());
        }
    }
    
    public void dispenseProduct() {
        try {
            state.dispenseProduct(this);
        } catch (Exception e) {
            System.out.println("Error dispensing product: " + e.getMessage());
        }
    }

    // Reset machine
    public void reset() {
        balance = 0;
        selectedProductIndex = -1;
        setState(new Idle());
    }
}