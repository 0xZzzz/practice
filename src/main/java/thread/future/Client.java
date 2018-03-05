package thread.future;

/**
 * 获取FutureData, 开启构造RealData的线程, 并在接受请求后, 很快地返回FutureData
 */
public class Client {

    public Data request(final String queryStr) {
        final FutureData futureData = new FutureData();
        new Thread() {
            public void run() { //RealData构建的很慢 所以在单独的线程中执行
                RealData realData = new RealData(queryStr);
                futureData.setRealData(realData);
            }
        }.start();
        return futureData; //futureData会被立即返回
    }

}
