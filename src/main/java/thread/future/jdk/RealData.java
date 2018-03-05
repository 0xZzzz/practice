package thread.future.jdk;

import java.util.concurrent.Callable;

/**
 * jdk实现future模式
 */
public class RealData implements Callable<String> {

    private String para;

    public RealData(String para) {
        this.para = para;
    }

    @Override
    public String call() throws Exception {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(para);
            try {
                Thread.sleep(100);//模拟一个比较慢的操作过程
            } catch (InterruptedException e) {
            }
        }
        return sb.toString();
    }

}
