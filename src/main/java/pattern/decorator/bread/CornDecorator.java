package pattern.decorator.bread;
/**
 * 玉米装饰者
 * @author 69953213
 *
 */
public class CornDecorator extends AbstractBread{

	public CornDecorator(IBread bread) {
		super(bread);
	}

	/**
	 * 特有方法 染色
	 */
	public void paint(){
		System.out.println("染色");
	}
	
	//重写父类的和面方法  染色之后再和面
	@Override
	public void kneadFlour() {
		this.paint();
		super.kneadFlour();
	}
}
