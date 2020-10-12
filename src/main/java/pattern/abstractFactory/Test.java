package pattern.abstractFactory;

public class Test {

    public static void main(String[] args) {
        IKFCFactory ikfcFactory = new ChinaKFCFactory();
        Customer customer = new Customer(ikfcFactory);
        double hamburgerPrice = customer.orderHamburger(2);
        double drinkPrice = customer.orderDrink(1);
        System.out.println("你订购食物的总价为: " + (hamburgerPrice + drinkPrice));
    }

}
