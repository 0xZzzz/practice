package pattern.builder;

/**
 * 具体的建造者(分部建造对象并返回)
 *
 * @author 0xZzzz
 */
public class MobileBuilderImpl2 extends AbstractBasePackage implements IMobileBuilder {

    @Override
    public void buildMoney() {
        this.mobilePackage.setMoney(30);
    }

    @Override
    public void buildMusic() {
        this.mobilePackage.setMusic("醉清风");
    }

    @Override
    public void buildShortInfo() {
        this.mobilePackage.setShortInfo(600);
    }

    @Override
    public MobilePackage getMobilePackage() {
        return this.mobilePackage;
    }

}
