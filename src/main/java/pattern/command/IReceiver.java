package pattern.command;

/**
 * 接受者接口
 *
 * @author 0xZzzz
 */
public interface IReceiver {

    /**
     * 接受消息
     *
     * @param mail 消息内容
     */
    void receiveMail(String mail);
}
