package pattern.decorator;

/**
 * 装饰着测试了类
 *
 * @author 0xZzzz
 */
public class Test {

    public static void main(String[] args) {
        //买一杯纯豆浆
        Drink soy = new SoyBeanMilk();
        //加鸡蛋
        EggDecorator egg = new EggDecorator(soy);
        //加糖
        SugarDecorator sugar = new SugarDecorator(egg);

        System.out.println("您购买了: " + sugar.desc());
        System.out.println("共计(?): " + sugar.cost());
    }
}
