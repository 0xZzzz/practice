package pattern.chain;

/**
 * 责任链
 */
public class ProcessHandler {

    private final IHandler monitorLeaderHandler;
    private final IHandler teacherHandler;
    private final IHandler headmasterHandler;

    //单例模式
    private static ProcessHandler processHandler = new ProcessHandler();

    private ProcessHandler() {
        this.monitorLeaderHandler = new MonitorLeaderHandler();
        this.teacherHandler = new TeacherHandler();
        this.headmasterHandler = new HeadmasterHandler();

        this.monitorLeaderHandler.setHandler(teacherHandler);
        this.teacherHandler.setHandler(headmasterHandler);
    }

    /**
     * 提供唯一获取对象接口
     *
     * @return 单例对象
     */
    public static ProcessHandler getInstance() {
        return processHandler;
    }

    /**
     * 发送请假消息
     */
    public void sendMessage(IStudent iStudent) {
        this.monitorLeaderHandler.handleRequest(iStudent);
    }
}
