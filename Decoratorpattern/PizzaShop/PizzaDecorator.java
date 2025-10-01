package PizzaShop;

public abstract class PizzaDecorator implements Pizza{
    protected Pizza p;
    public PizzaDecorator(Pizza p){
        this.p = p;
        
    }
}
