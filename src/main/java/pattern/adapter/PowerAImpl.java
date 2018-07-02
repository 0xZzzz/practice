package pattern.adapter;

public class PowerAImpl implements PowerA {

    @Override
    public void insert() {
        System.out.println("电源A已经插入, 可以开始工作...");
    }

}
