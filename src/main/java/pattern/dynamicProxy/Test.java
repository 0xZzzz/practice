package pattern.dynamicProxy;

import java.lang.reflect.Proxy;

public class Test {
	public static void main(String[] args) {
		Person p = new Person("ZQ");
		DynamicProxy dp = new DynamicProxy(p);
		/*
		 * Proxy 提供用于创建动态代理类和实例的静态方法, 它还是由这些方法创建的所有动态代理类的超类
		 * 动态生成代理对象（类加载器，被代理接口，InvocationHandler）
		 */
		Subject subject = (Subject) Proxy.newProxyInstance(p.getClass().getClassLoader(), p.getClass().getInterfaces(), dp);
		subject.doSome();
	}
}
