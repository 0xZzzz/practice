package pattern.decorator.bread;
/**
 * 抽象生产馒头接口
 * @author 69953213
 *
 */
public interface IBread {
	/** 准备材料 */
	void prepare();
	/** 和面 */
	void kneadFlour();
	/** 蒸馒头 */
	void steamed();
	/** 生产过程 */
	void process();
}
