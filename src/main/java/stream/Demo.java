package stream;

import common.entity.Param1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * stream demo
 *
 * @author 0xZzzz
 * @since 2018-05-04
 */
public class Demo {

    public static void main(String[] args) {

        /*
         * 流：遍历数据集的高级迭代器（可以并行）
         *
         * 注意：和迭代器一样，流只能消费一次
         */

        List<Param1> list = Arrays.asList(new Param1(1, "x"), new Param1(2, "xx"), new Param1(3, "xxx"), new Param1(4, "xxxx"), new Param1(5, "xxxxx"));

        List<Integer> resultList1 = list.stream().filter((p) -> p.getIntField() > 1).sorted(Comparator.comparing(Param1::getField1).reversed()).map(Param1::getIntField).collect(Collectors.toList());
        System.err.println("resultList1 --> " + resultList1);

        // limit
        List<String> resultList2 = list.stream().filter((p) -> p.getIntField() < 4).map(Param1::getField1).limit(1).collect(Collectors.toList());
        System.err.println("resultList2 --> " + resultList2);

        // skip
        List<String> resultList3 = list.stream().filter((p) -> p.getIntField() < 4).map(Param1::getField1).skip(1).collect(Collectors.toList());
        System.err.println("resultList3 --> " + resultList3);

        // skip 和 limit 是互补的

        // count
        long count = list.stream().filter((p) -> p.getIntField() > 2).count();
        System.err.println("count --> " + count);

        // forEach
        list.forEach(System.err::println);

        // distinct
        Stream.of(1, 2, 3, 4, 3, 5, 2).distinct().forEach(System.err::println);

        /*
         * 中间操作 filter、sorted、map、limit、skip...  返回值都为Stream
         * 终端操作 count、collect、forEach... 返回值不为Stream
         */

        //anyMatch | allMatch | noneMatch
        boolean anyMatch = list.stream().anyMatch((p) -> p.getIntField() > 2);
        System.err.println(anyMatch);

        // findAny，findFirst，区别是findAny在并行时限制较少
        Optional<Param1> optional = list.stream().filter((p) -> p.getIntField() > 2).findAny();
        System.err.println(optional.isPresent() ? optional.get() : null);
    }

}
