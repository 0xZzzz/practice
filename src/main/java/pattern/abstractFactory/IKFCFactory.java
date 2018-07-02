package pattern.abstractFactory;

/**
 * 食物工厂接口
 */
public interface IKFCFactory {

    /**
     * 生产汉堡
     */
    Hamburger createHamburger(int num);

    /**
     * 生产饮料
     */
    Drink createDrink(int num);
}
