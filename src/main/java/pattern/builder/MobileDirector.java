package pattern.builder;

public class MobileDirector {

    /**
     * 构建对象
     *
     * @param mobileBuilder 抽象建造者
     * @return 构建好的对象
     */
    public MobilePackage createMobilePackage(IMobileBuilder mobileBuilder) {
        if (mobileBuilder != null) {
            //分部构建
            mobileBuilder.buildMoney();
            mobileBuilder.buildShortInfo();
            mobileBuilder.buildMusic();
            //构建结束后返回对象
            return mobileBuilder.getMobilePackage();
        }
        return null;
    }
}
