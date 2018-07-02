package pattern.bridge;

/**
 * 水晶灯
 *
 * @author 0xZzzz
 */
public class CrystalLight implements ILight {

    @Override
    public void electricConnected() {
        System.out.println("水晶灯通电");
    }

    @Override
    public void light() {
        System.out.println("水晶灯照明");
    }

    @Override
    public void electricClosed() {
        System.out.println("水晶灯断电");
    }

}
