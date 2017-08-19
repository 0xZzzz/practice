package rmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
/**
 * rmi�����
 * @author ZQ
 *
 */
public class Server {
	public static void main(String[] args) throws Exception {
		int port = 9527;
		String name = "BusinessDemo";
		Business business = new BusinessImpl();
		UnicastRemoteObject.exportObject(business, port); //ʹ���ṩ���ض��˿ڵ���Զ�̶����Ա��ܹ����մ���ĵ���
		LocateRegistry.createRegistry(1099); //��������������ָ�� port ����ı��������ϵ� Registryʵ��
		Naming.bind(name, business);
	}
}
