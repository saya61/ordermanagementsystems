package orderpackage2;

import java.util.Map;
import java.util.Scanner;

/**
 * 실행순서
 * 1. 환영인사 및 로그인(미리 생성 및 정의된 Customer 객체와 동일비교)
 * <p>
 * 2. 주문하기 혹은 주문내역(기존 주문내역 존재X - null) 조회
 * <p>
 * 3. 탄산 / 커피 / 에이드 중 택1
 * 3-1. 각 음료 카테고리에 대한 자세한 음료 1개 이상 선택
 * 3-2. 만약 커피를 골랐을 시 Hot or Cool 까지 선택(eg. 탄산-코카콜라 / 커피-Hot-아메리카노)
 * <p>
 * 4. 결제방법 선택(카드시 기존 가격, 현금시 10%메서드 호출)
 * <p>
 * 5. 주문 상세 내역 확인
 * 5-1. 처음 고객정보 출력
 * 5-2. 주문 정보 출력(단, 음료 이름과 가격만 출력)
 * 5-3. 결제방법 출력
 * 5-4. 총 금액 출력 및 종료
 */
public class OrderManagementCafe {
    public static void main(String[] args) {
        Customer testCustomer = new Customer("아무개", "XX", 30);  // 임시 고객 생성
        System.out.println("안녕하십니까 " + testCustomer.getCustomerName() + "고객님. 주문하시겠습니까?");
        System.out.print("주문은 1번, 주문확인은 2번, 종료하려면 아무키나 누르세요 : ");
        Scanner scanner = new Scanner(System.in);
        int customerChoiceOrder = scanner.nextInt();    // int 값으로 1,2 or 그 외의 키 입력으로 시작 메뉴 조작
        scanner.nextLine();

        if (customerChoiceOrder == 1) {
            System.out.print("음료 카테고리를 고르시오(커피, 탄산, 에이드): ");
            String customerChoiceDrinkCategory = scanner.nextLine();     // Drink 카테고리 조작용 scanner, Coffee, Soda, Ade
            String drinkCategory = DrinkMenu.getDrinkMenu(customerChoiceDrinkCategory);

            System.out.print("음료 이름을 입력하세요: ");
            String customerChoiceDrink = scanner.nextLine();

            switch (drinkCategory) {
                case ("커피"):
                    System.out.print("Hot, Ice 중 하나를 고르세요. ");
                    String coffeeHotOrIce = scanner.nextLine();
                    handleCoffeeOrder(customerChoiceDrink, testCustomer, coffeeHotOrIce);
                    break;
                case ("탄산"):
                    handleSodaOrder(customerChoiceDrink, testCustomer);
                    break;
                case ("에이드"):
                    handleAdeOrder(customerChoiceDrink, testCustomer);
                    break;
                default:
                    System.out.println("죄송합니다. 저희 매장에서는 취급하지 않는 음료 카테고리 입니다.");
            }
        } else if (customerChoiceOrder == 2) {
            System.out.println("주문정보를 확인합니다.");
            Order previousOrder = new Order(testCustomer);
            previousOrder.deliverDrink();
        } else {
            System.out.println("종료합니다.");
        }
    }

    private static void handleCoffeeOrder(String drinkName, Customer customer, String hotOrIce) {
        if (CoffeeDrink.coffeeDrinkMenu.containsKey(drinkName)) {
            Drink selectedDrink = Drink.coffeeDrinkMenu.get(drinkName);

            Order order = new Order(selectedDrink, customer, selectedDrink.getCoffeeDrinkHot(hotOrIce));
            order.registerOrder();
            order.processOrder();
            order.deliverDrink();
        } else {
            System.out.println("죄송합니다. 저희 매장에서는 취급하지 않는 커피 종류입니다.");
        }
    }

    private static void handleSodaOrder(String drinkName, Customer customer) {
        if (SodaDrink.sodaDrinkMenu.containsKey(drinkName)) {
            Drink selectedDrink = Drink.sodaDrinkMenu.get(drinkName);

            Order order = new Order(selectedDrink, customer);
            order.registerOrder();
            order.processOrder();
            order.deliverDrink();
        } else {
            System.out.println("죄송합니다. 저희 매장에서는 취급하지 않는 탄산 종류입니다.");
        }
    }

    private static void handleAdeOrder(String drinkName, Customer customer) {
        if (AdeDrink.adeDrinkMenu.containsKey(drinkName)) {
            Drink selectedDrink = Drink.adeDrinkMenu.get(drinkName);

            Order order = new Order(selectedDrink, customer);
            order.registerOrder();
            order.processOrder();
            order.deliverDrink();
        } else {
            System.out.println("죄송합니다. 저희 매장에서는 취급하지 않는 에이드 종류입니다.");
        }
    }
}
