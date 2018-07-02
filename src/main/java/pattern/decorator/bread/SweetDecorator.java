package pattern.decorator.bread;

/**
 * 甜蜜素装饰者
 */
public class SweetDecorator extends AbstractBread {

    public SweetDecorator(IBread bread) {
        super(bread);
    }

    /**
     * 特有方法 添加甜蜜素
     */
    public void paint() {
        System.out.println("添加甜蜜素");
    }

    //重写父类的和面方法  添加甜蜜素后再和面
    @Override
    public void kneadFlour() {
        this.paint();
        super.kneadFlour();
    }
}
