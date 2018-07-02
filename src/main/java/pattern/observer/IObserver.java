package pattern.observer;

/**
 * 观察者接口
 */
public interface IObserver {

    //更新方法
    void update(ISubject subject);
}
