package thread.producerAndConsumer;

import java.text.MessageFormat;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * 消费者
 */
public class Consumer extends Thread {
    private BlockingQueue<Data> queue;
    private static final int SLEEP = 1000;

    public Consumer(BlockingQueue<Data> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println("start consumer id=" + Thread.currentThread().getId());
        Random r = new Random();
        try {
            while (true) {
                Data data = queue.take();
                if (null != data) {
                    int re = data.getIntData() * data.getIntData(); //计算平方
                    System.out.println(MessageFormat.format("{0}*{1}={2}", data.getIntData(), data.getIntData(), re));
                    Thread.sleep(r.nextInt(SLEEP));
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt(); //发生异常中断线程
        }
    }
}
