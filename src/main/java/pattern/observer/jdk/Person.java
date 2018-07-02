package pattern.observer.jdk;

import java.util.Observable;
import java.util.Observer;

/**
 * 具体的观察者对象
 * @author ZQ
 *
 */
public class Person implements Observer{
	private String name;
	
	public Person(String name){
		this.name = name;
	}
	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof Doll){
			Doll doll = (Doll)o;
			System.out.println(name+"关注的娃娃价格已经更新为: "+doll.getPrice());
		}
	}
}
