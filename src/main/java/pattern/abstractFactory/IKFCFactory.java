package pattern.abstractFactory;

/**
 * ʳ�﹤���ӿ�
 */
public interface IKFCFactory {

    /**
     * ��������
     */
    Hamburger createHamburger(int num);

    /**
     * ��������
     */
    Drink createDrink(int num);
}
