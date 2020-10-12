package pattern.abstractFactory;

/**
 * 食物基类
 *
 * @author 0xZzzz
 */
public abstract class AbstractFood {

    /**
     * 数量
     */
    private int num;

    /**
     * 种类
     */
    private String kind;

    /**
     * 价格
     */
    private double price;

    protected double totalPrice() {
        return this.num * this.price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
