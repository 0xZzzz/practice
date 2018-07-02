package pattern.decorator;

/**
 * װ������
 */
public class Decorator implements Drink {

    private Drink drink; //����ı�װ�ζ���

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
