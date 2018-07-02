package pattern.mediator;

/**
 * �н��߽ӿ�
 *
 * @author 0xZzzz
 */
public interface IMediator {

    /**
     * �û�ע��
     *
     * @param user ע����û�
     */
    void register(IUser user);

    /**
     * ����Ϣ֪ͨ������
     *
     * @param user ������Ϣ����
     */
    void notifyAll(IUser user);
}
