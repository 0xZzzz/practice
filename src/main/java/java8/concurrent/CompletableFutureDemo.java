package java8.concurrent;

import common.entity.Param1;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.concurrent.CompletableFuture.supplyAsync;

/**
 * @author 0xZzzz
 * @since 2018/5/14
 */
public class CompletableFutureDemo {

    public static void main(String[] args) throws Exception {
        /*
         * Future局限性：
         *      1、将两个异步计算合并为一个，这两个异步计算之间相互独立，同时第二个又依赖于第一个的结果
         *      2、等待Future集合中的所有任务完成
         *      3、仅等待Future集合中最快结束的任务完成（有可能因为它们试图通过不同的方式计算同一个值），并返回它的结果
         *      4、应对Future的完成事件（即当Future的完成事件发生时会收到通知，并能使用Future的结果进行下一步的操作，不只是简单地阻塞等待操作的结果）
         */
        CompletableFutureDemo demo = new CompletableFutureDemo();
        long start = System.currentTimeMillis();
        System.err.println(demo.thenAcceptDemo() + ", cost: " + (System.currentTimeMillis() - start) + "ms");

        // 与并行流的对比，可以灵活的配置线程池。选择：计算（CPU）密集型的操作推荐使用并行流，I/O密集型操作使用CompletableFuture，灵活性更好
    }

    private List<String> async1() {
        List<CompletableFuture<String>> rpcFutures = Stream.of(new Rpc(), new Rpc(), new Rpc()).map(rpc -> supplyAsync(rpc::call1)).collect(Collectors.toList());
        return rpcFutures.stream().map(CompletableFuture::join).collect(Collectors.toList());
    }

    private List<String> sync() {
        return Stream.of(new Rpc(), new Rpc(), new Rpc()).map(Rpc::call1).collect(Collectors.toList());
    }

    /**
     * 流水线
     */
    private List<String> async2() {
        List<CompletableFuture<String>> rpcFutures = Stream.of(new Rpc(), new Rpc(), new Rpc())
                .map(rpc -> supplyAsync(rpc::call1))
                .map(future -> future.thenApply(Rpc::call2))
                .map(future -> future.thenCompose(splicer -> supplyAsync(() -> Rpc.call3(splicer))))
                .collect(Collectors.toList());
        // thenCompose，传入的future需要使用第一个future的执行结果作为输入，需要等待第一个future执行结束
        return rpcFutures.stream().map(CompletableFuture::join).collect(Collectors.toList());
    }

    private String thenCombineDemo() throws Exception {
        // thenCombine，合并两个独立的CompletableFuture执行结果
        Param1 p = new Param1(1, "x");
        CompletableFuture future = CompletableFuture.supplyAsync(p::getIntField).thenCombine(supplyAsync(p::getField1), (i, s) -> i + s);
        return future.get().toString();
    }

    /**
     * 完成事件
     */
    private String thenAcceptDemo() {
        CompletableFuture[] futures = Stream.of(new Rpc(), new Rpc(), new Rpc()).map(rpc -> supplyAsync(rpc::call4)).map(future -> future.thenAccept(System.err::println)).toArray(CompletableFuture[]::new);
        CompletableFuture.allOf(futures).join();
        return "OK";
    }

    /**
     * 模拟RPC调用
     */
    private static class Rpc {

        private String call1() {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "1";
        }

        private static Splicer call2(String s) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return new Splicer(s, "2");
        }

        private static String call3(Splicer splicer) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return splicer.concat();
        }

        private String call4() {
            long delay = 500 + new Random().nextInt(2000);
            try {
                TimeUnit.MILLISECONDS.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return delay + "";
        }

    }

    private static class Splicer {

        private String s1;

        private String s2;

        private Splicer(String s1, String s2) {
            this.s1 = s1;
            this.s2 = s2;
        }

        private String concat() {
            return s1 + s2;
        }

    }

}
