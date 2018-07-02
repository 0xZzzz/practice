package pattern.decorator;
/**
 * 鸡蛋 具体的装饰者对象
 */
public class EggDecorator extends Decorator{

	public EggDecorator(Drink drink) {
		super(drink);
	}
	
	@Override
	public float cost() {
		return super.cost()+1.0F;
	}
	
	@Override
	public String desc() {
		return super.desc()+"加鸡蛋";
	}
}
