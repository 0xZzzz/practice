package pattern.bridge;

/**
 * 抽象点灯接口
 *
 * @author 0xZzzz
 */
public interface ILight {

    /**
     * 电源连接
     */
    void electricConnected();

    /**
     * 照明
     */
    void light();

    /**
     * 关闭
     */
    void electricClosed();
}
