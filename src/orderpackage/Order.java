package orderpackage;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Order<PRODUCT_TYPE extends Product<?>> {
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

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public List<PRODUCT_TYPE> getProducts() {
        return products;
    }

    public void setProducts(List<PRODUCT_TYPE> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String formattedDate = sdf.format(orderDate);

        return "주문 상세내역입니다.\n" +
                "주문 번호 = " + orderNumber +
                ", 주문 이름 = '" + orderName + '\'' +
                ", 주문 날짜 = " + formattedDate +
                ", 주문 방식 = '" + orderType + '\'' +
                ", 상품 내역 = " + products +
                '}';
    }
}
