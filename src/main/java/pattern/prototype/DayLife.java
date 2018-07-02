package pattern.prototype;
/**
 * 原型对象(一天的生活)
 * @author 69953213
 *
 */
public class DayLife implements Cloneable{
	/** 起床 */
	private String getUp;
	/** 做公交 */
	private String byBus;
	/** 买早餐 */
	private String buyFood;
	/** 午休 */
	private String noon;
	/** 下午工作 */
	private String afterNoon;
	/** 下班回家 */
	private String goHome;
	/** 夜间娱乐 */
	private String night;
	
	@Override
	public String toString() {
		return "DayLife [getUp=" + getUp + ", byBus=" + byBus + ", buyFood="
				+ buyFood + ", noon=" + noon + ", afterNoon=" + afterNoon
				+ ", goHome=" + goHome + ", night=" + night + "]";
	}
	public String getGetUp() {
		return getUp;
	}
	public void setGetUp(String getUp) {
		this.getUp = getUp;
	}
	public String getByBus() {
		return byBus;
	}
	public void setByBus(String byBus) {
		this.byBus = byBus;
	}
	public String getBuyFood() {
		return buyFood;
	}
	public void setBuyFood(String buyFood) {
		this.buyFood = buyFood;
	}
	public String getNoon() {
		return noon;
	}
	public void setNoon(String noon) {
		this.noon = noon;
	}
	public String getAfterNoon() {
		return afterNoon;
	}
	public void setAfterNoon(String afterNoon) {
		this.afterNoon = afterNoon;
	}
	public String getGoHome() {
		return goHome;
	}
	public void setGoHome(String goHome) {
		this.goHome = goHome;
	}
	public String getNight() {
		return night;
	}
	public void setNight(String night) {
		this.night = night;
	}
	
	/**
	 * 打印对象
	 */
	public void print(){
		System.out.println(this.toString());
	}
	
	@Override
	protected DayLife clone() throws CloneNotSupportedException {
		return (DayLife)super.clone();
	}
}
