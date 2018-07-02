package pattern.promotion;

import java.math.BigDecimal;

/**
 * �����Ļ���
 */
public class Context {

    //���浱ǰ����
    private IStrategy strategy;

    //���ò���
    public void setStrategy(IStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * ʹ�ò��Լ���ʵ�����ѵļ۸�
     *
     * @param consumePrice ��ƷӦ���۸�
     */
    public double cul(double consumePrice) {
        //ʹ�þ�����Ʒ�������Ի��ʵ�����ѽ��
        double realPrice = strategy.realPrice(consumePrice);
        //��ʽ������С�����һλ, ����ȷ����
        BigDecimal bd = new BigDecimal(realPrice);
        bd = bd.setScale(1, BigDecimal.ROUND_DOWN);
        return bd.doubleValue();
    }
}
