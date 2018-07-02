package pattern.promotion;

/**
 * 打折策略
 */
public class RebateStrategy implements IStrategy {

    //打折率
    private final double rate;

    /**
     * 构造方法初始化打折率
     *
     * @param rate
     */
    public RebateStrategy(double rate) {
        this.rate = rate;
    }

    //八折
    @Override
    public double realPrice(double consumePrice) {
        return this.rate * consumePrice;
    }

}
