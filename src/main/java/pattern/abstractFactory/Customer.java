package pattern.abstractFactory;

/**
 * 消费者 客户
 */
public class Customer {

    private IKFCFactory ikfcFactory;

    /**
     * 构造方法初始化工厂
     *
     * @param ikfcFactory 食物工厂
     */
    public Customer(IKFCFactory ikfcFactory) {
        this.ikfcFactory = ikfcFactory;
    }

    /**
     * 订购食物
     *
     * @param num 数量
     * @return 总价
     */
    public double orderHamburger(int num) {
        //生产汉堡
        Hamburger hamburger = ikfcFactory.createHamburger(num);
        //打印消息
        hamburger.printInfo();
        //返回总价
        return hamburger.totalPrice();
    }

    /**
     * 订购食物
     *
     * @param num 数量
     * @return 总价
     */
    public double orderDrink(int num) {
        //生产饮料
        Drink drink = ikfcFactory.createDrink(num);
        //打印消息
        drink.printInfo();
        //返回总价
        return drink.totalPrice();
    }
}
