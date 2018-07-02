package pattern.decorator.bread;

/**
 * 被装饰者 正常馒头
 */
public class NormalBread implements IBread {

    @Override
    public void prepare() {
        System.out.println("装备材料");
    }

    @Override
    public void kneadFlour() {
        System.out.println("和面");
    }

    @Override
    public void steamed() {
        System.out.println("蒸馒头");
    }

    @Override
    public void process() {
        this.prepare();
        this.kneadFlour();
        this.steamed();
    }

}
