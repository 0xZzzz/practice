package pattern.builder;

/**
 * 具体的建造者(分部建造对象并返回)
 *
 * @author 0xZzzz
 */
public class MobileBuilderImpl2 extends AbstractBasePackage implements IMobileBuilder {

    //设置对象的套餐价格属性
    @Override
    public void buildMoney() {
        this.mobilePackage.setMoney(30);
    }

    //设置对象的彩铃属性
    @Override
    public void buildMusic() {
        this.mobilePackage.setMusic("醉清风");
    }

    //设置对象的短信条数属性
    @Override
    public void buildShortInfo() {
        this.mobilePackage.setShortInfo(600);
    }

    //返回构建好的对象
    @Override
    public MobilePackage getMobilePackage() {
        return this.mobilePackage;
    }

}
