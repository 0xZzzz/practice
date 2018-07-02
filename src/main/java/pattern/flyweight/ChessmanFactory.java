package pattern.flyweight;

import java.util.Hashtable;

/**
 * ���ӹ���
 *
 * @author 0xZzzz
 */
public class ChessmanFactory {

    //ά�����ӵĻ���
    private final Hashtable<String, AbstractChessman> cache = new Hashtable<String, AbstractChessman>();

    //����ʽ����
    private static ChessmanFactory chessmanFactory = new ChessmanFactory();

    //˽�й��췽��
    private ChessmanFactory() {
    }

    //������
    public static ChessmanFactory getInstance() {
        return chessmanFactory;
    }

    /**
     * ��ȡ���� �û���������Ӷ���
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
