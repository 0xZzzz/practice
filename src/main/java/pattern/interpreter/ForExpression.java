package pattern.interpreter;
/**
 * FOR表达式
 * @author 69953213
 *
 */
public class ForExpression implements IExpression {

	private final Context context;
	//存储当前索引的key值
	private String variable;
	//存储循环起始位置
	private int startIndex;
	//存储循环结束位置
	private int endIndex;
	
	private IExpression expression;
	
	/**
	 * 构造方法将待解析的context传入
	 */
	public ForExpression(Context context) {
		this.context = context;
		this.parse(context);
	}

	@Override
	public void parse(Context context) {
		//首先获取当前节点
		this.context.next();
		while(true){
			if(this.context.equalsWithCommand("FROM")){
				//这是开始索引内容
				String nextStr = this.context.next();
				try{
					this.startIndex = Integer.parseInt(nextStr);
				}catch(Exception e){
					System.out.println("error: after 'FROM' expression exist error! please check the format of expression is correct!");
					break;
				}
				//获取下一个节点
				this.context.next();
			}else if(this.context.equalsWithCommand("TO")){
				//设置索引结束内容
				String nextStr = this.context.next();
				try{
					this.endIndex = Integer.parseInt(nextStr);
				}catch(Exception e){
					System.out.println("error: after 'TO' expression exist error! please check the format of expression is correct!");
				}
				this.context.next();
				break;
			}else{
				//设置当前索引的变量内容
				if(this.variable == null){
					this.variable = this.context.getCurrentToken();
				}
				//后去下一个节点
				this.context.next();
			}
		}
		//建立列表表达式
		this.expression = new ListExpression();
		this.expression.parse(context);
	}

	//实现解释方法
	@Override
	public void interpret() {
		for (int x = this.startIndex; x < this.endIndex; x++) {
			//设置变量内容
			this.context.put("" + this.variable, x);
			//执行解释方法
			this.expression.interpret();
		}
		//移除使用的临时变量内容
		this.context.clear("" + this.variable);
	}

}
