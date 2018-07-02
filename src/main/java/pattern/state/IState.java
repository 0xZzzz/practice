package pattern.state;
/**
 * 状态接口
 */
public interface IState {
	//状态转换
	void convertState(Context context, int mode);
	//保存方法
	void save(Context context);
	//修改方法
	void modify(Context context);
	//新增方法
	void add(Context context);
	//查看方法
	void view(Context context);
}
