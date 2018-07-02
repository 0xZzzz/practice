package pattern.promotion;

/**
 * ���۲���
 */
public class RebateStrategy implements IStrategy {

    //������
    private final double rate;

    /**
     * ���췽����ʼ��������
     *
     * @param rate
     */
    public RebateStrategy(double rate) {
        this.rate = rate;
    }

    //����
    @Override
    public double realPrice(double consumePrice) {
        return this.rate * consumePrice;
    }

}
