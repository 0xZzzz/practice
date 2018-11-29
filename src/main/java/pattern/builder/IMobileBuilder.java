package pattern.builder;

/**
 * 抽象套餐建造接口
 *
 * @author 0xZzzz
 */
public interface IMobileBuilder {

    /**
     * 建造套餐话费
     */
    void buildMoney();

    /**
     * 建造套餐彩铃
     */
    void buildMusic();

    /**
     * 建造套餐短信
     */
    void buildShortInfo();

    /**
     * 返回建造的手机套餐对象
     *
     * @return 返回套餐信息
     */
    MobilePackage getMobilePackage();
}
