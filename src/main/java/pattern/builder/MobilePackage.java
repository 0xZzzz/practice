package pattern.builder;

/**
 * 短信套餐
 *
 * @author 0xZzzz
 */
public class MobilePackage {

    /**
     * 短信条数
     */
    private int shortInfo;
    /**
     * 套餐价格
     */
    private double money;
    /**
     * 套餐彩铃
     */
    private String music;

    public int getShortInfo() {
        return shortInfo;
    }

    public void setShortInfo(int shortInfo) {
        this.shortInfo = shortInfo;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getMusic() {
        return music;
    }

    public void setMusic(String music) {
        this.music = music;
    }

    @Override
    public String toString() {
        return "MobilePackage [shortInfo=" + shortInfo + ", money=" + money
                + ", music=" + music + "]";
    }

}
