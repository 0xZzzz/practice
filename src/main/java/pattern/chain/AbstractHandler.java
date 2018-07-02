package pattern.chain;

/**
 * 抽象处理请求类
 */
public abstract class AbstractHandler implements IHandler {

    /**
     * 处理者
     */
    private IHandler handler;
    /**
     * 处理级别
     */
    private int handleState = -1;

    /**
     * 构造方法设置处理级别
     *
     * @param handleState 处理级别
     */
    public AbstractHandler(int handleState) {
        this.handleState = handleState;
    }

    //设置下一个处理者
    @Override
    public void setHandler(IHandler handler) {
        this.handler = handler;
    }

    /**
     * 交由子类负责具体的处理
     */
    public abstract void Process(IStudent iStudent);

    @Override
    public void handleRequest(IStudent iStudent) {
        if (iStudent != null) {
            if (iStudent.getState() == this.handleState) {
                //如果请假级别和当前处理者的处理级别一致, 就由当前处理者处理
                this.Process(iStudent);
            } else {
                System.out.println("上级处理");
                //如果当前的处理者处理不了就交由下一个处理者处理
                this.handler.handleRequest(iStudent);
            }
        }
    }
}
