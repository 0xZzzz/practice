package pattern.bridge;

/**
 * Զ��ң�ؿ���
 *
 * @author 0xZzzz
 */
public class RemoteControlSwitch extends BaseSwitch {

    public RemoteControlSwitch(ILight iLight) {
        super(iLight);
    }

    /**
     * Զ��ң�ؿ���
     *
     * @param openColor ������ɫ
     */
    public final void makeRemoteLight(int openColor) {
        this.iLight.electricConnected();
        this.iLight.light();
        String color;
        switch (openColor) {
            case 1:
                color = "ůɫ";
                break;
            case 2:
                color = "��ɫ";
                break;
            case 3:
                color = "��ɫ";
                break;
            default:
                color = "ǳɫ";
                break;
        }
        System.out.println("�Ƶ���ɫΪ: " + color);
        this.iLight.electricClosed();
    }
}
