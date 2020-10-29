package pattern.bridge;

/**
 * 开关基类
 *
 * @author 0xZzzz
 */
public class BaseSwitch {

    protected ILight iLight;

    public BaseSwitch(ILight iLight) {
        this.iLight = iLight;
    }

    /**
     * 开灯
     */
    public final void makeLight() {
        this.iLight.electricConnected();
        this.iLight.light();
        this.iLight.electricClosed();
    }
}
