package thread.guardedSuspension;

import thread.future.Data;

/**
 * 请求对象
 */
public class Request {
	private String name;
	//请求返回值
	private Data response;

	public synchronized Data getResponse() {
		return response;
	}

	public synchronized void setResponse(Data response) {
		this.response = response;
	}

	public Request(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Request [name=" + name + "]";
	}

}
