package pattern.prototype;

/**
 * 原型工厂
 *
 * @author 0xZzzz
 */
public class LifeFactoryImpl implements ILifeFactory {

    private static DayLife dayLife = null;

    @Override
    public DayLife newInstance() {
        try {
            if (dayLife == null) {
                dayLife = new DayLife();
                dayLife.setGetUp("七点起床");
                dayLife.setByBus("做地铁出发");
                dayLife.setBuyFood("公司附近买早餐");
                dayLife.setNoon("中午睡会儿");
                dayLife.setAfterNoon("下午工作");
                dayLife.setGoHome("下班啦");
                dayLife.setNight("夜生活开始");
                return dayLife;
            } else {
                return dayLife.clone();
            }
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

}
