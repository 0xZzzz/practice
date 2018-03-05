package thread.future;

/**
 * 最终要使用的数据类型
 */
public class RealData implements Data {

    protected final String result;

    public RealData(String para) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            sb.append(para);
            try {
                Thread.sleep(100);//模拟一个比较慢的操作过程
            } catch (InterruptedException e) {
            }
        }
        result = sb.toString();
    }

    @Override
    public String getResult() {
        return result;
    }

}
