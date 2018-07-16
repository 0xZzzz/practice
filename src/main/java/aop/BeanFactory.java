package aop;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * bean工厂
 */
public class BeanFactory {

    private static final Properties config = new Properties();

    static {
        InputStream in = BeanFactory.class.getResourceAsStream("config.properties");
        try {
            config.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取bean实例
     */
    public static Object getBean(String key) {
        Object bean = null;
        try {
            String className = config.getProperty(key);
            bean = Class.forName(className).newInstance();
            if (bean instanceof ProxyFactoryBean) {
                ProxyFactoryBean proxyFactory = (ProxyFactoryBean) bean;
                proxyFactory.setTarget(Class.forName(config.getProperty(key + ".target")).newInstance());
                proxyFactory.setAdvice((Advice) Class.forName(config.getProperty(key + ".advice")).newInstance());
                bean = proxyFactory.getProxy();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
}
