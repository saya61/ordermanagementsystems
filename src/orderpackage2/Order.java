package orderpackage2;

public class Order {

    private boolean registered; // 주문이 등록되었는지 검사
    private boolean processed; // 주문이 접수되었는지 검사
    private boolean delivered; // 고객에게 도착했는지 검사
    private Drink orderedDrink; // 주문 받은 음료수
    private Customer customer;
    private int count;  // 랜덤 제작실패 count 횟수 체크용

    public Order(Drink orderedDrink, Customer customer) {
        this.orderedDrink = orderedDrink;
        this.customer = customer;
    }
    public Order(Customer customer) {
        this.customer = customer;
    }

    public void registerOrder() {
        if (!registered) {
            registered = true;
            System.out.println("음료수 주문이 등록되었습니다.");
        } else {
            System.out.println("\n이미 주문이 등록되었습니다.");
        }
    }
    public void processOrder() {
        if (registered && !processed) {
            boolean randomIsOk = false; //  do while 문으로 madeDrink.equals(orderedDrink) 체크
            processed = true;
            do {
                Drink madeDrink = Cafe.makeDrink();
                if(madeDrink.equals(orderedDrink)) {
                    System.out.println(orderedDrink.getDrinkName() + " 음료를 만들었습니다.");
                    randomIsOk = true;
                } else {
                    count++;
                    System.out.println(count);
                    customer.order();
                }
            } while(!randomIsOk);
        } else if (!registered) {
            System.out.print(customer.getCustomerName()+" 고객님 ");
            System.out.println("음료 주문이 먼저 해야합니다.");
        } else {
            System.out.println("\n이미 주문이 처리되었습니다.");
        }
    }
    public void deliverDrink() {
        if (processed && !delivered) {
            delivered = true;
            System.out.println("음료가 고객에게 배달되었습니다.");
            System.out.print("고객 정보: " + customer);
            System.out.println(" 주문 정보: " + orderedDrink);
        } else if (!processed) {
            System.out.print(customer.getCustomerName()+" 고객님 ");
            System.out.println("음료 주문이 먼저 해야합니다.");
        } else {
            System.out.println("\n이미 " + orderedDrink.getDrinkName() + "가 배달되었습니다.");
        }
    }
}

