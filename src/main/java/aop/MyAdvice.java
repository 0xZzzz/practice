package aop;
/**
 * ��ǿʵ��
 */
public class MyAdvice implements Advice {

	@Override
	public void before() {
		System.out.println("before method...");
	}

	@Override
	public void after() {
		System.out.println("after method...");
	}

}
