package pattern.mediator;

public class Test {

    public static void main(String[] args) {
        IMediator mediator = new ConcreteMediator();

        IUser userA = new UserA(mediator, "�û�A");
        IUser userB = new UserB(mediator, "�û�B");
        IUser userC = new UserC(mediator, "�û�C");

        userA.sendMessage("�����ǵػ�");
        userB.sendMessage("���������");
        userC.sendMessage("...");

    }
}
