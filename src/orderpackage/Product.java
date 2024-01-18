package orderpackage;

import java.util.ArrayList;
import java.util.List;

public class Product<CUSTOMER_UNIT> {

    private int productNumber;
    private String productName;
    private int productPrice;
    private String productManufacturer;
    private List<CUSTOMER_UNIT> customerList;

    public Product(int productNumber, String productName, int productPrice, String productManufacturer) {
        this.productNumber = productNumber;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productManufacturer = productManufacturer;
        this.customerList = new ArrayList<>();
    }

    @Override
    public String toString() {
        return " 상품 번호 = " + productNumber +
                ", 상품 이름 = '" + productName + '\'' +
                ", 상품 가격 = " + productPrice + "원" +
                ", 제조사 = '" + productManufacturer + '\'' +
                " \n";
    }
}
