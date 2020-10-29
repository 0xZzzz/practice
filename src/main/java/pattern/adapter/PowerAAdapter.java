package pattern.adapter;

/**
 * 电源A的适配器
 *
 * @author 0xZzzz
 */
public class PowerAAdapter implements PowerA {

    private PowerB powerB;

    public PowerAAdapter(PowerB powerB) {
        this.powerB = powerB;
    }

    @Override
    public void insert() {
        powerB.connect();
    }

}
