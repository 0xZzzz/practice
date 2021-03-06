package pattern.state;

/**
 * 上下文环境
 *
 * @author 0xZzzz
 */
public class Context {

    /**
     * 预览模式
     */
    public static final int PREVIEW_MODE = 0;

    /**
     * 编辑模式
     */
    public static final int EDIT_MODE = 1;

    /**
     * 保存当前状态
     */
    private IState state;

    /**
     * 改变状态
     */
    public void changeState(IState state) {
        this.state = state;
    }

    public void doWork(int mode) {
        System.out.println("---------------------");
        this.state.convertState(this, mode);
        this.state.add(this);
        this.state.save(this);
        this.state.modify(this);
        this.state.view(this);
        System.out.println("---------------------");
    }
}
