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
    private boolean drinkHot; // 음료수가 뜨거운지(true) 차가운지(false)
    public Drink(String drinkName, int drinkCapacity, int drinkPrice, boolean drinkHot) {
        this.drinkName = drinkName;
        this.drinkCapacity = drinkCapacity;
        this.drinkPrice = drinkPrice;
        this.drinkHot = drinkHot;
    }

    public boolean isHot() {
        return drinkHot;
    }

    public boolean isCold() {
        return !drinkHot;
    }

    public static final Map<String, Drink> drinkMenu = new HashMap<>();
    static {
        drinkMenu.put("코카콜라", new Drink("코카 콜라", 500, 2200, false));
        drinkMenu.put("사이다", new Drink("사이다", 500, 2000, false));
        drinkMenu.put("펩시콜라", new Drink("펩시 콜라", 500, 1800, false));
        drinkMenu.put("닥터페퍼", new Drink("닥터 페퍼", 450, 2000, false));
        drinkMenu.put("아메리카노", new Drink("따뜻한 아메리카노", 280, 3300, true));
        drinkMenu.put("에스프레소", new Drink("따뜻한 에스프레소", 60,2800, true));
    }

    @Override
    public String toString() {
        return "음료 정보{" +
                "음료명='" + drinkName + '\'' +
                ", 용량(mL)=" + drinkCapacity +
                ", 가격(원)=" + drinkPrice +
                ", 뜨거운가?=" + drinkHot +
                '}';
    }

    public String getDrinkName() {
        return drinkName;
    }
}
