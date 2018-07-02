package pattern.observer.jdk;

import java.util.Observable;

/**
 * 具体的被观察者对象
 *
 * @author 0xZzzz
 */
public class Doll extends Observable {
    private double price;

    public Doll(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
        this.setChanged(); //通知价格已经改变
        this.notifyObservers(); //告诉所有的观察着
    }

}
