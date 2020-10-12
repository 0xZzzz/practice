package pattern.abstractFactory;

/**
 * 具体食物工厂
 *
 * @author 0xZzzz
 */
public class ChinaKFCFactory implements IKFCFactory {

    @Override
    public Hamburger createHamburger(int num) {
        return new ChinaHamburger(num);
    }

    @Override
    public Drink createDrink(int num) {
        return new ChinaDrink(num);
    }

}
