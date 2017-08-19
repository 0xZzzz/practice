package enumeration;
/**
 * java普通类模拟实现枚举
 * @author 69953213
 *
 */
public abstract class SimulateSexEnum {
	/** 构造方法私有化 */
	private SimulateSexEnum(){}
	
	/** 运用这种内部类的实现方式可以减少很多if判断 */
	public static final SimulateSexEnum MALE = new SimulateSexEnum() {
		@Override
		protected SimulateSexEnum negation() {
			return FEMALE;
		}
		
	};
	//女性
	public static final SimulateSexEnum FEMALE = new SimulateSexEnum() {
		@Override
		protected SimulateSexEnum negation() {
			return MALE;
		}
	};
	/** 取反 */
	protected abstract SimulateSexEnum negation();
	
	@Override
	public String toString(){
		return this == MALE? "MALE" : "FEMALE";
	}
}
