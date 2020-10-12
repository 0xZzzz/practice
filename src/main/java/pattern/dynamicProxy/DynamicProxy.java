package pattern.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxy implements InvocationHandler {

    /**
     * 被代理的对象
     */
    private final Object subject;

    public DynamicProxy(Object subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        before();
        Object obj = method.invoke(subject, args);
        after();
        return obj;
    }

    public void before() {
        System.out.println("代理之前要做的事");
    }

    public void after() {
        System.out.println("代理之后要做的事");
    }
}
