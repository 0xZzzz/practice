package aop;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * bean����
 */
public class BeanFactory {
	
	//���������ļ�
	private static final Properties config = new Properties();
	
	static{
		InputStream in = BeanFactory.class.getResourceAsStream("config.properties");
		try {
			config.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ��ȡһ��beanʵ��
	 * @param key
	 * @return
	 */
	public static Object getBean(String key){
		Object bean = null;
		try {
			String className = config.getProperty(key);
			bean = Class.forName(className).newInstance();
			if(bean instanceof ProxyFactoryBean){
				ProxyFactoryBean proxyFactory = (ProxyFactoryBean)bean;
				proxyFactory.setTarget(Class.forName(config.getProperty(key + ".target")).newInstance());
				proxyFactory.setAdvice((Advice)Class.forName(config.getProperty(key + ".advice")).newInstance());
				bean = proxyFactory.getProxy();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}
}
