package pattern.decorator.bread;
/**
 * ����װ����
 * @author 69953213
 *
 */
public class CornDecorator extends AbstractBread{

	public CornDecorator(IBread bread) {
		super(bread);
	}

	/**
	 * ���з��� Ⱦɫ
	 */
	public void paint(){
		System.out.println("Ⱦɫ");
	}
	
	//��д����ĺ��淽��  Ⱦɫ֮���ٺ���
	@Override
	public void kneadFlour() {
		this.paint();
		super.kneadFlour();
	}
}
