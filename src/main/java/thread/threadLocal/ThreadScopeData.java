package thread.threadLocal;

/**
 * ThreadLocal 相当于存储了Map<Thread, T> 的方式
 */
public class ThreadScopeData {
    //线程本地变量
    private static ThreadLocal<ThreadScopeData> threadLocalData = new ThreadLocal<ThreadScopeData>();

    //构造方法私有化
    private ThreadScopeData() {
    }

    //饿汉模式
    private static ThreadScopeData threadScopeData = null;

    //获取线程本地变量
    public static ThreadScopeData getThreadScopeInstance() {
        //每个线程获取属于自己线程的变量，是线程安全的
        threadScopeData = threadLocalData.get();
        if (threadScopeData == null) {
            threadScopeData = new ThreadScopeData();
            threadLocalData.set(threadScopeData);
        }
        return threadScopeData;
    }

    private Integer data;

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

}
