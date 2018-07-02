package pattern.mediator;

/**
 * �û�����
 */
public abstract class AbstractUser implements IUser {

    //ά���н���
    protected IMediator mediator;

    //����
    protected String name;

    //���͵���Ϣ
    protected String message;

    public AbstractUser(IMediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    //������Ϣ
    @Override
    public void sendMessage(String message) {
        this.message = message;
        System.out.println(name + "˵: " + message);
        mediator.notifyAll(this);
    }

    //���ط��͵���Ϣ
    @Override
    public String getMessage() {
        return message;
    }

}
