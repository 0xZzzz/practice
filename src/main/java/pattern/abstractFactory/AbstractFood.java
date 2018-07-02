package pattern.abstractFactory;

/**
 * ʳ�����
 */
public abstract class AbstractFood {

    /**
     * ����
     */
    private int num;

    /**
     * ����
     */
    private String kind;

    /**
     * �۸�
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
