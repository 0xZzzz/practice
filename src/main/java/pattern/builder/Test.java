package pattern.builder;

public class Test {

    public static void main(String[] args) {

        //创建者
        MobileDirector mobileDirector = new MobileDirector();
        //具体的被创建者对象
        IMobileBuilder mobileBuilder1 = new MobileBuilderImpl1();
        IMobileBuilder mobileBuilder2 = new MobileBuilderImpl2();
        //创建方法
        MobilePackage mobilePackage1 = mobileDirector.createMobilePackage(mobileBuilder1);
        MobilePackage mobilePackage2 = mobileDirector.createMobilePackage(mobileBuilder2);
        //打印创建结果
        System.out.println(mobilePackage1);
        System.out.println(mobilePackage2);
    }
}
