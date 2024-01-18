package orderpackage;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

// Order 의 Product 리스트를 제네릭타입으로 받아옴.
public class Order<PRODUCT_TYPE extends Product> {
    private int orderNumber;
    private String orderName;
    private Date orderDate;
    private List<PRODUCT_TYPE> products;
    private String orderType;

    public Order(int orderNumber, String orderName, Date orderDate, List<PRODUCT_TYPE> products, String orderType) {
        this.orderNumber = orderNumber;
        this.orderName = orderName;
        this.orderDate = orderDate;
        this.products = products;
        this.orderType = orderType;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");  // 날짜 출력 타입 변경
        String formattedDate = sdf.format(orderDate);

        return "주문 상세내역입니다.\n" +
                "주문 번호 = " + orderNumber +
                ", 주문 이름 = '" + orderName + '\'' +
                ", 주문 날짜 = " + formattedDate +
                ", 주문 방식 = '" + orderType + '\'' +
                ", 상세 상품 내역 입니다. " + products;
    }
}
