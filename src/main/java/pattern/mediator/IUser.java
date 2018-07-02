package pattern.mediator;

/**
 * �û��ӿ�
 * @author 69953213
 *
 */
public interface IUser {
	/**
	 * ������Ϣ
	 * @param message ��Ϣ����
	 */
	void sendMessage(String message);
	
	/**
	 * ������Ϣ
	 * @param message ��Ϣ����
	 */
	void receiveMessage(String message);
	
	/**
	 * ��ȡ���͵���Ϣ
	 */
	String getMessage();
}
