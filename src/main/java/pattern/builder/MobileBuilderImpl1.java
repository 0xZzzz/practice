package pattern.builder;

/**
 * 具体的建造者类(分部构建对象并返回)
 *
 * @author 0xZzzz
 */
public class MobileBuilderImpl1 extends AbstractBasePackage implements IMobileBuilder {

    @Override
    public void buildMoney() {
        this.mobilePackage.setMoney(20);
    }

    @Override
    public void buildMusic() {
        this.mobilePackage.setMusic("星座");
    }

    @Override
    public void buildShortInfo() {
        this.mobilePackage.setShortInfo(400);
    }

    @Override
    public MobilePackage getMobilePackage() {
        return this.mobilePackage;
    }

}
