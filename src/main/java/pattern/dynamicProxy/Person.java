package pattern.dynamicProxy;
/**
 * ����ı�����Ķ���
 * @author ZQ
 *
 */
public class Person implements Subject{
	private String name;
	
	public Person(String name) {
		super();
		this.name = name;
	}

	@Override
	public void doSome() {
		System.out.println(name+"������...");
	}

}
