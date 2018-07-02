package pattern.prototype;

public class Test {
	public static void main(String[] args) {
		ILifeFactory lifeFactory = new LifeFactoryImpl();
		DayLife life1 = lifeFactory.newInstance();
		life1.print();
		DayLife life2 = lifeFactory.newInstance();
		life2.setGetUp("起晚了七点半出发");
		life2.print();
	}
}
