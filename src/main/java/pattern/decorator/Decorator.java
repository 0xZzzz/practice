package pattern.decorator;

/**
 * 装饰者类
 */
public class Decorator implements Drink {

    private Drink drink; //具体的被装饰对象

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
