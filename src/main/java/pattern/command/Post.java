package pattern.command;

/**
 * ������ʾ���
 */
public class Post implements IPost {

    private IReceiver receiver;

    public Post(IReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void sendMail(String mail) {
        System.out.println("�ʾַ����ʼ�: " + mail);
        receiver.receiveMail(mail);
    }

}
