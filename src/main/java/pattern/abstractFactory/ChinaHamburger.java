package pattern.abstractFactory;

/**
 * 具体汉堡类
 */
public class ChinaHamburger extends Hamburger {

    /**
     * 构造方法初始化值
     *
     * @param num 数量
     */
    public ChinaHamburger(int num) {
        this.setKind("麻辣");
        this.setPrice(5.5);
        this.setNum(num);
    }

}
