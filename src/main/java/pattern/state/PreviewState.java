package pattern.state;
/**
 * Ԥ��ģʽ
 */
public class PreviewState implements IState {

	//״̬ת��
	@Override
	public void convertState(Context context, int mode) {
		if(mode == Context.EDIT_MODE){
			context.changeState(new EditState());
		}
	}
	//Ԥ��ģʽ����
	@Override
	public void save(Context context) {
		System.out.println("Ԥ��ģʽ��֧��[����]����!");
	}
	//Ԥ��ģʽ�޸�
	@Override
	public void modify(Context context) {
		System.out.println("Ԥ��ģʽ��֧��[�޸�]����!");
	}
	//Ԥ��ģʽ���
	@Override
	public void add(Context context) {
		System.out.println("Ԥ��ģʽ��֧��[����]����!");
	}
	//Ԥ��ģʽ�鿴
	@Override
	public void view(Context context) {
		System.out.println("Ԥ��ģʽ[�鿴]...");
	}

}
