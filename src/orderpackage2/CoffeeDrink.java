package orderpackage2;

public class CoffeeDrink extends Drink{
    private boolean Hot;
    public CoffeeDrink(String drinkName, int drinkCapacity, int drinkPrice, boolean Hot) {
        super(drinkName, drinkCapacity, drinkPrice);
        this.Hot = Hot;
    }

    public boolean isHot() {
        return Hot;
    }
}
