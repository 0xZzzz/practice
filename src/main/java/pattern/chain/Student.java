package pattern.chain;
/**
 * 具体学生类
 */
public class Student implements IStudent{
	/** 请假级别 */
	private int state;
	/** 消息 */
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
