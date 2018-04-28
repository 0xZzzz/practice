package lambda;

import common.entity.Param1;

import java.util.Comparator;

/**
 * lambda demo
 */
public class Demo {

    public static void main(String[] args) {

    }

    public void demo1() {
        Comparator<Param1> comparator1 = new Comparator<Param1>() {
            @Override
            public int compare(Param1 o1, Param1 o2) {
                return o1.getIntField() > o2.getIntField() ? 1 : -1;
            }
        };

        Comparator<Param1> comparator2 = (Param1 o1, Param1 o2) -> o1.getIntField() > o2.getIntField() ? 1 : -1;
    }

}
