package pattern.bridge;

/**
 * ���ػ���
 *
 * @author 0xZzzz
 */
public class BaseSwitch {

    protected ILight iLight;

    public BaseSwitch(ILight iLight) {
        this.iLight = iLight;
    }

    /**
     * ����
     */
    public final void makeLight() {
        this.iLight.electricConnected();
        this.iLight.light();
        this.iLight.electricClosed();
    }
}
