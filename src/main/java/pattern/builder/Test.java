package pattern.builder;

public class Test {

    public static void main(String[] args) {

        //������
        MobileDirector mobileDirector = new MobileDirector();
        //����ı������߶���
        IMobileBuilder mobileBuilder1 = new MobileBuilderImpl1();
        IMobileBuilder mobileBuilder2 = new MobileBuilderImpl2();
        //��������
        MobilePackage mobilePackage1 = mobileDirector.createMobilePackage(mobileBuilder1);
        MobilePackage mobilePackage2 = mobileDirector.createMobilePackage(mobileBuilder2);
        //��ӡ�������
        System.out.println(mobilePackage1);
        System.out.println(mobilePackage2);
    }
}
