package pattern.decorator;

public class Test {
	public static void main(String[] args) {
		Drink soya = new SoyaBeanMilk(); //��һ��������
		EggDecorator egg = new EggDecorator(soya); //�Ӽ���
		SugarDecorator sugar = new SugarDecorator(egg); //����

		System.out.println("��������: "+sugar.desc());
		System.out.println("����(?): "+sugar.cost());
	}
}
