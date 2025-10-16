package AmazonNotification;

import java.util.ArrayList;
import java.util.List;

public class Product implements Subject {
    private String name;
    private boolean inStock;
    private List<Observer> observers = new ArrayList<>();
    
    public Product(String name) {
        this.name = name;
        this.inStock = false;
    }
    
    @Override
    public void subscribe(Observer observer) {
        observers.add(observer);
        System.out.println("Customer subscribed to " + name);
    }
    
    @Override
    public void unsubscribe(Observer observer) {
        observers.remove(observer);
        System.out.println("Customer unsubscribed from " + name);
    }
    
    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
    
    public void setInStock(boolean inStock) {
        if (!this.inStock && inStock) {
            System.out.println(name + " is now back in stock!");
            this.inStock = true;
            notifyObservers(name + " is now back in stock!");
        } else {
            this.inStock = inStock;
        }
    }
}