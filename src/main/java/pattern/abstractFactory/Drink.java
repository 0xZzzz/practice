package pattern.abstractFactory;

/**
 * 饮料基类
 */
public abstract class Drink extends AbstractFood implements IFood {

    @Override
    public void printInfo() {
        System.out.println(this.getKind() + "风味饮料, 单价: " + this.getPrice() + "元, 数量: " + this.getNum() + ", 总价: " + this.totalPrice() + "元");
    }

}
