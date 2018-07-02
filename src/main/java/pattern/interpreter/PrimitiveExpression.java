package pattern.interpreter;

/**
 * ������ı��ʽ
 *
 * @author 0xZzzz
 */
public class PrimitiveExpression implements IExpression {

    private Context context;

    //�ڵ�����
    private String tokenName;

    //�ı�����
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

    //ʵ�ֽ��ͷ���
    @Override
    public void interpret() {
        if ("PRINTLN".endsWith(tokenName)) {
            System.out.println(this.context.getTokenContent(text));
        }
    }

}
