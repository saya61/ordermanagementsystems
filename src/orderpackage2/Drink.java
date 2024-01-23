package orderpackage2;

import java.util.HashMap;
import java.util.Map;

/**
Drink 클래스는 음료수명, 용량, 가격, 핫쿨을 받아 drinkMenu Map 에 저장
toString 을 통해 형식 오버라이드
 */

public class Drink {
    private String drinkName;   // 음료수 이름
    private int drinkCapacity;  // 음료수 용량(ML)
    private int drinkPrice; // 음료수 가격(원)
    private String drinkHot; // 뜨거운지(true) 차가운지(false)
    private String coffeeDrinkHot;  // 커피 주문시 뜨거운지 차가운지 택
    public Drink(String drinkName, int drinkCapacity, int drinkPrice) {
        this.drinkName = drinkName;
        this.drinkCapacity = drinkCapacity;
        this.drinkPrice = drinkPrice;
        this.drinkHot = "차가움";
    }

    public Drink(String drinkName, int drinkCapacity, int drinkPrice, String coffeeDrinkHot) {
        this.drinkName = drinkName;
        this.drinkCapacity = drinkCapacity;
        this.drinkPrice = drinkPrice;
//        this.coffeeDrinkHot = coffeeDrinkHot;
        setCoffeeDrinkHot(coffeeDrinkHot);
    }

    public static final Map<String, Drink> coffeeDrinkMenu = new HashMap<>();
    public static final Map<String, Drink> sodaDrinkMenu = new HashMap<>();
    public static final Map<String, Drink> adeDrinkMenu = new HashMap<>();


    static {
        sodaDrinkMenu.put("코카콜라", new Drink("코카 콜라", 500, 2200));
        sodaDrinkMenu.put("사이다", new Drink("사이다", 500, 2000));
        sodaDrinkMenu.put("펩시콜라", new Drink("펩시 콜라", 500, 1800));
        sodaDrinkMenu.put("닥터페퍼", new Drink("닥터 페퍼", 450, 2000));
        coffeeDrinkMenu.put("아메리카노", new Drink("아메리카노", 280, 3300, ""));
        coffeeDrinkMenu.put("에스프레소", new Drink("에스프레소", 60,2800, ""));
        adeDrinkMenu.put("레모네이드", new Drink("레모네이드", 330, 2200));
        adeDrinkMenu.put("파워에이드", new Drink("파워에이드", 480, 3200));
    }

    @Override
    public String toString() {
        return "음료 정보{" +
                "음료명='" + drinkName + '\'' +
                ", 용량(mL)=" + drinkCapacity +
                ", 가격(원)=" + drinkPrice +
                ", 음료온도=" + drinkHot +
                '}';
    }


    public String getDrinkName() {
        return drinkName;
    }

    public String getCoffeeDrinkHot(String coffeeDrinkHot) {
        return coffeeDrinkHot;
    }

    public void setCoffeeDrinkHot(String coffeeDrinkHot) {
        this.coffeeDrinkHot = coffeeDrinkHot;
    }
    //Drink 에서 탄산 / 커피 / 에이드에 따라 클래스 구체화(자식클래스 생성)
    //Drink 의 자식 클래스가 된 커피의 핫 또는 쿨 인터페이스화?추상화?자식클래스?
}
