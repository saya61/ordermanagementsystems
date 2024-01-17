package orderpackage;

import java.util.Date;
import java.util.List;

public class OrderServiceImpl implements OrderService {

    @Override
    public Order createOrder(Customer customer, List<Product<Product<Customer>>> productList) {
        // Implement your order creation logic here
        int orderNumber = generateOrderNumber();
        String orderName = "신규 주문";
        Date orderDate = new Date();
        String orderType = "Online";
        Order order = new Order(orderNumber, orderName, orderDate, productList, orderType);
        System.out.println("주문 조회 완료");

        return order;
    }


    @Override
    public void cancelOrder(Order order) {
        // Implement order cancellation logic here
        System.out.println("주문이 취소되었습니다: " + order);
    }

    private int generateOrderNumber() {
        // Implement order number generation logic
        return (int) (Math.random() * 1000) + 1;
    }
}
