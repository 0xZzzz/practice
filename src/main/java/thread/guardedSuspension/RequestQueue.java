package thread.guardedSuspension;

import java.util.LinkedList;
/**
 * 请求队列
 */
public class RequestQueue {
	//请求队列  保存所有的请求
	private LinkedList<Request> queue = new LinkedList<Request>();

	/**
	 * 获取请求
	 * @return
	 */
	public synchronized Request getRequest(){
		while(queue.size() == 0){
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		return this.queue.remove();
	}

	/**
	 * 添加请求
	 * @param req
	 */
	public synchronized void addRequest(Request req){
		queue.add(req);
		notifyAll();
	}
}
