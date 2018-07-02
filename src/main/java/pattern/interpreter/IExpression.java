package pattern.interpreter;
/**
 * 表达式接口
 */
public interface IExpression {
	/**
	 * 解析
	 * @param context 上下文
	 */
	void parse(Context context);
	
	/**
	 * 执行
	 */
	void interpret();
}
