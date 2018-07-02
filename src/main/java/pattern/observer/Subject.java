package pattern.observer;

import java.util.Iterator;
import java.util.Vector;

/**
 * ����ı��۲���
 */
public class Subject implements ISubject {

    //�¶�
    private float temperature;

    //Ԥ������
    private String warningLevel;

    //����۲����б�
    private Vector<IObserver> vector;

    //���췽����ʼ���۲����б�
    public Subject() {
        vector = new Vector<IObserver>();
    }

    //���ӹ۲���
    @Override
    public boolean add(IObserver observer) {
        if (observer != null && !vector.contains(observer)) {
            return vector.add(observer);
        }
        return false;
    }

    //�Ƴ��۲���
    @Override
    public boolean remove(IObserver observer) {
        return vector.remove(observer);
    }

    //֪ͨ���й۲���
    @Override
    public void notifyAllObserver() {
        System.out.println("����̨����" + this.warningLevel + "����!");
        Iterator<IObserver> iterator = vector.iterator();
        while (iterator.hasNext()) {
            iterator.next().update(this);
        }
    }

    /**
     * ˽�з���, �����¶�����Ԥ������, Ȼ��֪ͨ���й۲���
     */
    private void invoke() {
        if (this.temperature >= 35) {
            if (this.temperature >= 35 && this.temperature < 37) {
                this.warningLevel = "��ɫ";
            } else if (this.temperature >= 37 && this.temperature < 40) {
                this.warningLevel = "��ɫ";
            } else if (this.temperature >= 40) {
                this.warningLevel = "��ɫ";
            }
            //֪ͨ���й۲����¶����
            this.notifyAllObserver();
        }
    }

    //�����¶�ֵ
    @Override
    public void setTemperature(float temperature) {
        this.temperature = temperature;
        this.invoke();
    }

    //��ȡ�¶��ﾳ
    @Override
    public String temperatureReport() {
        return "�¶�: " + this.temperature;
    }

}
