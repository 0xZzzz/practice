package valueObject;

import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 * 订单接口 用于RMI调用
 * @author ZQ
 *
 */
public interface IOrderManager extends Remote{
	/**
	 * 获取订单
	 * @param id 订单id
	 * @return Order 订单信息
	 * @throws RemoteException
	 */
	public Order getOrder(int id) throws RemoteException;
	/**
	 * 获取客户端名称
	 * @param id 订单id
	 * @return 客户端名称
	 * @throws RemoteException
	 */
	public String getClientName(int id) throws RemoteException;
	/**
	 * 获取产品名称
	 * @param id 订单id
	 * @return 产品名称
	 * @throws RemoteException
	 */
	public String getProductName(int id) throws RemoteException;
	/**
	 * 获取数量
	 * @param id 订单id
	 * @return 数量
	 * @throws RemoteException
	 */
	public int getNumber(int id) throws RemoteException;
}
