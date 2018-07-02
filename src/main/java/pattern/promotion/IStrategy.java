package pattern.promotion;
/**
 * 策略接口
 */
public interface IStrategy {
	/**
	 * @param consumePrice 商品的价格
	 * @return 真正应付的价格
	 */
	double realPrice(double consumePrice);
}
