package pattern.decorator.bread;
/**
 * ����������ͷ�ӿ�
 * @author 69953213
 *
 */
public interface IBread {
	/** ׼������ */
	void prepare();
	/** ���� */
	void kneadFlour();
	/** ����ͷ */
	void steamed();
	/** �������� */
	void process();
}
