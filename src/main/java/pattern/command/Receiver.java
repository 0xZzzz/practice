package pattern.command;

/**
 * ����Ľ�������
 */
public class Receiver implements IReceiver {

    @Override
    public void receiveMail(String mail) {
        System.out.println("�����߽����ʼ�: " + mail);
    }

}
