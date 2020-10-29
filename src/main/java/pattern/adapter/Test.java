package pattern.adapter;

/**
 * 适配器模式策略类
 *
 * @author 0xZzzz
 */
public class Test {

    public static void main(String[] args) {
        PowerA powerA = new PowerAImpl();
        // 正常调用
        start(powerA);

        PowerB powerB = new PowerBImpl();
        PowerAAdapter pa = new PowerAAdapter(powerB);
        //传入powerB
        start(pa);
    }

    public static void start(PowerA powerA) {
        powerA.insert();
    }
}
