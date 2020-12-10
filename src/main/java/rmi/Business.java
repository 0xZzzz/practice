package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 业务逻辑
 *
 * @author 0xZzzz
 */
public interface Business extends Remote {

    /**
     * 执行命令
     *
     * @param message 命令内容
     * @return 执行响应
     * @throws RemoteException rmi 异常
     */
    String echo(String message) throws RemoteException;

}
