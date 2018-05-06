package stream;

import common.entity.Param1;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * stream demo
 *
 * @author 0xZzzz
 * @since 2018-05-04
 */
public class Demo {

    public static void main(String[] args) throws Exception {

        /*
         * 流：遍历数据集的高级迭代器（可以并行）
         *
         * 注意：和迭代器一样，流只能消费一次
         */

        List<Param1> list = Arrays.asList(new Param1(1, "x"), new Param1(2, "xx"), new Param1(3, "xxx"), new Param1(4, "xxxx"), new Param1(5, "xxxxx"));

        List<Integer> resultList1 = list.stream().filter(p -> p.getIntField() > 1).sorted(Comparator.comparing(Param1::getField1).reversed()).map(Param1::getIntField).collect(Collectors.toList());
        System.err.println("resultList1 --> " + resultList1);

        // limit
        List<String> resultList2 = list.stream().filter(p -> p.getIntField() < 4).map(Param1::getField1).limit(1).collect(Collectors.toList());
        System.err.println("resultList2 --> " + resultList2);

        // skip
        List<String> resultList3 = list.stream().filter(p -> p.getIntField() < 4).map(Param1::getField1).skip(1).collect(Collectors.toList());
        System.err.println("resultList3 --> " + resultList3);

        // skip 和 limit 是互补的

        // count
        long count = list.stream().filter(p -> p.getIntField() > 2).count();
        System.err.println("count --> " + count);

        // forEach
        list.forEach(System.err::println);

        // distinct
        Stream.of(1, 2, 3, 4, 3, 5, 2).distinct().forEach(System.err::println);

        /*
         * 中间操作 filter、sorted、map、limit、skip...  返回值都为Stream
         * 终端操作 count、collect、forEach、reduce... 返回值不为Stream
         */

        //anyMatch | allMatch | noneMatch
        boolean anyMatch = list.stream().anyMatch(p -> p.getIntField() > 2);
        System.err.println(anyMatch);

        // findAny，findFirst，区别是findAny在并行时限制较少
        Optional<Param1> optional = list.stream().filter(p -> p.getIntField() > 2).findAny();
        System.err.println(optional.isPresent() ? optional.get() : null);

        // reduce 归约，将流归约成一个值
        Optional<Integer> optionalInt1 = Stream.of(1, 2, 3, 4, 3, 5, 2).filter(i -> i > 2).reduce((i1, i2) -> i1 + i2);
        System.err.println(optionalInt1.isPresent() ? optionalInt1.get() : null);

        Optional<Integer> optionalInt2 = Stream.of(1, 2, 3, 4, 3, 5, 2).reduce(Integer::max);
        System.err.println(optionalInt2.isPresent() ? optionalInt2.get() : null);

        // 数值流 可以避免自动拆装箱的性能损耗 mapToInt 对象流转换成数值流 boxed 转换回对象流
        int sum = list.stream().filter(p -> p.getIntField() > 3).mapToInt(Param1::getIntField).sum();
        System.err.println(sum);

        OptionalInt max = list.stream().filter(p -> p.getIntField() > 3).mapToInt(Param1::getIntField).max();
        System.err.println(max.isPresent() ? max.getAsInt() : null);

        // 数值范围 range 不包括结束值 rangeClose 包含结束值
        long count1 = IntStream.range(1, 5).filter(i -> i % 2 == 0).count();
        System.err.println(count1);

        // 创建流的方法
        Stream<Integer> stream1 = Stream.of(1, 2, 3, 4, 5);
        IntStream stream2 = Arrays.stream(new int[]{1, 2, 3, 4, 5});
//        Stream<String> stream3 = Files.lines(Paths.get("xxx.txt"));
        Stream<Integer> stream4 = Stream.iterate(0, n -> n + 2).limit(10);
        // 斐波那契序列
        Stream.iterate(new int[]{0, 1}, a -> new int[]{a[1], a[0] + a[1]}).limit(10).map(a -> a[0]).forEach(System.err::println);
        Stream.generate(Math::random).limit(3).forEach(System.err::println);

        // 汇总 summingInt
        int total = list.stream().collect(Collectors.summingInt(Param1::getIntField));
        System.err.println(total);

        // 平均值 averagingInt
        double avg = list.stream().collect(Collectors.averagingInt(Param1::getIntField));
        System.err.println(avg);

        // 字符串拼接 joining
        String join = list.stream().map(Param1::getField1).collect(Collectors.joining(", "));
        System.err.println(join);

        // 分组 groupingBy
        List<Param1> list1 = Arrays.asList(new Param1(2, "x"), new Param1(2, "xx"), new Param1(3, "xxx"), new Param1(3, "xxxx"), new Param1(5, "xxxxx"));
        Map<Integer, List<Param1>> group = list1.stream().collect(Collectors.groupingBy(Param1::getIntField));
        System.err.println(group);

        // 分区 partitioningBy
        Map<Boolean, List<Param1>> partition = list.stream().collect(Collectors.partitioningBy(p -> p.getIntField() > 2));
        System.err.println(partition);

        // 并行流
        list.parallelStream();
        list.stream().parallel();

        // 扁平化 flatMap
        List<String> list2 = list.stream().map(p -> p.getField1().split("")).flatMap(Arrays::stream).collect(Collectors.toList());
        System.err.println(list2);
    }

}
