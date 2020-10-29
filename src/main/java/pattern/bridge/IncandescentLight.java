package pattern.bridge;

/**
 * 白炽灯
 *
 * @author 0xZzzz
 */
public class IncandescentLight implements ILight {

    @Override
    public void electricConnected() {
        System.out.println("白炽灯通电");
    }

    @Override
    public void light() {
        System.out.println("白炽灯照明");
    }

    @Override
    public void electricClosed() {
        System.out.println("白炽灯断电");
    }

}
