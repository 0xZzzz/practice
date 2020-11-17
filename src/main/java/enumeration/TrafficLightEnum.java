package enumeration;

/**
 * 交通灯枚举
 *
 * @author 0xZzzz
 */
public enum TrafficLightEnum {

    /**
     * 红灯
     */
    RED(30) {
        @Override
        public TrafficLightEnum next() {
            return GREEN;
        }
    },

    /**
     * 黄灯
     */
    GREEN(30) {
        @Override
        public TrafficLightEnum next() {
            return YELLOW;
        }
    },

    /**
     * 红灯
     */
    YELLOW(5) {
        @Override
        public TrafficLightEnum next() {
            return RED;
        }
    };

    /**
     * 下一个灯
     *
     * @return next light enum
     */
    public abstract TrafficLightEnum next();

    /**
     * 交通灯时间
     */
    private int time;

    /**
     * 私有的带参数的构造方法
     */
    TrafficLightEnum(int time) {
        this.time = time;
    }
}
