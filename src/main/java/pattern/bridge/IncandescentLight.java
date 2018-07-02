package pattern.bridge;

/**
 * °×³ãµÆ
 *
 * @author 0xZzzz
 */
public class IncandescentLight implements ILight {

    @Override
    public void electricConnected() {
        System.out.println("°×³ãµÆÍ¨µç");
    }

    @Override
    public void light() {
        System.out.println("°×³ãµÆÕÕÃ÷");
    }

    @Override
    public void electricClosed() {
        System.out.println("°×³ãµÆ¶Ïµç");
    }

}
