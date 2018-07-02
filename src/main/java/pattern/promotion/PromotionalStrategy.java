package pattern.promotion;
/**
 * �������ִ���
 */
public class PromotionalStrategy implements IStrategy {

	//����200�Ĳ��ִ����
	@Override
	public double realPrice(double consumePrice) {
		if(consumePrice > 200){
			return 200 + (consumePrice - 200) * 0.8;
		}
		return consumePrice;
	}

}
