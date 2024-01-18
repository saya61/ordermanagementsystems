package orderpackage;

import java.util.List;

public interface OrderService {
    Order createOrder(Customer customer, List<Product<Customer>> productList);
    void cancelOrder(Order order);
}
