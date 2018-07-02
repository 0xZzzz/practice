package pattern.observer.jdk;

import java.util.Observable;
import java.util.Observer;

/**
 * ����Ĺ۲��߶���
 *
 * @author 0xZzzz
 */
public class Person implements Observer {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Doll) {
            Doll doll = (Doll) o;
            System.out.println(name + "��ע�����޼۸��Ѿ�����Ϊ: " + doll.getPrice());
        }
    }
}
