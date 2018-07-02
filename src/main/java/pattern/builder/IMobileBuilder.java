package pattern.builder;

/**
 * �����ײͽ���ӿ�
 *
 * @author 0xZzzz
 */
public interface IMobileBuilder {

    //�����ײͻ���
    void buildMoney();

    //�����ײͲ���
    void buildMusic();

    //�����ײͶ���
    void buildShortInfo();

    //���ؽ�����ֻ��ײͶ���
    MobilePackage getMobilePackage();
}
