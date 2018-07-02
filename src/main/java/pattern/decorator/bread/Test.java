package pattern.decorator.bread;

public class Test {

    public static void main(String[] args) {
        IBread bread = new NormalBread();
        bread = new CornDecorator(bread); //���װ���߹���
        bread = new SweetDecorator(bread); //���װ���߹���
        bread.process();
    }
}
