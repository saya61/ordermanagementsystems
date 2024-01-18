package orderpackage2;

/**
 고객 클래스
 고객의 주문을 받을 시 order() 메서드 호출
 -> Cafe 클래스의 makeDrink() 메서드 호출
 */
public class Customer {
    public Drink order() {
        return Cafe.makeDrink();
    }

    private String customerName;
    private String customerGender;
    private int customerAge;

    public Customer(String customerName, String customerGender, int customerAge) {
        this.customerName = customerName;
        this.customerGender = customerGender;
        this.customerAge = customerAge;
    }

    public String getCustomerName() {
        return customerName;
    }

    @Override
    public String toString() {
        return "고객정보{" +
                "이름='" + customerName + '\'' +
                ", 성별='" + customerGender + '\'' +
                ", 나이=" + customerAge +
                '}';
    }
}
