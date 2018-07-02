package pattern.promotion;

import java.util.Random;

public class Test {

	public static void main(String[] args) {
		Context context = new Context();
		Random random = new Random();
		//ģ��ʮ������
		for (int i = 0; i < 10; i++) {
			//���������ȡһ����������
			int x = random.nextInt(3);
			//���ѽ�������������  ����Ϊ0
			double consumePrice = 0;
			//�����Ʒһ����Ʒ�۸�  ѭ����������0Ϊֹ
			while((consumePrice = random.nextInt(2000)) == 0){}
			switch (x) {
			case 0:
				context.setStrategy(new RebateStrategy(0.8));
				break;
			case 1:
				context.setStrategy(new PromotionalStrategy());
				break;
			case 2:
				context.setStrategy(new ReduceStrategy());
			}
			System.out.print("[" + (x == 0 ? "�����" : (x == 1 ? "����200�Ĳ��ִ����" : (x == 2 ? "��1000��200" : ""))) + "] ��Ʒ: ");
			System.out.println("ԭ��: " + consumePrice + ", �Żݺ�ļ۸�: " + context.cul(consumePrice));
		}
	}

}
