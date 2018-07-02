package pattern.mediator;

/**
 * ������û�C
 *
 * @author 0xZzzz
 */
public class UserC extends AbstractUser {

    public UserC(IMediator mediator, String name) {
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
