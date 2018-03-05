package thread.thread;

import java.util.concurrent.Semaphore;

/**
 * 对象池(对象池中存有100个对象, 当有超过100个对象请求时, 超过的部分会等待, 当某个线程使用完对象放回池中后, 可以激活一个等待的请求)
 */
public class SemaphoreObjPool {
    //对象池中最大可用数量
    private static final int MAX_AVAILABLE = 100;
    //最大可以有100个许可
    private final Semaphore available = new Semaphore(MAX_AVAILABLE, true);

    //获取一个池内的对象
    public Object getItem() throws InterruptedException {
        /*
		 * 申请一个许可
		 * 同时只能有100个线程进入取得
		 * 可用项, 超过100个则需要等待
		 */
        available.acquire();

        return getNextAvailableItem();
    }

    //将给定对象放入池内
    public void putItem(Object x) {
        //标记为未使用
        if (markAsUnused(x)) {
            //新增了一个可用项, 释放一个许可, 请求资源的线程被激活一个
            available.release();
        }
    }

    protected Object[] items = new Object[MAX_AVAILABLE]; //这里存放对象池中复用的对象
    //用于标记池中的项是否正在被使用
    protected boolean[] used = new boolean[MAX_AVAILABLE];

    //获取可用的对象
    private synchronized Object getNextAvailableItem() {
        //如果当前项未被使用, 则获得它, 并将当前项标记为已经使用
        for (int i = 0; i < MAX_AVAILABLE; i++) {
            if (used[i]) {
                used[i] = true;
                return items[i];
            }
        }
        return null;
    }

    //池中的对应对象置为未使用
    protected synchronized boolean markAsUnused(Object item) {
        for (int i = 0; i < MAX_AVAILABLE; i++) {
            if (item == items[i]) {
                if (used[i]) {
                    used[i] = false;
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
}
