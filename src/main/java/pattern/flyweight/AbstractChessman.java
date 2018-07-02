package pattern.flyweight;
/**
 * 抽象棋子基类
 * @author 69953213
 *
 */
public abstract class AbstractChessman {
	/** 棋子类别 */
	protected String chess;
	/** 横坐标 */
	protected int x;
	/** 纵坐标 */
	protected int y;

	public AbstractChessman(String chess) {
		this.chess = chess;
	}
	
	/**
	 * 棋子坐标点
	 * @param x 横坐标
	 * @param y 纵坐标
	 */
	public abstract void point(int x, int y);
	
	public void show(){
		System.out.println(this.chess + "(" + this.x + "," + this.y + ")");
	}
}
