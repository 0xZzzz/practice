package pattern.observer.jdk;

import java.util.Observable;

/**
 * ����ı��۲��߶���
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
        this.setChanged(); //֪ͨ�۸��Ѿ��ı�
        this.notifyObservers(); //�������еĹ۲���
    }

}
