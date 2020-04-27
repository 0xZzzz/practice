package pattern.mediator;

/**
 * 具体用户A
 *
 * @author 0xZzzz
 */
public class UserA extends AbstractUser {

    public UserA(IMediator mediator, String name) {
        super(mediator, name);
        //注册到中介者对象中
        mediator.register(this);
    }

    //覆盖接受消息方法
    @Override
    public void receiveMessage(String message) {
        System.out.println(name + "收到消息: " + message);
    }

}
