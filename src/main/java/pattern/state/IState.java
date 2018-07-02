package pattern.state;
/**
 * ״̬�ӿ�
 */
public interface IState {
	//״̬ת��
	void convertState(Context context, int mode);
	//���淽��
	void save(Context context);
	//�޸ķ���
	void modify(Context context);
	//��������
	void add(Context context);
	//�鿴����
	void view(Context context);
}
