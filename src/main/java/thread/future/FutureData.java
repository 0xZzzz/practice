package thread.future;

/**
 * 真实数据RealData的代理
 */
public class FutureData implements Data {

    protected RealData realData = null; //FutureData是RealData的包装

    protected volatile boolean isReady = false;

    public synchronized void setRealData(RealData realData) {
        if (isReady) {
            return;
        }
        this.realData = realData;
        isReady = true;
        notifyAll(); //RealData已经被注入, 通知getResult()
    }

    @Override
    public String getResult() { //会等待RealData构造完成
        while (!isReady) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        return realData.result;
    }

}
