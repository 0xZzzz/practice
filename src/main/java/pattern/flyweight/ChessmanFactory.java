package pattern.flyweight;

import java.util.Hashtable;

/**
 * 棋子工厂
 *
 * @author 0xZzzz
 */
public class ChessmanFactory {

    //维护棋子的缓存
    private final Hashtable<String, AbstractChessman> cache = new Hashtable<String, AbstractChessman>();

    //饿汉式单例
    private static ChessmanFactory chessmanFactory = new ChessmanFactory();

    //私有构造方法
    private ChessmanFactory() {
    }

    //饿汉试
    public static ChessmanFactory getInstance() {
        return chessmanFactory;
    }

    /**
     * 获取棋子 用缓存服用棋子对象
     *
     * @param chessmanType
     * @return
     */
    public AbstractChessman getChessman(String chessmanType) {
        AbstractChessman chessman = cache.get(chessmanType);
        if (chessman == null) {
            if ("B".equals(chessmanType)) {
                chessman = new BlackChessman();
            } else if ("W".equals(chessmanType)) {
                chessman = new WhiteChessman();
            }
            if (chessman != null) {
                cache.put(chessmanType, chessman);
            }
        }
        return chessman;
    }
}
