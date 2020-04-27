package pattern.promotion;

import java.util.Random;

public class Test {

    public static void main(String[] args) {
        Context context = new Context();
        Random random = new Random();
        //模拟十次消费
        for (int i = 0; i < 10; i++) {
            //用于随机获取一个促销策略
            int x = random.nextInt(3);
            //消费金额由随机数产生  不能为0
            double consumePrice = 0;
            //随机产品一个商品价格  循环到不等于0为止
            while ((consumePrice = random.nextInt(2000)) == 0) {
            }
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
            System.out.print("[" + (x == 0 ? "打八折" : (x == 1 ? "高于200的部分打八折" : (x == 2 ? "满1000减200" : ""))) + "] 商品: ");
            System.out.println("原价: " + consumePrice + ", 优惠后的价格: " + context.cul(consumePrice));
        }
    }

}
