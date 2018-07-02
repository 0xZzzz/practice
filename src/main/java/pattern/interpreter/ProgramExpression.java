package pattern.interpreter;

/**
 * �����ʽ
 *
 * @author 0xZzzz
 */
public class ProgramExpression implements IExpression {

    //�����Ļ���
    private final Context context;

    //��ǰ����
    private static final String COMMAND = "PROGRAM";

    //��һ�����ʽ
    private IExpression expression;

    /**
     * ���췽���������������ݴ���
     *
     * @param text ����
     */
    public ProgramExpression(String text) {
        this.context = new Context(text);
        this.parse(context);
    }

    @Override
    public void parse(Context context) {
        //��ȡ��һ������Ľڵ�
        this.context.next();
    }

    //ʵ�ֽ��ͷ���
    @Override
    public void interpret() {
        //�ж��Ƿ���program��ʼ
        if (!this.context.equalsWithCommand(COMMAND)) {
            System.out.println("the '" + COMMAND + "' is expected for start");
        } else {
            this.context.next();
            this.expression = new ListExpression();
            this.expression.parse(context);
            //ListExpression���ʽ��ʼ����
            this.expression.interpret();
        }
    }

}
