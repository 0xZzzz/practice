package thread.thread;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Exchange 等待另一个线程达到交换点, 将自己的对象传递给对方, 接受对方的对象
 */
public class ExchangerTest {

    private static final Exchanger<String> exchanger = new Exchanger<>();

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        threadPool.execute(() -> exchange("data1"));
        threadPool.execute(() -> exchange("str2"));
        threadPool.shutdown();
    }

    public static void exchange(String str) {
        try {
            System.out.println(Thread.currentThread().getName() + "正在把数据" + str + "换出去");
            Thread.sleep((long) (Math.random() * 10000));
            System.out.println(Thread.currentThread().getName() + "交换回的数据为" + exchanger.exchange(str));
        } catch (Exception e) {

        }
    }

}
