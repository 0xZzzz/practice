package pattern.flyweight;
/**
 * ºÚÉ«Æå×Ó
 * @author 69953213
 *
 */
public class BlackChessman extends AbstractChessman{

	public BlackChessman() {
		super("black");
		System.out.println("blackchessman constructor execute ... ");
	}

	@Override
	public synchronized void point(int x, int y) {
		this.x = x;
		this.y = y;
		this.show();
	}

}
