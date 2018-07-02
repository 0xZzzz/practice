package pattern.observer;

/**
 * ����ӿ� ���۲���
 */
public interface ISubject {

    //��ӹ۲���
    boolean add(IObserver observer);

    //ɾ���۲���
    boolean remove(IObserver observer);

    //֪ͨ���й۲���
    void notifyAllObserver();

    //�����¶�
    void setTemperature(float temperature);

    //����¶�Ԥ��
    String temperatureReport();
}
