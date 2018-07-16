package aop;

import java.util.Collection;

public class Test {

    public static void main(String[] args) {
        Object proxy = BeanFactory.getBean("xxx");
        System.out.println(proxy.getClass().getName());
        @SuppressWarnings("rawtypes")
        Collection collection = (Collection) proxy;
        collection.clear();
    }

}
