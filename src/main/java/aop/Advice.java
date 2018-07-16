package aop;

/**
 * 增强
 */
public interface Advice {

    /**
     * 前置
     */
    void before();

    /**
     * 后置
     */
    void after();
}
