package pattern.observer;

/**
 * 观察者接口
 *
 * @author 0xZzzz
 */
public interface IObserver {

    /**
     * 变更通知
     *
     * @param subject 主题
     */
    void update(ISubject subject);
}
