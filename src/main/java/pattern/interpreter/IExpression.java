package pattern.interpreter;
/**
 * ���ʽ�ӿ�
 */
public interface IExpression {
	/**
	 * ����
	 * @param context ������
	 */
	void parse(Context context);
	
	/**
	 * ִ��
	 */
	void interpret();
}
