package enumeration;
/**
 * 交通灯枚举
 * @author 69953213
 *
 */
public enum TrafficLightEnum {
	RED(30){
		@Override
		public TrafficLightEnum next() {
			return GREEN;
		}
	}, 
	GREEN(30){
		@Override
		public TrafficLightEnum next() {
			return YELLOW;
		}
	}, 
	YELLOW(5){
		@Override
		public TrafficLightEnum next() {
			return RED;
		}
	};
	//下一个灯
	public abstract TrafficLightEnum next();
	
	/** 交通灯时间 */
	private int time;
	
	/** 私有的带参数的构造方法 */
	private TrafficLightEnum(int time){
		this.time = time;
	}
}
