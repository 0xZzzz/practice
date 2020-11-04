package pattern.state;

import java.util.Random;

/**
 * 状态模式测试类
 *
 * @author 0xZzzz
 */
public class StateTest {

    public static void main(String[] args) {
        Context context = new Context();
        context.changeState(new EditState());
        Random random = new Random();
        int loopTimes = 5;
        for (int i = 0; i < loopTimes; i++) {
            int r = random.nextInt(2);
            System.out.println("当前模式: " + (r == 0 ? "预览模式" : (r == 1 ? "编辑模式" : "")));
            context.doWork(r);
        }
    }
}
