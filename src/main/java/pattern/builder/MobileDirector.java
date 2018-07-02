package pattern.builder;

public class MobileDirector {

    /**
     * ��������
     *
     * @param mobileBuilder ��������
     * @return �����õĶ���
     */
    public MobilePackage createMobilePackage(IMobileBuilder mobileBuilder) {
        if (mobileBuilder != null) {
            //�ֲ�����
            mobileBuilder.buildMoney();
            mobileBuilder.buildShortInfo();
            mobileBuilder.buildMusic();
            //���������󷵻ض���
            return mobileBuilder.getMobilePackage();
        }
        return null;
    }
}
