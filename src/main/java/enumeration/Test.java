package enumeration;

public class Test {
	public static void main(String[] args) {
		SimulateSexEnum male = SimulateSexEnum.MALE;
		System.out.println(male);
		System.out.println(male.negation());
	}
}
