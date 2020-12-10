package pattern.memento;

import java.util.Random;

/**
 * 英雄对象
 *
 * @author 0xZzzz
 */
public class Hero {

    /**
     * 血量
     */
    private int hp;

    /**
     * 武力值
     */
    private int sword;

    private final Random random = new Random();

    public Hero() {
        // 初始化100点血量和100点武力值
        this.hp = 100;
        this.sword = 100;
    }

    /**
     * 创建备忘录
     *
     * @return 备忘录对象
     */
    public INarrowMemento createMemento() {
        System.out.println("创建备忘录...");
        return new Memento(this.hp, this.sword);
    }

    /**
     * 打boss
     *
     * @return 攻击boss的结果
     */
    public int koBoss() {
        // 当 hp <= 0 时, 挑战失败, 假设战胜boss的概率为3%
        // 判断时候还有武力值
        if (this.hp <= 0 || this.sword <= 0) {
            System.out.println(this.toString());
            System.out.println("挑战boss失败");
            return -1;
        } else {
            double win = Math.random();
            System.out.println(this.toString());
            if (win <= 0.03) {
                System.out.println("战胜boss!");
                return 1;
            } else {
                System.out.println("继续攻击boss...");
                // 随机数, 减少血量值和武力值, 继续攻击boss
                int hpSub = random.nextInt(10);
                int swordSub = random.nextInt(10);
                this.hp -= hpSub;
                this.sword -= swordSub;
                return 0;
            }
        }
    }

    /**
     * 从备忘录保存的状态恢复
     *
     * @param memento 待恢复的备忘录
     */
    public void restoreFromMemento(INarrowMemento memento) {
        System.out.println("恢复备忘录中的状态...");
        if (memento != null) {
            Memento mementoImpl = (Memento) memento;
            this.hp = mementoImpl.getHp();
            this.sword = mementoImpl.getSword();
        }
    }

    @Override
    public String toString() {
        return "Hero [hp=" + hp + ", sword=" + sword + "]";
    }

    /**
     * 备忘录(整个类时私有的, 只有发起者才能访问)
     *
     * @author 0xZzzz
     */
    private static class Memento implements INarrowMemento {
        // 备忘录属性用final修饰  初始化之后是不可以被修改的
        // 血量
        private final int hp;
        // 武力
        private final int sword;

        private Memento(int hp, int sword) {
            this.hp = hp;
            this.sword = sword;
        }

        private int getHp() {
            return hp;
        }

        private int getSword() {
            return sword;
        }

    }

}
