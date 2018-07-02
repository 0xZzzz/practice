package pattern.promotion;

/**
 * Âú¼õ²ßÂÔ
 */
public class ReduceStrategy implements IStrategy {

    //Âú1000¼õ200
    @Override
    public double realPrice(double consumePrice) {
        if (consumePrice >= 1000) {
            return consumePrice - 200;
        }
        return consumePrice;
    }

}
