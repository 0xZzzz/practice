package thread.thread;

import java.util.Random;

/**
 * 创建线程独享的对象
 */
public class ThreadOwnData {

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new Thread(ThreadOwnData::task).start();
        }
    }

    public static void task() {
        Data data = Data.getThreadInstance();
        data.setIndex(new Random().nextInt(100));
        new A().get();
        new B().get();
    }

    static class A {
        public void get() {
            Data data = Data.getThreadInstance();
            System.out.println(Thread.currentThread().getName() + ": " + data.getIndex());
        }
    }

    static class B {
        public void get() {
            Data data = Data.getThreadInstance();
            System.out.println(Thread.currentThread().getName() + ": " + data.getIndex());
        }
    }
}

class Data {
    private static Data threadData = null;
    private static ThreadLocal<Data> tl = new ThreadLocal<Data>();

    private Data() {
    }

    public static Data getThreadInstance() {
        if (threadData == null) {
            threadData = new Data();
            tl.set(threadData);
        }
        return tl.get();
    }

    private int index;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}