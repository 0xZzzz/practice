package pattern.chain;

/**
 * ������������
 */
public abstract class AbstractHandler implements IHandler {

    /**
     * ������
     */
    private IHandler handler;
    /**
     * ������
     */
    private int handleState = -1;

    /**
     * ���췽�����ô�����
     *
     * @param handleState ������
     */
    public AbstractHandler(int handleState) {
        this.handleState = handleState;
    }

    //������һ��������
    @Override
    public void setHandler(IHandler handler) {
        this.handler = handler;
    }

    /**
     * �������ฺ�����Ĵ���
     */
    public abstract void Process(IStudent iStudent);

    @Override
    public void handleRequest(IStudent iStudent) {
        if (iStudent != null) {
            if (iStudent.getState() == this.handleState) {
                //�����ټ���͵�ǰ�����ߵĴ�����һ��, ���ɵ�ǰ�����ߴ���
                this.Process(iStudent);
            } else {
                System.out.println("�ϼ�����");
                //�����ǰ�Ĵ����ߴ����˾ͽ�����һ�������ߴ���
                this.handler.handleRequest(iStudent);
            }
        }
    }
}
