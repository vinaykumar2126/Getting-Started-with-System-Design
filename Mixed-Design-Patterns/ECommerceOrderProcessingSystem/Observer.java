package ECommerceOrderProcessingSystem;


public interface Observer {
    void update(Order order, Orderstatus status);
}