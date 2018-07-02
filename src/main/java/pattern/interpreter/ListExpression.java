package pattern.interpreter;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * �б���ʽ
 * @author 69953213
 *
 */
public class ListExpression implements IExpression {

	private Context context;
	
	private final ArrayList<IExpression> list = new ArrayList<IExpression>();
	
	@Override
	public void parse(Context context) {
		this.context = context;
		//��ListExpression���ʽ��, ѭ����������е�ÿһ������, ֱ���ս�����ʽ�����쳣����˳�
		while(true){
			if(this.context.getCurrentToken() == null){
				System.out.println("error: the expression missing 'END'");
				break;
			}else if(this.context.equalsWithCommand("END")){
				//��������
				this.context.next();
				break;
			}else{
				IExpression expression = new CommandExpression(this.context);
				list.add(expression);
			}
		}
	}

	//ʵ�ֽ��ͷ���
	@Override
	public void interpret() {
		//ѭ��list�б���ÿһ�����ʽ, ����ִ��
		Iterator<IExpression> iterator = list.iterator();
		while(iterator.hasNext()){
			(iterator.next()).interpret();
		}
	}

}
