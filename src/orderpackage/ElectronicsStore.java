package orderpackage;

import java.util.Scanner;

public class ElectronicsStore {

    public static void main(String[] args) {
        OrderService orderService = new OrderServiceImpl();
        CustomerService customerService = new CustomerService();

        // 고객 생성
        Customer customer1 = new Customer("율곡");
        Customer customer2 = new Customer("홍길동");

        // 상품 정보 생성
        Product<Customer> product1 = new Product<>(1, "SMARTPHONE", 1_700_000, "SAMSUNG");
        Product<Customer> product2 = new Product<>(2, "TV", 5_000_000, "LG");
        Product<Customer> product3 = new Product<>(3, "COMPUTER", 2_800_000, "Apple");
        Product<Customer> product4 = new Product<>(4, "CAMERA", 800_000, "Sony");

        // 미리 고객에게 상품 추가
        customer1.getProductList().add(product1);
        customer2.getProductList().add(product2);
        customer2.getProductList().add(product3);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. 상품 구매");
            System.out.println("2. 구매 취소");
            System.out.println("3. 주문 내역 조회");
            System.out.println("4. 종료");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // 상품 구매
                    System.out.println("고객을 선택하세요 (1: 율곡, 2: 홍길동):");
                    int customerChoice = scanner.nextInt();
                    Customer selectedCustomer = (customerChoice == 1) ? customer1 : customer2;

                    System.out.println("구매할 상품을 선택하세요 (1: P1, 2: P2, 3: P3, 4: P4):");
                    int productChoice = scanner.nextInt();
                    Product<Customer> selectedProduct;
                    switch (productChoice) {
                        case 1:
                            selectedProduct = product1;
                            break;
                        case 2:
                            selectedProduct = product2;
                            break;
                        case 3:
                            selectedProduct = product3;
                            break;
                        case 4:
                            selectedProduct = product4;
                            break;
                        default:
                            System.out.println("잘못된 상품 선택입니다.");
                            continue;
                    }

                    customerService.purchaseProduct(selectedCustomer, selectedProduct);
                    break;
                case 2:
                    // 구매 취소
                    System.out.println("고객을 선택하세요 (1: 율곡, 2: 홍길동):");
                    customerChoice = scanner.nextInt();
                    selectedCustomer = (customerChoice == 1) ? customer1 : customer2;

                    customerService.cancelPurchase(selectedCustomer);
                    break;
                case 3:
                    // 주문 내역 조회
                    System.out.println("고객을 선택하세요 (1: 율곡, 2: 홍길동):");
                    customerChoice = scanner.nextInt();
                    selectedCustomer = (customerChoice == 1) ? customer1 : customer2;

                    Order order = orderService.createOrder(selectedCustomer, selectedCustomer.getProductList());

                    System.out.println(order);
                    System.out.println("주문 조회 완료");
                    break;
                case 4:
                    // 종료
                    System.exit(0);
                    break;
                default:
                    System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
            }
        }
    }
}
