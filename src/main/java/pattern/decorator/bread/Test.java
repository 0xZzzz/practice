package pattern.decorator.bread;

public class Test {

    public static void main(String[] args) {
        IBread bread = new NormalBread();
        bread = new CornDecorator(bread); //添加装饰者功能
        bread = new SweetDecorator(bread); //添加装饰者功能
        bread.process();
    }
}
