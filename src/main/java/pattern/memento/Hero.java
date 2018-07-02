package pattern.memento;

import java.util.Random;

/**
 * Ӣ�۶���
 */
public class Hero {

    //Ѫ��
    private int hp;

    //����ֵ
    private int sword;

    //�����
    private final Random random = new Random();

    //���췽����ʼ������ֵ
    public Hero() {
        //��ʼ��100��Ѫ����100������ֵ
        this.hp = 100;
        this.sword = 100;
    }

    /**
     * ��������¼
     *
     * @return ����¼����
     */
    public INarrowMemento createMemento() {
        System.out.println("��������¼...");
        return new Memento(this.hp, this.sword);
    }

    /**
     * ��boss
     *
     * @return ����boss�Ľ��
     */
    public int koBoss() {
        //��ѪҺ֮<=0ʱ, ��սʧ��, ����սʤboss�ĸ���Ϊ3%
        //�ж�ʱ��������ֵ
        if (this.hp <= 0 || this.sword <= 0) {
            System.out.println(this.toString());
            System.out.println("��սbossʧ��");
            return -1;
        } else {
            double win = Math.random();
            if (win <= 0.03) {
                System.out.println(this.toString());
                System.out.println("սʤboss!");
                return 1;
            } else {
                System.out.println(this.toString());
                System.out.println("��������boss...");
                //�����, ����Ѫ��ֵ������ֵ, ��������boss
                int hp_sub = random.nextInt(10);
                int sword_sub = random.nextInt(10);
                this.hp -= hp_sub;
                this.sword -= sword_sub;
                return 0;
            }
        }
    }

    /**
     * �ӱ���¼�����״̬�ָ�
     *
     * @param memento ���ָ��ı���¼
     */
    public void restoreFromMemento(INarrowMemento memento) {
        System.out.println("�ָ�����¼�е�״̬...");
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
     * ����¼(������ʱ˽�е�, ֻ�з����߲��ܷ���)
     */
    private class Memento implements INarrowMemento {
        //����¼������final����  ��ʼ��֮���ǲ����Ա��޸ĵ�
        //Ѫ��
        private final int hp;
        //����
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
