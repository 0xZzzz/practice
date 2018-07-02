package pattern.chain;

/**
 * ������
 */
public class ProcessHandler {

    private final IHandler monitorLeaderHandler;
    private final IHandler teacherHandler;
    private final IHandler headmasterHandler;

    //����ģʽ
    private static ProcessHandler processHandler = new ProcessHandler();

    private ProcessHandler() {
        this.monitorLeaderHandler = new MonitorLeaderHandler();
        this.teacherHandler = new TeacherHandler();
        this.headmasterHandler = new HeadmasterHandler();

        this.monitorLeaderHandler.setHandler(teacherHandler);
        this.teacherHandler.setHandler(headmasterHandler);
    }

    /**
     * �ṩΨһ��ȡ����ӿ�
     *
     * @return ��������
     */
    public static ProcessHandler getInstance() {
        return processHandler;
    }

    /**
     * ���������Ϣ
     */
    public void sendMessage(IStudent iStudent) {
        this.monitorLeaderHandler.handleRequest(iStudent);
    }
}
