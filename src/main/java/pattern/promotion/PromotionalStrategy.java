package pattern.promotion;
/**
 * 超出部分打折
 */
public class PromotionalStrategy implements IStrategy {

	//超出200的部分打八折
	@Override
	public double realPrice(double consumePrice) {
		if(consumePrice > 200){
			return 200 + (consumePrice - 200) * 0.8;
		}
		return consumePrice;
	}

}
