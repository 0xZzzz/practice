package pattern.bridge;

/**
 * ˮ����
 *
 * @author 0xZzzz
 */
public class CrystalLight implements ILight {

    @Override
    public void electricConnected() {
        System.out.println("ˮ����ͨ��");
    }

    @Override
    public void light() {
        System.out.println("ˮ��������");
    }

    @Override
    public void electricClosed() {
        System.out.println("ˮ���ƶϵ�");
    }

}
