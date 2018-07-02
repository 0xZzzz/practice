package pattern.observer;

/**
 * 主题接口 被观察者
 */
public interface ISubject {

    //添加观察者
    boolean add(IObserver observer);

    //删除观察者
    boolean remove(IObserver observer);

    //通知所有观察者
    void notifyAllObserver();

    //设置温度
    void setTemperature(float temperature);

    //获得温度预警
    String temperatureReport();
}
