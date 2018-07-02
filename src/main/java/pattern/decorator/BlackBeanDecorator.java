package pattern.decorator;

/**
 * �ڶ� �����װ���߶���
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
        return super.desc() + "�Ӻڶ�";
    }
}
