package pattern.state;

/**
 * 预览模式
 *
 * @author 0xZzzz
 */
public class PreviewState implements IState {

    @Override
    public void convertState(Context context, int mode) {
        if (mode == Context.EDIT_MODE) {
            context.changeState(new EditState());
        }
    }

    @Override
    public void save(Context context) {
        System.out.println("预览模式不支持[保存]功能!");
    }

    @Override
    public void modify(Context context) {
        System.out.println("预览模式不支持[修改]功能!");
    }

    @Override
    public void add(Context context) {
        System.out.println("预览模式不支持[新增]功能!");
    }

    @Override
    public void view(Context context) {
        System.out.println("预览模式[查看]...");
    }

}
