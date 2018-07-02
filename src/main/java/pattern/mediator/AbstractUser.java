package pattern.mediator;

/**
 * 用户基类
 */
public abstract class AbstractUser implements IUser {

    //维护中介者
    protected IMediator mediator;

    //姓名
    protected String name;

    //发送的消息
    protected String message;

    public AbstractUser(IMediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    //发送消息
    @Override
    public void sendMessage(String message) {
        this.message = message;
        System.out.println(name + "说: " + message);
        mediator.notifyAll(this);
    }

    //返回发送的消息
    @Override
    public String getMessage() {
        return message;
    }

}
