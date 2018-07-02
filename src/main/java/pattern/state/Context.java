package pattern.state;
/**
 * �����Ļ���
 */
public class Context {
	//Ԥ��ģʽ
	public static final int PREVIEW_MODE = 0;
	//�༭ģʽ
	public static final int EDIT_MODE = 1;
	//���浱ǰ״̬
	private IState state;
	//�ı�״̬
	public void changeState(IState state){
		this.state = state;
	}
	//����
	public void doWork(int mode){
		System.out.println("---------------------");
		this.state.convertState(this, mode);
		this.state.add(this);
		this.state.save(this);
		this.state.modify(this);
		this.state.view(this);
		System.out.println("---------------------");
	}
}
