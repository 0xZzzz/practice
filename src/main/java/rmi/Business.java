package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 * 服务端对外提供的接口
 * @author ZQ
 *
 */
public interface Business extends Remote{
	public String echo(String message) throws RemoteException;
}
