package thread.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 三个线程依次循环运行(注意: 要防止子线程无法启动的情况 将主线程的循环放在前面会导致死锁)
 */
public class ConditionDemo {
    public static void main(String[] args) {
        final Business business = new Business();

        new Thread(() -> loopTwo(business)).start();

        new Thread(() -> loopThree(business)).start();

        for (int i = 1; i <= 50; i++) {
            business.loopOne(i);
        }

    }

    private static void loopTwo(Business business) {
        for (int i = 1; i <= 50; i++) {
            business.loopTwo(i);
        }
    }

    private static void loopThree(Business business) {
        for (int i = 1; i <= 50; i++) {
            business.loopThree(i);
        }
    }

    static class Business {
        Lock lock = new ReentrantLock();
        Condition cOne = lock.newCondition();
        Condition cTwo = lock.newCondition();
        Condition cThree = lock.newCondition();

        private int index = 1;

        public void loopOne(int count) {
            lock.lock();
            try {
                while (index != 1) {
                    try {
                        cOne.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for (int i = 1; i <= 10; i++) {
                    System.out.println("Thread1: " + i + " 第" + count + "次");
                }
                index = 2;
                cTwo.signal();
            } finally {
                lock.unlock();
            }
        }

        public void loopTwo(int count) {
            lock.lock();
            try {
                while (index != 2) {
                    try {
                        cTwo.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for (int i = 1; i <= 20; i++) {
                    System.err.println("Thread2: " + i + " 第" + count + "次");
                }
                index = 3;
                cThree.signal();
            } finally {
                lock.unlock();
            }
        }

        public void loopThree(int count) {
            lock.lock();
            try {
                while (index != 3) {
                    try {
                        cThree.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for (int i = 1; i <= 30; i++) {
                    System.out.println("Thread3: " + i + " 第" + count + "次");
                }
                index = 1;
                cOne.signal();
            } finally {
                lock.unlock();
            }
        }
    }
}

