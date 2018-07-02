package pattern.decorator.bread;

/**
 * ������װ����
 */
public class SweetDecorator extends AbstractBread {

    public SweetDecorator(IBread bread) {
        super(bread);
    }

    /**
     * ���з��� ���������
     */
    public void paint() {
        System.out.println("���������");
    }

    //��д����ĺ��淽��  ��������غ��ٺ���
    @Override
    public void kneadFlour() {
        this.paint();
        super.kneadFlour();
    }
}
