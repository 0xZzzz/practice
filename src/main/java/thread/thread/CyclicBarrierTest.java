package thread.thread;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CyclicBarrier: 控制若干线程全部都到达某一点之后再继续执行
 */
public class CyclicBarrierTest {

    private static final CyclicBarrier cb = new CyclicBarrier(3);
    private static final ExecutorService service = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            service.execute(CyclicBarrierTest::task);
        }
        service.shutdown();
    }

    public static void task() {
        try {
            Thread.sleep((long) (Math.random() * 10000));
            System.out.println("线程"
                    + Thread.currentThread().getName()
                    + "即将到达集合地点1，当前已有"
                    + (cb.getNumberWaiting() + 1)
                    + "个已经到达，"
                    + (cb.getNumberWaiting() == 2 ? "都到齐了，继续走啊"
                    : "正在等候"));
            cb.await();

            Thread.sleep((long) (Math.random() * 10000));
            System.out.println("线程"
                    + Thread.currentThread().getName()
                    + "即将到达集合地点2，当前已有"
                    + (cb.getNumberWaiting() + 1)
                    + "个已经到达，"
                    + (cb.getNumberWaiting() == 2 ? "都到齐了，继续走啊"
                    : "正在等候"));
            cb.await();
            Thread.sleep((long) (Math.random() * 10000));
            System.out.println("线程"
                    + Thread.currentThread().getName()
                    + "即将到达集合地点3，当前已有"
                    + (cb.getNumberWaiting() + 1)
                    + "个已经到达，"
                    + (cb.getNumberWaiting() == 2 ? "都到齐了，继续走啊"
                    : "正在等候"));
            cb.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
