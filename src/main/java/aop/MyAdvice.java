package aop;

/**
 * 增强实现
 */
public class MyAdvice implements Advice {

    public void before() {
        System.out.println("before method...");
    }

    public void after() {
        System.out.println("after method...");
    }

}
