package pattern.decorator;

/**
 * 糖 具体的装饰者对象
 *
 * @author 0xZzzz
 */
public class SugarDecorator extends Decorator {

    public SugarDecorator(Drink drink) {
        super(drink);
    }

    @Override
    public float cost() {
        return super.cost() + 0.5F;
    }

    @Override
    public String desc() {
        return super.desc() + "加糖";
    }
}
