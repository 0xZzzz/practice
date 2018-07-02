package pattern.abstractFactory;

/**
 * ������ �ͻ�
 */
public class Customer {

    private IKFCFactory ikfcFactory;

    /**
     * ���췽����ʼ������
     *
     * @param ikfcFactory ʳ�﹤��
     */
    public Customer(IKFCFactory ikfcFactory) {
        this.ikfcFactory = ikfcFactory;
    }

    /**
     * ����ʳ��
     *
     * @param num ����
     * @return �ܼ�
     */
    public double orderHamburger(int num) {
        //��������
        Hamburger hamburger = ikfcFactory.createHamburger(num);
        //��ӡ��Ϣ
        hamburger.printInfo();
        //�����ܼ�
        return hamburger.totalPrice();
    }

    /**
     * ����ʳ��
     *
     * @param num ����
     * @return �ܼ�
     */
    public double orderDrink(int num) {
        //��������
        Drink drink = ikfcFactory.createDrink(num);
        //��ӡ��Ϣ
        drink.printInfo();
        //�����ܼ�
        return drink.totalPrice();
    }
}
