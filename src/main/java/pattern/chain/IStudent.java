package pattern.chain;

/**
 * 学生请假接口
 */
public interface IStudent {

    /**
     * 获取请假的级别
     */
    int getState();

    /**
     * 发送请假消息
     */
    String getRequestMessage();
}
