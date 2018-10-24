package thread.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 三个线程依次循环运行从1打印到100
 *
 * @author 0xZzzz
 */
public class ConditionDemo1 {

    private static final int MAX = 100;

    public static void main(String[] args) {
        Loop loop = new Loop();
        new Thread(() -> loop.one()).start();
        new Thread(() -> loop.two()).start();
        new Thread(() -> loop.three()).start();
    }

    static class Loop {
        private ReentrantLock lock = new ReentrantLock();
        private Condition condition1 = lock.newCondition();
        private Condition condition2 = lock.newCondition();
        private Condition condition3 = lock.newCondition();

        private int i = 0;

        private int index = 1;

        public void one() {
            lock.lock();
            try {
                while (i < MAX) {
                    while (index != 1) {
                        condition1.await();
                    }
                    print();
                    index = 2;
                    condition2.signal();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void two() {
            lock.lock();
            try {
                while (i < MAX) {
                    while (index != 2) {
                        condition2.await();
                    }
                    print();
                    index = 3;
                    condition3.signal();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void three() {
            lock.lock();
            try {
                while (i < MAX) {
                    while (index != 3) {
                        condition3.await();
                    }
                    print();
                    index = 1;
                    condition1.signal();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void print() {
            i++;
            System.out.println(Thread.currentThread().getName() + ": " + i);
            if (i == MAX) {
                System.exit(1);
            }
        }

    }

}

