package pattern.bridge;

/**
 * �׳��
 *
 * @author 0xZzzz
 */
public class IncandescentLight implements ILight {

    @Override
    public void electricConnected() {
        System.out.println("�׳��ͨ��");
    }

    @Override
    public void light() {
        System.out.println("�׳������");
    }

    @Override
    public void electricClosed() {
        System.out.println("�׳�ƶϵ�");
    }

}
