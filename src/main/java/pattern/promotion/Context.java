package pattern.promotion;

import java.math.BigDecimal;

/**
 * 上下文环境
 */
public class Context {

    //保存当前策略
    private IStrategy strategy;

    //设置策略
    public void setStrategy(IStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * 使用策略计算实际消费的价格
     *
     * @param consumePrice 商品应付价格
     */
    public double cul(double consumePrice) {
        //使用具体商品促销策略获得实际消费金额
        double realPrice = strategy.realPrice(consumePrice);
        //格式化保留小数点后一位, 即精确到角
        BigDecimal bd = new BigDecimal(realPrice);
        bd = bd.setScale(1, BigDecimal.ROUND_DOWN);
        return bd.doubleValue();
    }
}
