package pattern.state;

import java.util.Random;

public class Test {

    public static void main(String[] args) {
        Context context = new Context();
        context.changeState(new EditState());
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            int r = random.nextInt(2);
            System.out.println("��ǰģʽ: " + (r == 0 ? "Ԥ��ģʽ" : (r == 1 ? "�༭ģʽ" : "")));
            context.doWork(r);
        }
    }
}
