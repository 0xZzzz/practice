package pattern.observer.jdk;

public class Test {

    public static void main(String[] args) {
        Doll doll = new Doll(3000);
        Person p1 = new Person("p1");
        Person p2 = new Person("p2");
        doll.addObserver(p1);
        doll.addObserver(p2);
        System.out.println("��һ�ִ���");
        doll.setPrice(2998.0);
        System.out.println("�ڶ��ִ���");
        doll.setPrice(1998.0);
    }
}
