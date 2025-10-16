package AmazonNotification;

public class Main {
    public static void main(String[] args) {
        // Create products
        Product ps5 = new Product("PlayStation 5");
        Product xbox = new Product("Xbox Series X");
        
        // Create customers
        Observer johnEmail = new EmailCustomer("john@example.com");
        Observer sarahApp = new AppCustomer("Sarah");
        
        // Subscribe to products
        ps5.subscribe(johnEmail);
        ps5.subscribe(sarahApp);
        xbox.subscribe(johnEmail);
        
        // Make PS5 available
        System.out.println("\n--- Making PS5 available ---");
        ps5.setInStock(true);
        
        // Unsubscribe from PS5
        System.out.println("\n--- John unsubscribes from PS5 ---");
        ps5.unsubscribe(johnEmail);
        
        // Make Xbox available
        System.out.println("\n--- Making Xbox available ---");
        xbox.setInStock(true);
    }
}
