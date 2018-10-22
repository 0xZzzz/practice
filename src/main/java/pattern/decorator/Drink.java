package pattern.decorator;

/**
 * 被装饰者对象接口
 *
 * @author 0xZzzz
 */
public interface Drink {

    /**
     * 饮料的价格
     *
     * @return 价格
     */
    float cost();

    /**
     * 饮料的描述
     *
     * @return 描述
     */
    String desc();
}
