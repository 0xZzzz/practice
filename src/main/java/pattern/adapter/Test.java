package pattern.adapter;

public class Test {

    public static void main(String[] args) {
        PowerA powerA = new PowerAImpl();
        start(powerA); //正常调用

        PowerB powerB = new PowerBImpl();
        PowerAAdapter pa = new PowerAAdapter(powerB);
        start(pa); //传入powerB
    }

    public static void start(PowerA powerA) {
        powerA.insert();
    }
}
