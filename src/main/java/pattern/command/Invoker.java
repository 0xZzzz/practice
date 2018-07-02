package pattern.command;

/**
 * ������
 */
public class Invoker {

    private IPost post;

    public Invoker(IPost post) {
        this.post = post;
    }

    public void sendMail(String mail) {
        System.out.println("�����߿�ʼ�����ʼ�: " + mail);
        this.post.sendMail(mail);
    }
}
