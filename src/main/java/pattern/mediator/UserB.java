package pattern.mediator;

/**
 * 具体的用户B
 *
 * @author 0xZzzz
 */
public class UserB extends AbstractUser {

    public UserB(IMediator mediator, String name) {
        super(mediator, name);
        //注册到中介者中
        mediator.register(this);
    }

    //覆盖接受消息方法
    @Override
    public void receiveMessage(String message) {
        System.out.println(name + "收到消息: " + message);
    }

}
