package pattern.flyweight;
/**
 * �������ӻ���
 * @author 69953213
 *
 */
public abstract class AbstractChessman {
	/** ������� */
	protected String chess;
	/** ������ */
	protected int x;
	/** ������ */
	protected int y;

	public AbstractChessman(String chess) {
		this.chess = chess;
	}
	
	/**
	 * ���������
	 * @param x ������
	 * @param y ������
	 */
	public abstract void point(int x, int y);
	
	public void show(){
		System.out.println(this.chess + "(" + this.x + "," + this.y + ")");
	}
}
