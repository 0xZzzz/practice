package rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * rmi�ͻ���
 * @author ZQ
 *
 */
public class Client {
	public static void main(String[] args) throws Exception {
		String name = "BusinessDemo";
		Registry registry = LocateRegistry.getRegistry("localhost");
		Business business = (Business)registry.lookup(name);
		business.echo("yes");
		business.echo("exit");
	}
}
