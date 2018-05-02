package lambda;

import common.entity.Param;
import common.entity.Param1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * lambda demo
 */
public class Demo {

    public static void main(String[] args) {
        /*
         * 函数接口：有且仅有一个抽象方法的接口（默认方法和静态方法都不算）@FunctionalInterface
         * 形式：
         *      (parameters) -> expression
         *      (parameters) -> { statement; }
         */
    }

    public void demo() {
        // lambda
        Comparator<Param1> comparator1 = new Comparator<Param1>() {
            @Override
            public int compare(Param1 o1, Param1 o2) {
                return o1.getIntField() > o2.getIntField() ? 1 : -1;
            }
        };

        Comparator<Param1> comparator2 = (Param1 o1, Param1 o2) -> {
            return o1.getIntField() > o2.getIntField() ? 1 : -1;
        };

        Comparator<Param1> comparator3 = (Param1 o1, Param1 o2) -> o1.getIntField() > o2.getIntField() ? 1 : -1;
        // 类型推断
        Comparator<Param1> comparator4 = (o1, o2) -> o1.getIntField() > o2.getIntField() ? 1 : -1;

        // Predicate：用于表示一个涉及类型T的布尔表达式 T -> boolean
        Predicate<Param> paramPredicate = (p) -> p.getField().length() > 0;
        demoPredicate(new ArrayList<>(), paramPredicate);

        // Consumer：用于执行类型T对象的的某些操作 T -> void
        Consumer<Param> paramConsumer = Param::a;
        demoConsumer(new ArrayList<>(), paramConsumer);

        // Function：用于接受一个类型T对象，并返回E对象 T -> E
        Function<Param, Param1> paramFunction = (Param p) -> new Param1();
        demoFunction(new ArrayList<>(), paramFunction);

        // 方法引用

        // 构造函数引用
        Supplier<Param> paramSupplier = Param::new;
        Param param = paramSupplier.get();

        // 比较器符合
        new ArrayList<Param1>().sort(Comparator.comparing(Param1::getIntField).reversed().thenComparing(Param1::getField1));
    }

    /**
     * Predicate demo
     */
    private void demoPredicate(List<Param> list, Predicate<Param> paramSupplier) {
        for (Param param : list) {
            if (paramSupplier.test(param)) {
                //do something
            }
        }
    }

    /**
     * Consumer demo
     */
    private void demoConsumer(List<Param> list, Consumer<Param> paramConsumer) {
        for (Param param : list) {
            paramConsumer.accept(param);
        }
    }

    /**
     * Function demo
     */
    private void demoFunction(List<Param> list, Function<Param, Param1> paramFunction) {
        for (Param param : list) {
            Param1 param1 = paramFunction.apply(param);
        }
    }

}
