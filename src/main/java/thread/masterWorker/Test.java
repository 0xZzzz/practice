package thread.masterWorker;

import java.util.Map;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        //固定使用5个worker 并指定worker
        Master m = new Master(new PlusWorker(), 5);
        //提交100个子任务
        for (int i = 0; i < 100; i++) {
            m.submit(i);
        }
        m.execute(); //开始计算
        int result = 0; //计算结果保存在这
        Map<String, Object> resultMap = m.getResultMap();
        while (resultMap.size() > 0 || !m.isComplete()) {
            Set<String> keys = resultMap.keySet();
            String key = null;
            for (String k : keys) {
                key = k;
                break;
            }
            Integer i = null;
            if (key != null) {
                i = (Integer) resultMap.get(key);
            }
            if (i != null) {
                result += i; //最终
            }
            if (key != null) {
                resultMap.remove(key); //移除已经被计算过的项
            }
        }
        System.out.println(result);
    }
}
