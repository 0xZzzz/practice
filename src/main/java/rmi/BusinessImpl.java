package rmi;

import java.rmi.RemoteException;
/**
 * 服务端实现类
 * @author ZQ
 *
 */
public class BusinessImpl implements Business {

	@Override
	public String echo(String message) throws RemoteException {
		if("exit".equalsIgnoreCase(message.toString())){
			System.out.println("Server will be shutdown!");
			System.exit(0); //终止当前正在运行的 Java 虚拟机
		}
		System.out.println("message from client: "+message);
		return "Server response: "+message;
	}

}
