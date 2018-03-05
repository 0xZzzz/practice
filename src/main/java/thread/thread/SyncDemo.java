package thread.thread;

/**
 * 实现: 主线程循环100次, 子线程接着循环10次, 这样循环50次
 */
public class SyncDemo {

    public static void main(String[] args) {
        final Business b = new Business();
        new Thread(() -> task(b)).start();

        for (int i = 1; i <= 50; i++) {
            b.mainThread(i);
        }
    }

    private static void task(Business b) {
        for (int i = 1; i <= 50; i++) {
            b.subThread(i);
        }
    }
}

/**
 * 线程业务逻辑
 */
class Business {

    private boolean flag = true;

    /**
     * 主线程 当flag = true 时主线程运行
     *
     * @param count 线程运行的次数
     */
    public synchronized void mainThread(int count) {
        while (!flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 1; i <= 100; i++) {
            System.out.println(count + " main: " + i);
        }
        flag = false;
        this.notify();
    }

    /**
     * 子线程 当flag = false 时子线程运行
     *
     * @param count 线程运行的次数
     */
    public synchronized void subThread(int count) {
        while (flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 1; i <= 10; i++) {
            System.err.println(count + " sub: " + i);
        }
        flag = true;
        this.notify();
    }
}
