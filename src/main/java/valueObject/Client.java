package valueObject;

import java.rmi.Naming;
/**
 * value object Ä£Ê½²âÊÔ
 * @author ZQ
 *
 */
public class Client {
	public static void main(String[] args) {
		try {
			IOrderManager userManager = (IOrderManager) Naming.lookup("OrderManager");
			long begin = System.currentTimeMillis();
			for (int i = 0; i < 1000; i++) {
				userManager.getOrder(i);
			}
			System.out.println("getOrder spend:" + (System.currentTimeMillis() - begin));
			begin = System.currentTimeMillis();
			for (int i = 0; i < 1000; i++) {
				userManager.getClientName(i);
				userManager.getNumber(i);
				userManager.getProductName(i);
			}
			System.out.println("3 methods spend" + (System.currentTimeMillis() - begin));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
