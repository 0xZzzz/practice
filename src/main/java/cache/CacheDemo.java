package cache;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 实现简单的缓存系统
 */
public class CacheDemo {
	private Map<String, Object> map = new HashMap<String, Object>();
	private ReadWriteLock rwl = new ReentrantReadWriteLock();
	
	public Object get(String key){
		rwl.readLock().lock();//获取的时候上读锁
		Object obj = null;
		try {
			obj = map.get(key);
			if(obj == null){ 
				/*
				 * 如果对象为空, 解开读锁上写锁
				 */
				rwl.readLock().unlock(); 
				rwl.writeLock().lock();
				try {
					if(obj == null){ //避免多线程并发时重复查询数据库
						//obj = 数据库查询
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
		return obj;
	}
}
