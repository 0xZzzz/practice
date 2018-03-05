package thread.future.jdk;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class Test {
    public static void main(String[] args) throws Exception {
        //构造futureTask
        FutureTask<String> future = new FutureTask<String>(new RealData("a"));
        ExecutorService executor = Executors.newFixedThreadPool(1);
        //执行futureTask, 相当于上列中的client.request("a") 发送请求
        //在这里开启线程进行RealData的call()执行
        executor.execute(future);
        System.out.println("请求完毕");
        //这里依然可以做额外的数据操作, 这里使用sleep代替其他业务逻辑的处理
        Thread.sleep(2000);
        System.out.println("数据 = " + future.get());
    }
}
