package pattern.mediator;

/**
 * 用户接口
 * @author 69953213
 *
 */
public interface IUser {
	/**
	 * 发送消息
	 * @param message 消息内容
	 */
	void sendMessage(String message);
	
	/**
	 * 接受消息
	 * @param message 消息内容
	 */
	void receiveMessage(String message);
	
	/**
	 * 获取发送的消息
	 */
	String getMessage();
}
