package orderpackage2;

import java.util.HashMap;
import java.util.Map;

public class DrinkMenu extends Drink{
    public DrinkMenu(String drinkName, int drinkCapacity, int drinkPrice) {
        super(drinkName, drinkCapacity, drinkPrice);
    }

    public static final Map<String, Map<String, Drink>> allDrinkMenus = new HashMap<>();

    public static String getDrinkMenu(String category) {
        if(allDrinkMenus.containsKey(category)) {
            return category;
        } else {
            return "알수없음";
        }
    }
    static
    {
        allDrinkMenus.put("커피", Drink.coffeeDrinkMenu);
        allDrinkMenus.put("탄산", Drink.sodaDrinkMenu);
        allDrinkMenus.put("에이드", Drink.adeDrinkMenu);
    }
}
