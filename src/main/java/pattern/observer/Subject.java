package pattern.observer;

import java.util.Iterator;
import java.util.Vector;

/**
 * 具体的被观察者
 */
public class Subject implements ISubject {

    //温度
    private float temperature;

    //预警级别
    private String warningLevel;

    //保存观察者列表
    private Vector<IObserver> vector;

    //构造方法初始化观察者列表
    public Subject() {
        vector = new Vector<IObserver>();
    }

    //增加观察者
    @Override
    public boolean add(IObserver observer) {
        if (observer != null && !vector.contains(observer)) {
            return vector.add(observer);
        }
        return false;
    }

    //移除观察者
    @Override
    public boolean remove(IObserver observer) {
        return vector.remove(observer);
    }

    //通知所有观察者
    @Override
    public void notifyAllObserver() {
        System.out.println("气象台发布" + this.warningLevel + "警报!");
        Iterator<IObserver> iterator = vector.iterator();
        while (iterator.hasNext()) {
            iterator.next().update(this);
        }
    }

    /**
     * 私有方法, 根据温度设置预警级别, 然后通知所有观察者
     */
    private void invoke() {
        if (this.temperature >= 35) {
            if (this.temperature >= 35 && this.temperature < 37) {
                this.warningLevel = "黄色";
            } else if (this.temperature >= 37 && this.temperature < 40) {
                this.warningLevel = "橙色";
            } else if (this.temperature >= 40) {
                this.warningLevel = "红色";
            }
            //通知所有观察者温度情况
            this.notifyAllObserver();
        }
    }

    //设置温度值
    @Override
    public void setTemperature(float temperature) {
        this.temperature = temperature;
        this.invoke();
    }

    //获取温度语境
    @Override
    public String temperatureReport() {
        return "温度: " + this.temperature;
    }

}
