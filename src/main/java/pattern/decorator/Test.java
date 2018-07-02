package pattern.decorator;

public class Test {
	public static void main(String[] args) {
		Drink soya = new SoyaBeanMilk(); //买一杯纯豆浆
		EggDecorator egg = new EggDecorator(soya); //加鸡蛋
		SugarDecorator sugar = new SugarDecorator(egg); //加糖

		System.out.println("您购买了: "+sugar.desc());
		System.out.println("共计(?): "+sugar.cost());
	}
}
