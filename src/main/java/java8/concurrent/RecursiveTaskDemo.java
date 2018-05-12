package java8.concurrent;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;

/**
 * 递归任务
 *
 * @author 0xZzzz
 * @since 2018/5/11
 */
public class RecursiveTaskDemo {

    public static void main(String[] args) {
        System.err.println(new ForkJoinPool().invoke(new Task(IntStream.rangeClosed(1, 100).toArray())));
    }

    private static class Task extends RecursiveTask<Long> {

        private static final int THRESHOLD = 10; // 不再拆分的大小

        private final int[] array; // 待执行的对象数组

        private final int start;

        private final int end;

        public Task(int[] array) {
            this(array, 0, array.length);
        }

        private Task(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        @Override
        protected Long compute() {
            System.err.println("Task --> compute end: " + end + ", start: " + start);
            int length = end - start; // 当前任务负责计算的部分的大小
            if (length < THRESHOLD) {
                return arithmetic(); // 长度小于阈值执行进行计算
            }
            Task leftTask = new Task(array, start, start + length / 2); // 创建一个子任务为数组的前一半求和
            leftTask.fork(); // 利用另一个ForkJoinPool线程异步执行新创建的子任务
            Task rightTask = new Task(array, start + length / 2, end); // 创建一个子任务为数组的后一半求和
            Long rightResult = rightTask.compute(); //同步执行第二个子任务，有可能允许进一步递归划分
            Long leftResult = leftTask.join(); // 读取第一个子任务的结果，如果尚未完成就等待
            return leftResult + rightResult; // 结果为两个子任务的结果的组合
        }

        /**
         * 简单的任务执行算法
         */
        private long arithmetic() {
            long sum = 0;
            for (int i = start; i < end; i++) {
                sum += array[i];
            }
            return sum;
        }

    }

}
