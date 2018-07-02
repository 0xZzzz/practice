package pattern.decorator;

/**
 * 黑豆 具体的装饰者对象
 *
 * @author 0xZzzz
 */
public class BlackBeanDecorator extends Decorator {

    public BlackBeanDecorator(Drink drink) {
        super(drink);
    }

    @Override
    public float cost() {
        return super.cost() + 0.5F;
    }

    @Override
    public String desc() {
        return super.desc() + "加黑豆";
    }
}
