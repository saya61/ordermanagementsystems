package orderpackage;

public class CustomerService {

    public void purchaseProduct(Customer customer, Product<Product<Customer>> product) {
        System.out.println(customer.getCustomerName() + " 고객님이 " + product + "을(를) 구매하셨습니다.");
        customer.getProductList().add(product);
    }

    public void cancelPurchase(Customer customer) {
        if (!customer.getProductList().isEmpty()) {
            Product<Product<Customer>> lastPurchasedProduct = customer.getProductList().get(customer.getProductList().size() - 1);
            System.out.println(customer.getCustomerName() + " 고객님이 가장 최근 구매한 " + lastPurchasedProduct + "의 구매를 취소하셨습니다.");
            customer.getProductList().remove(lastPurchasedProduct);
        } else {
            System.out.println(customer.getCustomerName() + " 고객님은 현재 구매한 상품이 없습니다.");
        }
    }
}
