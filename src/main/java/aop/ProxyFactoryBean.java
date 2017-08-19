package aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * ������
 */
public class ProxyFactoryBean {
	
	//��ǿ����
	private Advice advice;
	//Ŀ�����
	private Object target;
	
	public void setAdvice(Advice advice) {
		this.advice = advice;
	}

	public void setTarget(Object target) {
		this.target = target;
	}

	/**
	 * ��ȡ�������
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
