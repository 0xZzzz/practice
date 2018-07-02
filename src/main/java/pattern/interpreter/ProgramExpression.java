package pattern.interpreter;

/**
 * 主表达式
 *
 * @author 0xZzzz
 */
public class ProgramExpression implements IExpression {

    //上下文环境
    private final Context context;

    //当前命令
    private static final String COMMAND = "PROGRAM";

    //下一个表达式
    private IExpression expression;

    /**
     * 构造方法将带解析的内容传入
     *
     * @param text 命令
     */
    public ProgramExpression(String text) {
        this.context = new Context(text);
        this.parse(context);
    }

    @Override
    public void parse(Context context) {
        //获取第一个命令的节点
        this.context.next();
    }

    //实现解释方法
    @Override
    public void interpret() {
        //判断是否以program开始
        if (!this.context.equalsWithCommand(COMMAND)) {
            System.out.println("the '" + COMMAND + "' is expected for start");
        } else {
            this.context.next();
            this.expression = new ListExpression();
            this.expression.parse(context);
            //ListExpression表达式开始解析
            this.expression.interpret();
        }
    }

}
