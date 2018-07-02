package pattern.mediator;

/**
 * �����û�A
 *
 * @author 0xZzzz
 */
public class UserA extends AbstractUser {

    public UserA(IMediator mediator, String name) {
        super(mediator, name);
        //ע�ᵽ�н��߶�����
        mediator.register(this);
    }

    //���ǽ�����Ϣ����
    @Override
    public void receiveMessage(String message) {
        System.out.println(name + "�յ���Ϣ: " + message);
    }

}
