package pattern.decorator;
/**
 * ����ı�װ���߶���
 */
public class SoyaBeanMilk implements Drink{

	@Override
	public float cost() {
		return 3F;
	}
	
	@Override
	public String desc() {
		return "������";
	}
}
