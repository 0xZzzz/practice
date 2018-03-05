package thread.thread;

/**
 * 实现: 四个线程同时操作一个整数, 两个加, 两个减
 */
public class ThreadOperateData {
    private static int count = 10;

    public static void main(String[] args) {
        final OperateCount oc = new OperateCount();
        for (int i = 0; i < 2; i++) {
            new Thread(() -> up(oc)).start();
            new Thread(() -> down(oc)).start();
        }
    }

    private static void up(OperateCount oc) {
        while (true) {
            oc.up();
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void down(OperateCount oc) {
        while (true) {
            oc.down();
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class OperateCount {

        public synchronized void up() {
            ++count;
            System.out.println(Thread.currentThread().getName() + " + 1: " + count);
        }

        public synchronized void down() {
            --count;
            System.err.println(Thread.currentThread().getName() + " - 1: " + count);
        }
    }
}
