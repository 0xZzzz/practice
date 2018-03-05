package thread.producerAndConsumer;

/**
 * 生产者和消费者之间的数据模型
 */
public class Data {
    private final int intData;

    public Data(int intData) {
        this.intData = intData;
    }

    public int getIntData() {
        return intData;
    }

    @Override
    public String toString() {
        return "Data [intData=" + intData + "]";
    }

}
