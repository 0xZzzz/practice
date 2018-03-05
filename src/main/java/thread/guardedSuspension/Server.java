package thread.guardedSuspension;

import thread.future.FutureData;
import thread.future.RealData;

/**
 * 服务端
 */
public class Server extends Thread{
	//维护请求队列
	private RequestQueue requestQueue;

	/**
	 * 构造方法初始化
	 * @param requestQueue
	 * @param name
	 */
	public Server(RequestQueue requestQueue, String name) {
		super(name);
		this.requestQueue = requestQueue;
	}

	@Override
	public void run() {
		while (true) {
			final Request request = requestQueue.getRequest();
			final FutureData futureData = (FutureData)request.getResponse();
			RealData realData = new RealData(request.getName());
			futureData.setRealData(realData);
			try {
				//模拟处理时间
				sleep(100);
			} catch (InterruptedException e) {
			}
			System.out.println(Thread.currentThread().getName() + " handles " + request);
		}
	}
}
