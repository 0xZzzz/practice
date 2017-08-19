package enumeration;
/**
 * ��ͨ��ö��
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
	//��һ����
	public abstract TrafficLightEnum next();
	
	/** ��ͨ��ʱ�� */
	private int time;
	
	/** ˽�еĴ������Ĺ��췽�� */
	private TrafficLightEnum(int time){
		this.time = time;
	}
}
