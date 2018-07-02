package pattern.builder;

/**
 * �����ײ�
 *
 * @author 0xZzzz
 */
public class MobilePackage {

    /**
     * ��������
     */
    private int shortInfo;
    /**
     * �ײͼ۸�
     */
    private double money;
    /**
     * �ײͲ���
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
