package pattern.mediator;

/**
 * ������û�B
 *
 * @author 0xZzzz
 */
public class UserB extends AbstractUser {

    public UserB(IMediator mediator, String name) {
        super(mediator, name);
        //ע�ᵽ�н�����
        mediator.register(this);
    }

    //���ǽ�����Ϣ����
    @Override
    public void receiveMessage(String message) {
        System.out.println(name + "�յ���Ϣ: " + message);
    }

}
