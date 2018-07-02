package pattern.prototype;

public class Test {
	public static void main(String[] args) {
		ILifeFactory lifeFactory = new LifeFactoryImpl();
		DayLife life1 = lifeFactory.newInstance();
		life1.print();
		DayLife life2 = lifeFactory.newInstance();
		life2.setGetUp("�������ߵ�����");
		life2.print();
	}
}
