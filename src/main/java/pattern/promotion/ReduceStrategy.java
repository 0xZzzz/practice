package pattern.promotion;

/**
 * 满减策略
 */
public class ReduceStrategy implements IStrategy {

    //满1000减200
    @Override
    public double realPrice(double consumePrice) {
        if (consumePrice >= 1000) {
            return consumePrice - 200;
        }
        return consumePrice;
    }

}
