package pattern.interpreter;

public class Test {

    public static void main(String[] args) {
        //�����Լ�������
        String str = "PROGRAM PRINTLN start... FOR i FROM 90 TO 100 PRINTLN i END PRINTLN end... END";
        System.out.println("str: " + str);

        //����PROGRAM���ʽ
        IExpression expression = new ProgramExpression(str);

        //����ִ��
        expression.interpret();
    }
}
