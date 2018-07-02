package pattern.decorator;
/**
 * ��  �����װ���߶���
 */
public class SugarDecorator extends Decorator{

	public SugarDecorator(Drink drink) {
		super(drink);
	}

	@Override
	public float cost() {
		return super.cost()+0.5F;
	}
	
	@Override
	public String desc() {
		return super.desc()+"����";
	}
}
