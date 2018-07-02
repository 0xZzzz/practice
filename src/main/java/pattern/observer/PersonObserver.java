package pattern.observer;

/**
 * 具体的观察者 个人用户
 */
public class PersonObserver implements IObserver {

    @Override
    public void update(ISubject subject) {
        System.out.println("个人受到高温预警: " + subject.temperatureReport());
    }

}
