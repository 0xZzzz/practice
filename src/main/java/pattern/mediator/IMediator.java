package pattern.mediator;
/**
 * �н��߽ӿ�
 * @author 69953213
 *
 */
public interface IMediator {
	/**
	 * �û�ע��
	 * @param user ע����û�
	 */
	void register(IUser user);
	
	/**
	 * ����Ϣ֪ͨ������
	 * @param user ������Ϣ����
	 */
	void notifyAll(IUser user);
}
