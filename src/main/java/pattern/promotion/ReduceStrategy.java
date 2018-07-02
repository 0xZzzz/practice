package pattern.promotion;

/**
 * ��������
 */
public class ReduceStrategy implements IStrategy {

    //��1000��200
    @Override
    public double realPrice(double consumePrice) {
        if (consumePrice >= 1000) {
            return consumePrice - 200;
        }
        return consumePrice;
    }

}
