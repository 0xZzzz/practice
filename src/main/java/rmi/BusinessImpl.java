package rmi;

import java.rmi.RemoteException;

/**
 * 服务端实现类
 *
 * @author 0xZzzz
 */
public class BusinessImpl implements Business {

    @Override
    public String echo(String message) throws RemoteException {
        if ("exit".equalsIgnoreCase(message)) {
            System.out.println("Server will be shutdown!");
            // 终止当前正在运行的 Java 虚拟机
            System.exit(0);
        }
        System.out.println("message from client: " + message);
        return "Server response: " + message;
    }

}
