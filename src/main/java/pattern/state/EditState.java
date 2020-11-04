package pattern.state;

/**
 * 编辑模式状态
 *
 * @author 0xZzzz
 */
public class EditState implements IState {

    @Override
    public void convertState(Context context, int mode) {
        if (mode == Context.PREVIEW_MODE) {
            context.changeState(new PreviewState());
        }
    }

    @Override
    public void save(Context context) {
        System.out.println("编辑模式[保存]...");
    }

    @Override
    public void modify(Context context) {
        System.out.println("编辑模式[修改]...");
    }

    @Override
    public void add(Context context) {
        System.out.println("编辑模式[新增]...");
    }

    @Override
    public void view(Context context) {
        System.out.println("编辑模式[查看]...");
    }

}
