package aop;
/**
 * 增强
 */
public interface Advice {
	
	/** 方法前执行 */
	void before();
	
	/** 方法后执行 */
	void after();
}
