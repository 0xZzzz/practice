package pattern.bridge;

public class Test {
    public static void main(String[] args) {

        ILight incandescentLight = new IncandescentLight();
        ILight crystalLight = new CrystalLight();

        System.out.println("һ�㿪��");
        BaseSwitch switch1 = new BaseSwitch(incandescentLight);
        switch1.makeLight();

        System.out.println("\nԶ��ң�ؿ���");
        RemoteControlSwitch switch2 = new RemoteControlSwitch(crystalLight);
        switch2.makeRemoteLight(1);
    }
}
