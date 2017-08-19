package valueObject;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Server {
	public static void main(String[] args) {
		try {
			LocateRegistry.createRegistry(1099);
			IOrderManager userManager = new OrderManager();
			Naming.rebind("OrderManager", userManager);
			System.out.println("OrderManager is ready...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
