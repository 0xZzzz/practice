package pattern.prototype;
/**
 * 抽象原型工厂
 * @author 69953213
 *
 */
public interface ILifeFactory {
	/**
	 * 生产原型对象
	 * @return 原型对象
	 */
	DayLife newInstance();
}
