package pattern.chain;

/**
 * 班长处理者
 */
public class MonitorLeaderHandler extends AbstractHandler {

    public MonitorLeaderHandler() {
        super(0);
    }

    @Override
    public void Process(IStudent iStudent) {
        System.out.println("班长审批: " + iStudent.getRequestMessage());
    }

}
