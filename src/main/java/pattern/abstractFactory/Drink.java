package pattern.abstractFactory;

/**
 * ���ϻ���
 */
public abstract class Drink extends AbstractFood implements IFood {

    @Override
    public void printInfo() {
        System.out.println(this.getKind() + "��ζ����, ����: " + this.getPrice() + "Ԫ, ����: " + this.getNum() + ", �ܼ�: " + this.totalPrice() + "Ԫ");
    }

}
