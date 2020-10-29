package pattern.bridge;

/**
 * 桥接模式测试类
 *
 * @author 0xZzzz
 */
public class Test {
    public static void main(String[] args) {

        ILight incandescentLight = new IncandescentLight();
        ILight crystalLight = new CrystalLight();

        System.out.println("一般开关");
        BaseSwitch switch1 = new BaseSwitch(incandescentLight);
        switch1.makeLight();

        System.out.println("\n远程遥控开关");
        RemoteControlSwitch switch2 = new RemoteControlSwitch(crystalLight);
        switch2.makeRemoteLight(1);
    }
}
