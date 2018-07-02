package pattern.memento;

public class Test {

    public static void main(String[] args) {
        //������ɫ
        Hero hero = new Hero();
        //����������
        Caretaker caretaker = new Caretaker();
        //������սǰӢ�۵�״̬
        caretaker.setMemento(hero.createMemento());
        //��������սboss�Ļ���
        int cnt = 1;
        //������սboss�Ľ��
        int ko = -1;
        while (ko != 1 && cnt <= 3) {
            System.out.println("��" + cnt + "����ս��ʼ...");
            //��ʼ��սboss
            ko = hero.koBoss();
            while (true) {
                if (ko == -1) {
                    //��սʧ��, �ӱ���¼�������лָ�����¼��״̬, �ۼ���ս����
                    hero.restoreFromMemento(caretaker.getMemento());
                    cnt += 1;
                    break;
                } else if (ko == 0) {
                    //������ս
                    ko = hero.koBoss();
                } else if (ko == 1) {
                    //��ս�ɹ�
                    break;
                }
            }
        }
    }
}
