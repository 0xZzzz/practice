package pattern.memento;
/**
 * ����¼������(ֻ���ܱ���¼խ�ӿ�)
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
