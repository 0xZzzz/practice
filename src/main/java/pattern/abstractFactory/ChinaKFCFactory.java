package pattern.abstractFactory;

/**
 * 具体食物工厂
 */
public class ChinaKFCFactory implements IKFCFactory {

    //创建具体食物
    @Override
    public Hamburger createHamburger(int num) {
        return new ChinaHamburger(num);
    }

    //创建具体食物
    @Override
    public Drink createDrink(int num) {
        return new ChinaDrink(num);
    }

}
