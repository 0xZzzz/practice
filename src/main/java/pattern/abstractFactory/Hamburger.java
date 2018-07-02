package pattern.abstractFactory;

/**
 * 汉堡基类
 */
public abstract class Hamburger extends AbstractFood implements IFood {

    @Override
    public void printInfo() {
        System.out.println(this.getKind() + "风味汉堡, 单价: " + this.getPrice() + "元, 数量: " + this.getNum() + ", 总价: " + this.totalPrice() + "元");
    }

}
