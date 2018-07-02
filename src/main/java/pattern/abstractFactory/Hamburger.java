package pattern.abstractFactory;

/**
 * ��������
 */
public abstract class Hamburger extends AbstractFood implements IFood {

    @Override
    public void printInfo() {
        System.out.println(this.getKind() + "��ζ����, ����: " + this.getPrice() + "Ԫ, ����: " + this.getNum() + ", �ܼ�: " + this.totalPrice() + "Ԫ");
    }

}
