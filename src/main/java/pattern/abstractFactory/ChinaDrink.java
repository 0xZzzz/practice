package pattern.abstractFactory;

/**
 * ����������
 */
public class ChinaDrink extends Drink {

    /**
     * ���췽����ʼ��ֵ
     *
     * @param num ����
     */
    public ChinaDrink(int num) {
        this.setKind("����");
        this.setPrice(2.5);
        this.setNum(num);
    }

}
