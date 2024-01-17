package orderpackage;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String customerName;
    private List<Product<Product<Customer>>> productList;

    public Customer(String customerName) {
        this.customerName = customerName;
        this.productList = new ArrayList<>();
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<Product<Product<Customer>>> getProductList() {
        return productList;
    }
}
