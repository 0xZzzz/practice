package pattern.abstractFactory;

/**
 * 具体饮料类
 */
public class ChinaDrink extends Drink {

    /**
     * 构造方法初始化值
     *
     * @param num 数量
     */
    public ChinaDrink(int num) {
        this.setKind("柠檬");
        this.setPrice(2.5);
        this.setNum(num);
    }

}
