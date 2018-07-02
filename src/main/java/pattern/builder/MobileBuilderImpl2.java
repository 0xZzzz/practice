package pattern.builder;

/**
 * ����Ľ�����(�ֲ�������󲢷���)
 *
 * @author 0xZzzz
 */
public class MobileBuilderImpl2 extends AbstractBasePackage implements IMobileBuilder {

    //���ö�����ײͼ۸�����
    @Override
    public void buildMoney() {
        this.mobilePackage.setMoney(30);
    }

    //���ö���Ĳ�������
    @Override
    public void buildMusic() {
        this.mobilePackage.setMusic("�����");
    }

    //���ö���Ķ�����������
    @Override
    public void buildShortInfo() {
        this.mobilePackage.setShortInfo(600);
    }

    //���ع����õĶ���
    @Override
    public MobilePackage getMobilePackage() {
        return this.mobilePackage;
    }

}
