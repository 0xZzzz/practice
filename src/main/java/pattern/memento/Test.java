package pattern.memento;

public class Test {

    public static void main(String[] args) {
        //创建角色
        Hero hero = new Hero();
        //创建管理者
        Caretaker caretaker = new Caretaker();
        //保存挑战前英雄的状态
        caretaker.setMemento(hero.createMemento());
        //有三次挑战boss的机会
        int cnt = 1;
        //保存挑战boss的结果
        int ko = -1;
        while (ko != 1 && cnt <= 3) {
            System.out.println("第" + cnt + "次挑战开始...");
            //开始挑战boss
            ko = hero.koBoss();
            while (true) {
                if (ko == -1) {
                    //挑战失败, 从备忘录管理者中恢复备忘录的状态, 累加挑战次数
                    hero.restoreFromMemento(caretaker.getMemento());
                    cnt += 1;
                    break;
                } else if (ko == 0) {
                    //继续挑战
                    ko = hero.koBoss();
                } else if (ko == 1) {
                    //挑战成功
                    break;
                }
            }
        }
    }
}
