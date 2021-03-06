package thread.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 信号量Demo
 */
public class SemaphoreTest {
    private static final ExecutorService service = Executors.newCachedThreadPool();
    private static final Semaphore sp = new Semaphore(3);

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            service.execute(SemaphoreTest::task);
        }
        service.shutdown();
    }

    public static void task() {
        try {
            sp.acquire();
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        System.out.println("线程" + Thread.currentThread().getName()
                + "进入，当前已有" + (3 - sp.availablePermits()) + "个并发");
        try {
            Thread.sleep((long) (Math.random() * 10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程" + Thread.currentThread().getName()
                + "即将离开");
        sp.release();
        // 下面代码有时候执行不准确，因为其没有和上面的代码合成原子单元
        System.out.println("线程" + Thread.currentThread().getName()
                + "已离开，当前已有" + (3 - sp.availablePermits()) + "个并发");
    }
}
