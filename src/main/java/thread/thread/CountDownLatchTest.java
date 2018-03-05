package thread.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CountDownLatch 初始化一个计数 可以控制让线程阻塞 直到计数为0时才会继续执行
 */
public class CountDownLatchTest {

    private static final CountDownLatch cdOrder = new CountDownLatch(1);
    private static final CountDownLatch cdAnswer = new CountDownLatch(3);
    private static final ExecutorService threadPool = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            threadPool.execute(CountDownLatchTest::task);
        }
        try {
            Thread.sleep((long) (Math.random() * 10000));
            System.out.println(Thread.currentThread().getName() + "即将发布命令");
            cdOrder.countDown();//计数减1
            System.out.println(Thread.currentThread().getName() + "已经接受命令");
            cdAnswer.await();//线程阻塞 计数到0才会继续执行
            System.out.println(Thread.currentThread().getName() + "回应命令处理结果");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadPool.shutdown();
    }

    private static void task() {
        try {
            System.out.println(Thread.currentThread().getName() + "即将发布命令");
            cdOrder.await(); //线程阻塞 计数到0才会继续执行
            System.out.println(Thread.currentThread().getName() + "已经接受命令");
            Thread.sleep((long) (Math.random() * 10000));
            System.out.println(Thread.currentThread().getName() + "回应命令处理结果");
            cdAnswer.countDown(); //计数减1
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
