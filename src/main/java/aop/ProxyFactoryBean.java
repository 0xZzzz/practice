package aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理工厂
 */
public class ProxyFactoryBean {
	
	//增强方法
	private Advice advice;
	//目标对象
	private Object target;
	
	public void setAdvice(Advice advice) {
		this.advice = advice;
	}

	public void setTarget(Object target) {
		this.target = target;
	}

	/**
	 * 获取代理对象
	 * @return
	 */
	public Object getProxy(){
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				
				advice.before();
				method.invoke(target, args);
				System.out.println("finish invoke method...");
				advice.after();
				
				return proxy;
			}
		});
	}
}
