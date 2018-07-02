package pattern.interpreter;

/**
 * 最基础的表达式
 *
 * @author 0xZzzz
 */
public class PrimitiveExpression implements IExpression {

    private Context context;

    //节点名称
    private String tokenName;

    //文本内容
    private String text;

    public PrimitiveExpression(Context context) {
        this.parse(context);
    }

    @Override
    public void parse(Context context) {
        this.context = context;
        this.tokenName = this.context.getCurrentToken();
        this.context.next();
        if ("PRINTLN".equals(this.tokenName)) {
            this.text = this.context.getCurrentToken();
            this.context.next();
        }
    }

    //实现解释方法
    @Override
    public void interpret() {
        if ("PRINTLN".endsWith(tokenName)) {
            System.out.println(this.context.getTokenContent(text));
        }
    }

}
