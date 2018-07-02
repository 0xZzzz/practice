package pattern.command;

/**
 * 邮局接口
 */
public interface IPost {

    /**
     * 邮局接口 发送消息
     *
     * @param mail 消息内容
     */
    void sendMail(String mail);
}
