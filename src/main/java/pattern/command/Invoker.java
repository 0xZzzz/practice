package pattern.command;

/**
 * 发送者
 */
public class Invoker {

    private IPost post;

    public Invoker(IPost post) {
        this.post = post;
    }

    public void sendMail(String mail) {
        System.out.println("发送者开始发送邮件: " + mail);
        this.post.sendMail(mail);
    }
}
