package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 * ����˶����ṩ�Ľӿ�
 * @author ZQ
 *
 */
public interface Business extends Remote{
	public String echo(String message) throws RemoteException;
}
