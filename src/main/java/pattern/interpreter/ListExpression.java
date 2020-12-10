package pattern.interpreter;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 列表表达式
 *
 * @author 0xZzzz
 */
public class ListExpression implements IExpression {

    private Context context;

    private final ArrayList<IExpression> list = new ArrayList<IExpression>();

    @Override
    public void parse(Context context) {
        this.context = context;
        // 在 ListExpression 表达式中, 循环解释语句中的每一个单词, 直至终结符表达式或者异常情况退出
        while (true) {
            if (this.context.getCurrentToken() == null) {
                System.out.println("error: the expression missing 'END'");
                break;
            } else if (this.context.equalsWithCommand("END")) {
                // 正常结束
                this.context.next();
                break;
            } else {
                IExpression expression = new CommandExpression(this.context);
                list.add(expression);
            }
        }
    }

    @Override
    public void interpret() {
        // 循环 list 列表中每一个表达式, 解释执行
        for (IExpression iExpression : list) {
            iExpression.interpret();
        }
    }

}
