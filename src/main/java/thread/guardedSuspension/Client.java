package thread.guardedSuspension;

import thread.future.FutureData;

import java.util.ArrayList;
import java.util.List;

/**
 * 客户端
 */
public class Client extends Thread{
	//向请求队列中添加请求
	private RequestQueue requestQueue;

	private List<Request> myRequest = new ArrayList<Request>();

	public Client(RequestQueue requestQueue, String name) {
		super(name);
		this.requestQueue = requestQueue;
	}

	@Override
	public void run() {
		for (int i = 0; i <10; i++) {
			Request request = new Request("request id: " + i + " thread name: " + Thread.currentThread().getName());
			System.out.println(Thread.currentThread().getName() + " requests " + request);
			//设置一个futureData返回值
			request.setResponse(new FutureData());
			requestQueue.addRequest(request);
			//发送请求
			myRequest.add(request);
			try {
				//客户端请求的速度快于服务端处理的速度
				Thread.sleep(10);
			} catch (InterruptedException e) {
			}
		}

		for (Request r : myRequest) {
			System.out.println("client thread name is: " + Thread.currentThread().getName() + "response is: " + r.getResponse().getResult());
		}

	}

}
