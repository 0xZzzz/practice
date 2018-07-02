package pattern.chain;

/**
 * ���������ӿ�
 */
public interface IHandler {

    /**
     * ��������
     *
     * @param iStudent ѧ������
     */
    void handleRequest(IStudent iStudent);

    /**
     * ������һ��������
     *
     * @param handler ������
     */
    void setHandler(IHandler handler);
}
