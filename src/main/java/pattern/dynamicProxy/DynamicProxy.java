package pattern.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxy implements InvocationHandler {

    private Object subject; //������Ķ���

    public DynamicProxy(Object subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        Object obj = null;
        before();
        obj = method.invoke(subject, args);
        after();
        return obj;
    }

    public void before() {
        System.out.println("����֮ǰҪ������");
    }

    public void after() {
        System.out.println("����֮��Ҫ������");
    }
}
