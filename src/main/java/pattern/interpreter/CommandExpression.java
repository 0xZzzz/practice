package pattern.interpreter;

public class CommandExpression implements IExpression {

    private final Context context;

    private IExpression expression;

    /**
     * 构造方法将待解析的context传入
     */
    public CommandExpression(Context context) {
        this.context = context;
        this.expression.parse(context);
    }

    @Override
    public void parse(Context context) {
        //判断当前命令类别, 在此只对For和最原始命令进行区分
        if (this.context.equalsWithCommand("FOR")) {
            //创建FOR表达式进行解析
            expression = new ForExpression(this.context);
        } else {
            //创建原始命令表达式进行内容解析
            expression = new PrimitiveExpression(this.context);
        }
    }

    //解析内容
    @Override
    public void interpret() {
        this.expression.interpret();
    }

}
