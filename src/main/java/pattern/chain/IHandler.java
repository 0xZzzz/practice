package pattern.chain;

/**
 * 处理类抽象接口
 */
public interface IHandler {

    /**
     * 处理请求
     *
     * @param iStudent 学生对象
     */
    void handleRequest(IStudent iStudent);

    /**
     * 设置下一个处理者
     *
     * @param handler 处理者
     */
    void setHandler(IHandler handler);
}
