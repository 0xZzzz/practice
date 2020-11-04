package pattern.state;

/**
 * 状态接口
 *
 * @author 0xZzzz
 */
public interface IState {

    /**
     * 状态转换
     *
     * @param context 上下文对象
     * @param mode    状态模式
     */
    void convertState(Context context, int mode);

    /**
     * 保存方法
     *
     * @param context 上下文对象
     */
    void save(Context context);

    /**
     * 修改方法
     *
     * @param context 上下文对象
     */
    void modify(Context context);

    /**
     * 新增方法
     *
     * @param context 上下文对象
     */
    void add(Context context);

    /**
     * 查看方法
     *
     * @param context 上下文对象
     */
    void view(Context context);
}
