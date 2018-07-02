package pattern.mediator;
/**
 * 中介者接口
 * @author 69953213
 *
 */
public interface IMediator {
	/**
	 * 用户注册
	 * @param user 注册的用户
	 */
	void register(IUser user);
	
	/**
	 * 发消息通知所有人
	 * @param user 发送消息的人
	 */
	void notifyAll(IUser user);
}
