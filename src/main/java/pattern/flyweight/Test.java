package pattern.flyweight;

public class Test {
	public static void main(String[] args) {
		ChessmanFactory chessmanFactory = ChessmanFactory.getInstance();
		AbstractChessman chessman = null;
		for (int i = 0; i < 10; i++) {
			int chessmanFlag = (int)(Math.random()*2);
			switch (chessmanFlag) {
			case 0:
				chessman = chessmanFactory.getChessman("W");
				break;
			case 1:
				chessman = chessmanFactory.getChessman("B");
			}
			if(chessman != null){
				chessman.point(i, (int)(Math.random()*10));
			}
		}
	}
}
