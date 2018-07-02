package pattern.interpreter;
/**
 * FOR���ʽ
 * @author 69953213
 *
 */
public class ForExpression implements IExpression {

	private final Context context;
	//�洢��ǰ������keyֵ
	private String variable;
	//�洢ѭ����ʼλ��
	private int startIndex;
	//�洢ѭ������λ��
	private int endIndex;
	
	private IExpression expression;
	
	/**
	 * ���췽������������context����
	 */
	public ForExpression(Context context) {
		this.context = context;
		this.parse(context);
	}

	@Override
	public void parse(Context context) {
		//���Ȼ�ȡ��ǰ�ڵ�
		this.context.next();
		while(true){
			if(this.context.equalsWithCommand("FROM")){
				//���ǿ�ʼ��������
				String nextStr = this.context.next();
				try{
					this.startIndex = Integer.parseInt(nextStr);
				}catch(Exception e){
					System.out.println("error: after 'FROM' expression exist error! please check the format of expression is correct!");
					break;
				}
				//��ȡ��һ���ڵ�
				this.context.next();
			}else if(this.context.equalsWithCommand("TO")){
				//����������������
				String nextStr = this.context.next();
				try{
					this.endIndex = Integer.parseInt(nextStr);
				}catch(Exception e){
					System.out.println("error: after 'TO' expression exist error! please check the format of expression is correct!");
				}
				this.context.next();
				break;
			}else{
				//���õ�ǰ�����ı�������
				if(this.variable == null){
					this.variable = this.context.getCurrentToken();
				}
				//��ȥ��һ���ڵ�
				this.context.next();
			}
		}
		//�����б���ʽ
		this.expression = new ListExpression();
		this.expression.parse(context);
	}

	//ʵ�ֽ��ͷ���
	@Override
	public void interpret() {
		for (int x = this.startIndex; x < this.endIndex; x++) {
			//���ñ�������
			this.context.put("" + this.variable, x);
			//ִ�н��ͷ���
			this.expression.interpret();
		}
		//�Ƴ�ʹ�õ���ʱ��������
		this.context.clear("" + this.variable);
	}

}
