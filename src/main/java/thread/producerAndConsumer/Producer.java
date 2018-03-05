package thread.producerAndConsumer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 生产者
 */
public class Producer implements Runnable {
    private volatile boolean isRunning = true;
    private BlockingQueue<Data> queue;   //内存缓冲区
    private static AtomicInteger count = new AtomicInteger(); //总数 原子操作

    private static final int SLEEP = 1000;

    public Producer(BlockingQueue<Data> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        Data data = null;
        Random r = new Random();
        System.out.println("start producer id=" + Thread.currentThread().getId());
        try {
            while (isRunning) {
                Thread.sleep(r.nextInt(SLEEP));
                data = new Data(count.incrementAndGet()); //构造任务数据 以原子方式将当前值加 1
                System.out.println(data + "is put into queue");
                if (!queue.offer(data, 2, TimeUnit.SECONDS)) { //将指定元素插入此队列中，在到达指定的等待时间前等待可用的空间（如果有必要）
                    System.err.println("fail to put data" + data);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt(); //发生异常中断线程
        }
    }

    /**
     * 停止生产
     */
    public void stop() {
        isRunning = false;
    }

}
