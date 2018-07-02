package pattern.decorator.bread;

/**
 * ����������ͷ�ӿ�
 *
 * @author 0xZzzz
 */
public interface IBread {

    /**
     * ׼������
     */
    void prepare();

    /**
     * ����
     */
    void kneadFlour();

    /**
     * ����ͷ
     */
    void steamed();

    /**
     * ��������
     */
    void process();
}
