package pattern.chain;
/**
 * ����ѧ����
 */
public class Student implements IStudent{
	/** ��ټ��� */
	private int state;
	/** ��Ϣ */
	private String message;

	public Student(int state, String message) {
		super();
		this.state = state;
		this.message = message;
	}

	@Override
	public int getState() {
		return this.state;
	}

	@Override
	public String getRequestMessage() {
		return this.message;
	}

}
