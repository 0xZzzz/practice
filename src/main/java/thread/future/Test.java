package thread.future;

public class Test {

    public static void main(String[] args) {
        Client client = new Client();
        //这里会立即返回, 因为得到的是FutureData而不是RealData
        Data data = client.request("name");
        System.out.println("请求完毕");
        try {
            //代替其他业务处理的逻辑
            //处理这些逻辑的过程中, RealData被创建, 充分利用了等待时间
            Thread.sleep(2000);
        } catch (Exception e) {
        }
        System.out.println("数据 = " + data.getResult());
    }

}
