package orderpackage2;

import java.util.Scanner;

public class OrderManagementCafe {
    public static void main(String[] args) {
        Customer testCustomer = new Customer("아무개", "XX", 30);
        System.out.println("안녕하십니까 " + testCustomer.getCustomerName() + "고객님. 주문하시겠습니까?");
        System.out.print("주문은 1번, 주문확인은 2번, 종료하려면 아무키나 누르세요 : ");
        Scanner scanner = new Scanner(System.in);
        int customerChoiceOrder = scanner.nextInt();
        scanner.nextLine();

        if(customerChoiceOrder == 1) {
            System.out.print("주문받겠습니다. 음료 이름을 입력하세요: ");
            String customerChoiceDrink = scanner.nextLine().trim();
            if(Drink.drinkMenu.containsKey(customerChoiceDrink)) {
                Drink selectedDrink = Drink.drinkMenu.get(customerChoiceDrink);
                Order order = new Order(selectedDrink, testCustomer);
                order.registerOrder();
                order.processOrder();
                order.deliverDrink();
            } else {
                System.out.println("죄송합니다. 저희 매장에서는 취급하지 않는 음료 입니다.");
            }
        } else if (customerChoiceOrder == 2) {
            System.out.println("주문정보를 확인합니다.");
            Order previousOrder = new Order(testCustomer);
            previousOrder.deliverDrink();
        } else {
            System.out.println("종료합니다.");
        }
    }
}
