package pattern.interpreter;

/**
 * @author 0xZzzz
 */
public class Test {

    public static void main(String[] args) {
        // 创建自己的语言
        String str = "PROGRAM PRINTLN start... FOR i FROM 90 TO 100 PRINTLN i END PRINTLN end... END";
        System.out.println("str: " + str);

        // 创建PROGRAM表达式
        IExpression expression = new ProgramExpression(str);

        // 解释执行
        expression.interpret();
    }
}
