package pattern.command;

/**
 * 具体的接受者类
 */
public class Receiver implements IReceiver {

    @Override
    public void receiveMail(String mail) {
        System.out.println("接受者接受邮件: " + mail);
    }

}
