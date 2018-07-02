package pattern.decorator;
/**
 * 具体的被装饰者对象
 */
public class SoyaBeanMilk implements Drink{

	@Override
	public float cost() {
		return 3F;
	}
	
	@Override
	public String desc() {
		return "纯豆浆";
	}
}
