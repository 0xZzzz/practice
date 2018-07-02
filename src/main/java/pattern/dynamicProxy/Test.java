package pattern.dynamicProxy;

import java.lang.reflect.Proxy;

public class Test {
	public static void main(String[] args) {
		Person p = new Person("ZQ");
		DynamicProxy dp = new DynamicProxy(p);
		/*
		 * Proxy �ṩ���ڴ�����̬�������ʵ���ľ�̬����, ����������Щ�������������ж�̬������ĳ���
		 * ��̬���ɴ���������������������ӿڣ�InvocationHandler��
		 */
		Subject subject = (Subject) Proxy.newProxyInstance(p.getClass().getClassLoader(), p.getClass().getInterfaces(), dp);
		subject.doSome();
	}
}
