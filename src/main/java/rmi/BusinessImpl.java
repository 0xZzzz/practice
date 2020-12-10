package rmi;

import java.rmi.RemoteException;

/**
 * �����ʵ����
 *
 * @author 0xZzzz
 */
public class BusinessImpl implements Business {

    @Override
    public String echo(String message) throws RemoteException {
        if ("exit".equalsIgnoreCase(message)) {
            System.out.println("Server will be shutdown!");
            // ��ֹ��ǰ�������е� Java �����
            System.exit(0);
        }
        System.out.println("message from client: " + message);
        return "Server response: " + message;
    }

}
