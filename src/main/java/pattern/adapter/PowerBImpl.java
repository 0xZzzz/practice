package pattern.adapter;

public class PowerBImpl implements PowerB {

    @Override
    public void connect() {
        System.out.println("电源B已经连接, 可以开始工作...");
    }

}
