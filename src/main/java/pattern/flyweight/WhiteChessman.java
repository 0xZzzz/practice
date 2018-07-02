package pattern.flyweight;

/**
 * °×É«Æå×Ó
 *
 * @author 0xZzzz
 */
public class WhiteChessman extends AbstractChessman {

    public WhiteChessman() {
        super("white");
        System.out.println("whitechessman constructor execute ...");
    }

    @Override
    public synchronized void point(int x, int y) {
        this.x = x;
        this.y = y;
        this.show();
    }

}
