package pattern.abstractFactory;

/**
 * ����ʳ�﹤��
 */
public class ChinaKFCFactory implements IKFCFactory {

    //��������ʳ��
    @Override
    public Hamburger createHamburger(int num) {
        return new ChinaHamburger(num);
    }

    //��������ʳ��
    @Override
    public Drink createDrink(int num) {
        return new ChinaDrink(num);
    }

}
