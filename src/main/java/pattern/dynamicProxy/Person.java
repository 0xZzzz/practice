package pattern.dynamicProxy;

/**
 * 具体的被代理的对象
 *
 * @author 0xZzzz
 */
public class Person implements Subject {

    private final String name;

    public Person(String name) {
        super();
        this.name = name;
    }

    @Override
    public void doSome() {
        System.out.println(name + "正在做...");
    }

}
