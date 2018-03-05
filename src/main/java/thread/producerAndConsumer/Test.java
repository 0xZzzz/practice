package thread.producerAndConsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Data> queue = new LinkedBlockingQueue<Data>();
        Producer p1 = new Producer(queue); //建立生产者
        Producer p2 = new Producer(queue);
        Producer p3 = new Producer(queue);

        Consumer c1 = new Consumer(queue); //建立消费者
        Consumer c2 = new Consumer(queue);
        Consumer c3 = new Consumer(queue);

        ExecutorService service = Executors.newCachedThreadPool(); //建立线程池

        service.execute(p1); //执行生产者
        service.execute(p2);
        service.execute(p3);

        service.execute(c1); //执行消费者
        service.execute(c2);
        service.execute(c3);

        Thread.sleep(10 * 1000);
        p1.stop(); //停止生产者
        p2.stop();
        p3.stop();

        Thread.sleep(3000);

        service.shutdown(); //启动一次顺序关闭，执行以前提交的任务，但不接受新任务
    }
}
