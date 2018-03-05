package thread.threadPool;

/**
 * 线程池配合线程
 */
public class PThread extends Thread {
    //线程池
    private ThreadPool pool;
    //任务
    private Runnable target;
    //是否停止
    private boolean isShutdown = false;
    //标记状态 是否空闲
    private boolean isIdle = false;

    //构造函数
    public PThread(Runnable target, String name, ThreadPool pool) {
        super(name);
        this.pool = pool;
        this.target = target;
    }

    //返回任务
    public Runnable getTarget() {
        return target;
    }

    //返回线程闲置状态
    public boolean isIdle() {
        return isIdle;
    }

    @Override
    public void run() {
        //只要没有关闭, 则一直不结束该线程
        while (!isShutdown) {
            isIdle = false;
            if (target != null) {
                //运行任务
                target.run();
                //结束后置为闲置线程
                isIdle = true;
                try {
                    //该任务结束后, 不关闭线程, 而是放入线程池空闲队列
                    pool.rePool(this);
                    synchronized (this) {
                        //线程空闲, 等待新的任务到来
                        wait();
                    }
                } catch (InterruptedException e) {
                }
                isIdle = false;
            }
        }
    }

    //关闭线程
    public void shutdown() {
        //将状态置为关闭状态
        isShutdown = true;
        notifyAll();
    }

    //设置任务
    public void setTarget(Runnable newTarget) {
        target = newTarget;
        //设置任务之后, 通知run方法, 开始执行这个任务
        notifyAll();
    }


}
