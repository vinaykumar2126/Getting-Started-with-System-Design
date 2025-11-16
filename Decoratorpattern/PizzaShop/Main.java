package PizzaShop;

public class Main {
    public static void main(String args[]){
        Pizza p = new SimplePizza();
        p = new Addchicken(p);
        System.out.println("Total Price: " + p.getTotalPrice());
    }   
}
