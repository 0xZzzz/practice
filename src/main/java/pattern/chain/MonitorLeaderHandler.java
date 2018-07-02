package pattern.chain;

/**
 * �೤������
 */
public class MonitorLeaderHandler extends AbstractHandler {

    public MonitorLeaderHandler() {
        super(0);
    }

    @Override
    public void Process(IStudent iStudent) {
        System.out.println("�೤����: " + iStudent.getRequestMessage());
    }

}
