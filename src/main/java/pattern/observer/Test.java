package pattern.observer;

import java.util.Random;

public class Test {
	public static void main(String[] args) {
		ISubject subject = new Subject();
		subject.add(new PersonObserver());
		Random random = new Random();
		int i = 0;
		while (++i < 10) {
			subject.setTemperature(random.nextInt(45));
		}
	}
}
