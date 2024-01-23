package orderpackage2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Map;

/**
음료수를 만들 때 마다
Drink 클래스를 호출
Drink 클래스에서 만들어진 Map drinkMenu 의 values 값을 배열 형식으로 랜덤 뽑기
*/

public class Cafe {
    private static boolean drinkMessagePrinted = false;     //  랜덤 음료 제작 실패시 makeDrink 메서드가 재호출 될 때 '음료수를 만듭니다.' 출력문 반복안되게끔

    public static Drink makeDrink() {
        if (!drinkMessagePrinted) {
            System.out.println("음료수를 만듭니다.");
            drinkMessagePrinted = true;
        }

        List<String> drinkCategories = new ArrayList<>(DrinkMenu.allDrinkMenus.keySet());
        String randomDrinkCategory = drinkCategories.get(new Random().nextInt(drinkCategories.size()));

        Map<String, Drink> drinkCategory = DrinkMenu.allDrinkMenus.get(randomDrinkCategory);
        List<Drink> drinks = new ArrayList<>(drinkCategory.values());

        return drinks.get(new Random().nextInt(drinks.size()));
    }
}