package buffer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * �󶨻����� (��������)
 * @author ZQ
 *
 */
public class BoundedBuffer {
	private Object[] items;
	private final Lock lock = new ReentrantLock();
	private final Condition notFull = lock.newCondition(); //��������
	private final Condition notEmpty = lock.newCondition(); //��������
	/*
	 * putIndex: ����������
	 * takeIndex: ȡ��������
	 * count: ���������еĶ�����
	 */
	private int putIndex, takeIndex, count;
	
	public BoundedBuffer(int size){
		items = new Object[size];
	}
	/**
	 * �������(�����ж�����ʱ���ܷŶ���)
	 * @param obj
	 * @throws InterruptedException
	 */
	public void put(Object obj) throws InterruptedException{
		lock.lock();
		try {
			while(count == items.length){ //������������д����˶���, �ò�����������
				notFull.await();
			}
			items[putIndex] = obj; //����������鲻��, ��������, ����������������1
			if(++putIndex == items.length){ 
				putIndex = 0;
			}
			++count; //����������1
			notEmpty.signal(); //���Ѳ�����������ȡ��
		} finally {
			lock.unlock();
		}
	}
	/**
	 * ȡ����(�����ж��󲻿�ʱ����ȡ����)
	 * @return
	 * @throws InterruptedException
	 */
	public Object take() throws InterruptedException{
		lock.lock();
		try {
			while(count == 0){//�����������û������, �ò�����������
				notEmpty.await();
			}
			Object obj = items[takeIndex];
			if(++takeIndex == items.length){ //����������鲻Ϊ����ȡ��һ������, ����ȡ������1
				takeIndex = 0;
			}
			--count; //����������1
			notFull.signal(); //���Ѳ����������Է���
			return obj;
		} finally {
			lock.unlock();
		}
	}
}
