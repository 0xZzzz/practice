package cache;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ʵ�ּ򵥵Ļ���ϵͳ
 */
public class CacheDemo {
	private Map<String, Object> map = new HashMap<String, Object>();
	private ReadWriteLock rwl = new ReentrantReadWriteLock();
	
	public Object get(String key){
		rwl.readLock().lock();//��ȡ��ʱ���϶���
		Object obj = null;
		try {
			obj = map.get(key);
			if(obj == null){ 
				/*
				 * �������Ϊ��, �⿪������д��
				 */
				rwl.readLock().unlock(); 
				rwl.writeLock().lock();
				try {
					if(obj == null){ //������̲߳���ʱ�ظ���ѯ���ݿ�
						//obj = ���ݿ��ѯ
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					rwl.writeLock().unlock(); //Ϊ�˱�������, ʹ�� try finally �����
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
