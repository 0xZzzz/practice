package pattern.builder;

/**
 * ����Ľ�������(�ֲ��������󲢷���)
 *
 * @author 0xZzzz
 */
public class MobileBuilderImpl1 extends AbstractBasePackage implements IMobileBuilder {

    //��������ļ۸�����
    @Override
    public void buildMoney() {
        this.mobilePackage.setMoney(20);
    }

    //��������Ĳ�������
    @Override
    public void buildMusic() {
        this.mobilePackage.setMusic("����");
    }

    //��������Ķ�����������
    @Override
    public void buildShortInfo() {
        this.mobilePackage.setShortInfo(400);
    }

    //���ع����õĶ���
    @Override
    public MobilePackage getMobilePackage() {
        return this.mobilePackage;
    }

}
