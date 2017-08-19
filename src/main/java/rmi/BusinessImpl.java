package rmi;

import java.rmi.RemoteException;
/**
 * �����ʵ����
 * @author ZQ
 *
 */
public class BusinessImpl implements Business {

	@Override
	public String echo(String message) throws RemoteException {
		if("exit".equalsIgnoreCase(message.toString())){
			System.out.println("Server will be shutdown!");
			System.exit(0); //��ֹ��ǰ�������е� Java �����
		}
		System.out.println("message from client: "+message);
		return "Server response: "+message;
	}

}
