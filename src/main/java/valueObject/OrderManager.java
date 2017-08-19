package valueObject;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class OrderManager extends UnicastRemoteObject implements IOrderManager{

	private static final long serialVersionUID = 1L;

	protected OrderManager() throws RemoteException {
		super();
	}

	@Override
	public Order getOrder(int id) throws RemoteException {
		Order o = new Order();
		o.setClientName("mm");
		o.setNumber(20);
		o.setProductName("gg");
		return o;
	}

	@Override
	public String getClientName(int id) throws RemoteException {
		return "mm";
	}

	@Override
	public String getProductName(int id) throws RemoteException {
		return "gg";
	}

	@Override
	public int getNumber(int id) throws RemoteException {
		return 20;
	}
	
}
