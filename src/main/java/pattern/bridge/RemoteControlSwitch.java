package pattern.bridge;

/**
 * 远程遥控开关
 *
 * @author 0xZzzz
 */
public class RemoteControlSwitch extends BaseSwitch {

    public RemoteControlSwitch(ILight iLight) {
        super(iLight);
    }

    /**
     * 远程遥控开灯
     *
     * @param openColor 开灯颜色
     */
    public final void makeRemoteLight(int openColor) {
        this.iLight.electricConnected();
        this.iLight.light();
        String color;
        switch (openColor) {
            case 1:
                color = "暖色";
                break;
            case 2:
                color = "冷色";
                break;
            case 3:
                color = "深色";
                break;
            default:
                color = "浅色";
                break;
        }
        System.out.println("灯的颜色为: " + color);
        this.iLight.electricClosed();
    }
}
