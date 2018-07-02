package pattern.decorator;
/**
 * ���� �����װ���߶���
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
		return super.desc()+"�Ӽ���";
	}
}
