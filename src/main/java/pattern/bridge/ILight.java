package pattern.bridge;

/**
 * �����ƽӿ�
 *
 * @author 0xZzzz
 */
public interface ILight {

    /**
     * ��Դ����
     */
    void electricConnected();

    /**
     * ����
     */
    void light();

    /**
     * �ر�
     */
    void electricClosed();
}
