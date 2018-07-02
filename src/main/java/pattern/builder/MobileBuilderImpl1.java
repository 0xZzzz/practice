package pattern.builder;

/**
 * 具体的建造者类(分部构建对象并返回)
 *
 * @author 0xZzzz
 */
public class MobileBuilderImpl1 extends AbstractBasePackage implements IMobileBuilder {

    //构建对象的价格属性
    @Override
    public void buildMoney() {
        this.mobilePackage.setMoney(20);
    }

    //构建对象的彩铃属性
    @Override
    public void buildMusic() {
        this.mobilePackage.setMusic("星座");
    }

    //构建对象的短信条数属性
    @Override
    public void buildShortInfo() {
        this.mobilePackage.setShortInfo(400);
    }

    //返回构建好的对象
    @Override
    public MobilePackage getMobilePackage() {
        return this.mobilePackage;
    }

}
