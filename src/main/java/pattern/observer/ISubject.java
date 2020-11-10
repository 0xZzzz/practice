package pattern.observer;

/**
 * 主题接口 被观察者
 *
 * @author 0xZzzz
 */
public interface ISubject {

    /**
     * 添加观察者
     *
     * @param observer 观察者实例
     * @return 是否添加成功
     */
    boolean add(IObserver observer);

    /**
     * 移除观察者
     *
     * @param observer 观察者实例
     * @return 是否移除成功
     */
    boolean remove(IObserver observer);

    /**
     * 通知所有观察者
     */
    void notifyAllObserver();

    /**
     * 设置温度
     *
     * @param temperature 温度值
     */
    void setTemperature(float temperature);

    /**
     * 获得温度预警
     *
     * @return 温度预警文案
     */
    String temperatureReport();
}
