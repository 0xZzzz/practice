package pattern.builder;

/**
 * 抽象建造者
 *
 * @author 0xZzzz
 */
public class AbstractBasePackage {

    /**
     * 维护一个手机套餐对象
     */
    protected MobilePackage mobilePackage;

    /**
     * 构造方法为套餐创建一个新的对象
     */
    public AbstractBasePackage() {
        this.mobilePackage = new MobilePackage();
    }
}
