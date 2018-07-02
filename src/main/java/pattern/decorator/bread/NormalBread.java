package pattern.decorator.bread;

/**
 * ��װ���� ������ͷ
 */
public class NormalBread implements IBread {

    @Override
    public void prepare() {
        System.out.println("װ������");
    }

    @Override
    public void kneadFlour() {
        System.out.println("����");
    }

    @Override
    public void steamed() {
        System.out.println("����ͷ");
    }

    @Override
    public void process() {
        this.prepare();
        this.kneadFlour();
        this.steamed();
    }

}
