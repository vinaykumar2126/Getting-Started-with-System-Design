package PizzaShop;

public class Addchicken extends PizzaDecorator{
    public Addchicken(Pizza p){
        super(p);
    }
    @Override
    public double getTotalPrice() {
        return p.getTotalPrice() + 50.0;
    }

}
    

