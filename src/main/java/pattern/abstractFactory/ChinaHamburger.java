package pattern.abstractFactory;

/**
 * ���庺����
 */
public class ChinaHamburger extends Hamburger {

    /**
     * ���췽����ʼ��ֵ
     *
     * @param num ����
     */
    public ChinaHamburger(int num) {
        this.setKind("����");
        this.setPrice(5.5);
        this.setNum(num);
    }

}
