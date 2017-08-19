package valueObject;

import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 * �����ӿ� ����RMI����
 * @author ZQ
 *
 */
public interface IOrderManager extends Remote{
	/**
	 * ��ȡ����
	 * @param id ����id
	 * @return Order ������Ϣ
	 * @throws RemoteException
	 */
	public Order getOrder(int id) throws RemoteException;
	/**
	 * ��ȡ�ͻ�������
	 * @param id ����id
	 * @return �ͻ�������
	 * @throws RemoteException
	 */
	public String getClientName(int id) throws RemoteException;
	/**
	 * ��ȡ��Ʒ����
	 * @param id ����id
	 * @return ��Ʒ����
	 * @throws RemoteException
	 */
	public String getProductName(int id) throws RemoteException;
	/**
	 * ��ȡ����
	 * @param id ����id
	 * @return ����
	 * @throws RemoteException
	 */
	public int getNumber(int id) throws RemoteException;
}
