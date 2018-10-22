package pattern.decorator;

/**
 * 装饰者类
 *
 * @author 0xZzzz
 */
public class Decorator implements Drink {

    private Drink drink;

    public Decorator(Drink drink) {
        this.drink = drink;
    }

    @Override
    public float cost() {
        return drink.cost();
    }

    @Override
    public String desc() {
        return drink.desc();
    }

}
