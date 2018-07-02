package pattern.interpreter;

public class CommandExpression implements IExpression {

    private final Context context;

    private IExpression expression;

    /**
     * ���췽������������context����
     */
    public CommandExpression(Context context) {
        this.context = context;
        this.expression.parse(context);
    }

    @Override
    public void parse(Context context) {
        //�жϵ�ǰ�������, �ڴ�ֻ��For����ԭʼ�����������
        if (this.context.equalsWithCommand("FOR")) {
            //����FOR���ʽ���н���
            expression = new ForExpression(this.context);
        } else {
            //����ԭʼ������ʽ�������ݽ���
            expression = new PrimitiveExpression(this.context);
        }
    }

    //��������
    @Override
    public void interpret() {
        this.expression.interpret();
    }

}
