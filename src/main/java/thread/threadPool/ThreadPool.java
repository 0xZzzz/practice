package thread.threadPool;

import java.util.List;
import java.util.Vector;

/**
 * 线程池 (需要一个永不退出的线程与之配合)
 */
public class ThreadPool {
    // 单例模式
    private static ThreadPool instance = null;
    // 保存闲置的线程
    private List<PThread> idleThreads;
    // 保存已有的线程数
    private int threadCounter;

    private boolean isShutdown = false;

    private ThreadPool() {
        this.idleThreads = new Vector<PThread>(5);
        threadCounter = 0;
    }

    // 获取线程池中线程的数量
    public int getCreatedThreadsCount() {
        return threadCounter;
    }

    // 单例模式提供一个静态方法获取实例
    public synchronized static ThreadPool getInstance() {
        if (instance == null) {
            instance = new ThreadPool();
        }
        return instance;
    }

    // 将线程放入池中
    protected synchronized void rePool(PThread repoolingThread) {
        if (!isShutdown) {
            idleThreads.add(repoolingThread);
        } else {
            repoolingThread.shutdown();
        }
    }

    // 停止所有线程
    public synchronized void shutdown() {
        isShutdown = true;
        for (PThread idleThread : idleThreads) {
            idleThread.shutdown();
        }
    }

    //执行任务
    public synchronized void start(Runnable target) {
        PThread thread = null;
        //如果有空闲线程则直接使用
        if (idleThreads.size() > 0) {
            //获取池中的最后一个线程
            int lastIndex = idleThreads.size() - 1;
            thread = idleThreads.get(lastIndex);
            idleThreads.remove(lastIndex);
            thread.setTarget(target);
        } else {
            //如果没有空闲线程, 则创建新的线程
            threadCounter++;
            thread = new PThread(target, "PThread #" + threadCounter, this);
            //启动这个线程
            thread.start();
        }
    }
}
