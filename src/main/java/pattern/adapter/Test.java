package pattern.adapter;

/**
 * ������ģʽ������
 *
 * @author 0xZzzz
 */
public class Test {

    public static void main(String[] args) {
        PowerA powerA = new PowerAImpl();
        // ��������
        start(powerA);

        PowerB powerB = new PowerBImpl();
        PowerAAdapter pa = new PowerAAdapter(powerB);
        //����powerB
        start(pa);
    }

    public static void start(PowerA powerA) {
        powerA.insert();
    }
}
