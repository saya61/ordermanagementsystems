package orderpackage;

import java.util.Date;
import java.util.List;

public class OrderServiceImpl implements OrderService {

    // Order 오버라이드 하여 createOrder 메서드 생성
    @Override
    public Order createOrder(Customer customer, List<Product<Customer>> productList) {
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
        System.out.println("주문이 취소되었습니다: " + order);
    }

    private int generateOrderNumber() {
        return (int) (Math.random() * 1000) + 1;
    }
}
