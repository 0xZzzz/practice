package pattern.decorator.bread;
/**
 * �����������
 */
public abstract class AbstractBread implements IBread{
	/** ά��һ������Ķ��� */
	private final IBread bread;

	public AbstractBread(IBread bread) {
		this.bread = bread;
	}
	
	@Override
	public void prepare() {
		this.bread.prepare();
	}
	
	@Override
	public void kneadFlour() {
		this.bread.kneadFlour();
	}
	
	@Override
	public void steamed() {
		this.bread.steamed();
	}
	
	@Override
	public void process() {
		this.prepare();
		this.kneadFlour();
		this.steamed();
	}
}
