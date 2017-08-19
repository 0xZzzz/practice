package buffer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 绑定缓冲区 (阻塞队列)
 * @author ZQ
 *
 */
public class BoundedBuffer {
	private Object[] items;
	private final Lock lock = new ReentrantLock();
	private final Condition notFull = lock.newCondition(); //不满条件
	private final Condition notEmpty = lock.newCondition(); //不空条件
	/*
	 * putIndex: 放数据索引
	 * takeIndex: 取数据索引
	 * count: 对象数组中的对象数
	 */
	private int putIndex, takeIndex, count;
	
	public BoundedBuffer(int size){
		items = new Object[size];
	}
	/**
	 * 放入对象(数组中对象不满时才能放对象)
	 * @param obj
	 * @throws InterruptedException
	 */
	public void put(Object obj) throws InterruptedException{
		lock.lock();
		try {
			while(count == items.length){ //如果对象数组中存满了对象, 让不满条件等着
				notFull.await();
			}
			items[putIndex] = obj; //如果对象数组不满, 则放入对象, 并将放数据索引加1
			if(++putIndex == items.length){ 
				putIndex = 0;
			}
			++count; //对象总数加1
			notEmpty.signal(); //唤醒不空条件可以取了
		} finally {
			lock.unlock();
		}
	}
	/**
	 * 取对象(数组中对象不空时才能取对象)
	 * @return
	 * @throws InterruptedException
	 */
	public Object take() throws InterruptedException{
		lock.lock();
		try {
			while(count == 0){//如果对象数组没对象了, 让不空条件等着
				notEmpty.await();
			}
			Object obj = items[takeIndex];
			if(++takeIndex == items.length){ //如果对象数组不为空则取出一个对象, 并讲取索引加1
				takeIndex = 0;
			}
			--count; //对象总数减1
			notFull.signal(); //唤醒不满条件可以放了
			return obj;
		} finally {
			lock.unlock();
		}
	}
}
