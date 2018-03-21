package cache;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 实现简单的缓存系统
 */
public class Cache<T> {
    private Map<String, T> map = new HashMap<String, T>();
    private ReadWriteLock rwl = new ReentrantReadWriteLock();

    public T get(String key) {
        rwl.readLock().lock();//获取的时候上读锁
        T t = null;
        try {
            t = map.get(key);
            if (t == null) {
                /*
				 * 如果对象为空, 解开读锁上写锁
				 */
                rwl.readLock().unlock();
                rwl.writeLock().lock();
                try {
                    if (t == null) { //避免多线程并发时重复查询数据库
                        //t = 数据库查询
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    rwl.writeLock().unlock(); //为了避免死锁, 使用 try finally 块解锁
                }
                rwl.readLock().lock();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rwl.readLock().unlock();
        }
        return t;
    }
}
