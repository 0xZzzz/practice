package enumeration;
/**
 * java��ͨ��ģ��ʵ��ö��
 * @author 69953213
 *
 */
public abstract class SimulateSexEnum {
	/** ���췽��˽�л� */
	private SimulateSexEnum(){}
	
	/** ���������ڲ����ʵ�ַ�ʽ���Լ��ٺܶ�if�ж� */
	public static final SimulateSexEnum MALE = new SimulateSexEnum() {
		@Override
		protected SimulateSexEnum negation() {
			return FEMALE;
		}
		
	};
	//Ů��
	public static final SimulateSexEnum FEMALE = new SimulateSexEnum() {
		@Override
		protected SimulateSexEnum negation() {
			return MALE;
		}
	};
	/** ȡ�� */
	protected abstract SimulateSexEnum negation();
	
	@Override
	public String toString(){
		return this == MALE? "MALE" : "FEMALE";
	}
}
