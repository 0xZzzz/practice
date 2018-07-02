package pattern.command;

/**
 * 具体的邮局类
 */
public class Post implements IPost {

    private IReceiver receiver;

    public Post(IReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void sendMail(String mail) {
        System.out.println("邮局发送邮件: " + mail);
        receiver.receiveMail(mail);
    }

}
