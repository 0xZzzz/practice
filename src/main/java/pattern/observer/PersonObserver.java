package pattern.observer;

/**
 * ����Ĺ۲��� �����û�
 */
public class PersonObserver implements IObserver {

    @Override
    public void update(ISubject subject) {
        System.out.println("�����ܵ�����Ԥ��: " + subject.temperatureReport());
    }

}
