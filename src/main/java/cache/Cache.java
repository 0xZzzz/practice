package cache;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ʵ�ּ򵥵Ļ���ϵͳ
 */
public class Cache<T>{
	private Map<String, T> map = new HashMap<String, T>();
	private ReadWriteLock rwl = new ReentrantReadWriteLock();
	
	public T get(String key){
		rwl.readLock().lock();//��ȡ��ʱ���϶���
		T t = null;
		try {
			t = map.get(key);
			if(t == null){ 
				/*
				 * �������Ϊ��, �⿪������д��
				 */
				rwl.readLock().unlock(); 
				rwl.writeLock().lock();
				try {
					if(t == null){ //������̲߳���ʱ�ظ���ѯ���ݿ�
						//t = ���ݿ��ѯ
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
		return t;
	}
}
