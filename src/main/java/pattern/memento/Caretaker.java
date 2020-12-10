package pattern.memento;

/**
 * 备忘录管理者(只接受备忘录窄接口)
 *
 * @author 0xZzzz
 */
public class Caretaker {

    private INarrowMemento memento;

    public INarrowMemento getMemento() {
        return memento;
    }

    public void setMemento(INarrowMemento memento) {
        this.memento = memento;
    }

}
