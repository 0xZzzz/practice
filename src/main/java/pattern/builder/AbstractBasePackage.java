package pattern.builder;

/**
 * ��������
 *
 * @author 0xZzzz
 */
public class AbstractBasePackage {

    /**
     * ά��һ���ֻ��ײͶ���
     */
    protected MobilePackage mobilePackage;

    /**
     * ���췽��Ϊ�ײʹ���һ���µĶ���
     */
    public AbstractBasePackage() {
        this.mobilePackage = new MobilePackage();
    }
}
