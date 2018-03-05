package thread.guardedSuspension;

public class Test {

	public static void main(String[] args) {
		RequestQueue requestQueue = new RequestQueue();
		//服务进程开启
		for (int i = 0; i < 10; i++) {
			new Server(requestQueue, "server thread: " + i).start();
		}
		for (int i = 0; i < 10; i++) {
			new Client(requestQueue, "client thread: " + i).start();
		}
	}

}
